/**
 * This is the database class of all the employees
 * @author Malav Doshi and Herik Patel
 */
public class Company {

    /**
     * Array that stores data about Employees
     */
    private Employee[] emplist;

    /**
     * Integer value to keep track length of emplist
     */
    private int numEmployee;

    /**
     * Constructor which is used to instantiate emplist array which stores Employee data
     */
    public Company(){
        emplist = new Employee[4];
        numEmployee = 0;
    }

    /**
     * This method is used to find index for data type Employee which is stored in the array
     * @param employee An Employee data type which we want to locate in array
     * @return index of the result or -1 if the element is not in the array
     */
    private int find(Employee employee) {
        int i;
        for(i=0;i<numEmployee;i++){
            if(emplist[i].equals(employee)){
                return i;
            }
        }

        return -1; //This means book not found in the lib.
    }

    /**
     * This methods is used to increase the size of the array by 4
     * @author Malav Doshi and Herik Patel
     */
    private void grow() {

        Employee[] temp = new Employee[emplist.length + 4]; //Declare and initialize a temp array of length +4 than original one
        int i;

        for(i=0;i < emplist.length;i++){
            temp[i] = emplist[i]; //Transfer elements to the new array
        }

         emplist = temp; //Give the reference of the new array to the original array
    }

    /**
     * This method is used to add employee to the array which data for all employees
     * @author Malav Doshi and Herik Patel
     * @param employee It is of type Employee which has to be added to the array
     * @return true if employee is added to the array or returns false which means employee is already in the array
     */
    public boolean add(Employee employee) { //check the profile before adding

//        Fulltime fObj = new Fulltime();
//        if(fObj.equals(emplist[numEmployee])){
//            System.out.println("A FT");
//        }
//        Fulltime f = (Fulltime) emplist[numEmployee];
//        System.out.println(f.salary);

        if(numEmployee == 0){
            emplist[0] = employee;
            numEmployee++;
            return true;
        }

        int index = find(employee);


        if(index!=-1 && ((emplist[index].equals(employee)))){
            return false;
        }

        if(numEmployee == emplist.length){
            grow();
        }

        emplist[numEmployee]  = employee;
        numEmployee++;

        return true;
    }

    /**
     *Removes an Employee from the the array if employee is not in the array it returns false
     * @author Malav Doshi and Herik Patel
     * @param employee Employee object which has to be removed
     * @return True if employee is removed form the array else returns False
     */
    public boolean remove(Employee employee) {//maintain the original sequence

        int NOT_FOUND = -1;

        int index = find(employee);

        if(index == NOT_FOUND){
            return false;
        }
        if (index==numEmployee-1) {
            numEmployee--;
            return true;
        }

        for(int i=index;i<numEmployee-1;i++)   // Overwriting the values in the array to remove particular book
        {
            Employee tempEmployee = new Employee();
            tempEmployee=emplist[i+1];
            emplist[i]=tempEmployee;
        }
        numEmployee--;

        return true;
    }

    /**
     * This method is used to set working hours for employee
     * @author Malav Doshi and Herik Patel
     * @param employee Employee whose hours we need to set
     * @return true after hours are set for employee or returns false if employee is not in the array
     */

    public boolean setHours(Employee employee) { //set working hours for a part time

        int NOT_FOUND = -1;
        int index = find(employee);

        if(index == NOT_FOUND){
            return false;
        }

        Parttime temp = (Parttime) employee;

        Parttime parttime = (Parttime) emplist[index];
        parttime.setHours(temp.getHours());

        return true;
    }

    /**
     *This is used to calculate the payments for each employee in the database
     * @author Malav Doshi and Herik Patel
     */
    public void processPayments() { //process payments for all employees
        int i;

        for(i = 0; i < numEmployee; i++){
            emplist[i].calculatePayment();
        }
    }

    /**
     * Prints the database of the employees in its current order
     * @author Herik Patel anf Malav Doshi
     */
    public void print() {
        System.out.println("--Printing Earning statements for all employees--");
        int i;
        for(i = 0; i < numEmployee; i++){
            System.out.println(emplist[i].toString());
        }
    } //print earning statements for all employees

    /**
     *Prints the earning statement of the employees in the order of their department
     * @author Malav Doshi and Herik Patel
     */
    public void printByDepartment() {
        int i,j;

        System.out.println("--Printing earning statements by department--");

        for(i = 0; i < numEmployee - 1; i++){

            for(j = i + 1; j < numEmployee; j++){

                if(emplist[i].profile.getDepartment().compareTo(emplist[j].profile.getDepartment()) > 0){

                    Employee temp = emplist[i];
                    emplist[i] = emplist[j];
                    emplist[j] = temp;

                }
            }
        }

        for(i = 0; i < numEmployee; i++){
            System.out.println(emplist[i].toString());
        }
    } //print earning statements by department

    /**
     *Prints the earning statement of the employees in the order of their date hired
     * @author Malav Doshi and Herik Patel
     */
    public void printByDate() {
        emplist=sortedarray();
        System.out.println("--Printing earning statements by department--");
        for(int i = 0; i < numEmployee; i++){
            System.out.println(emplist[i].toString());
        }
    }
    /**
     * Used to sort the Employee array by date
     * @return Employee array which is sorted by dates
     */
    private Employee[] sortedarray() //Returns an sorted array
    {
        Employee[] temp = emplist;
        Employee swap_obj = new Employee();
        String date1="";
        String date2="";
        Employee tempEmployee = new Employee();

        int min_index;
        for(int i=0;i<numEmployee-1;i++)
        {
            min_index=i;
            for (int j=i+1;j<numEmployee;j++ )
            {
                date1 = checkDate(min_index,temp);  // Takes the date and turns it into a string value
                date2 = checkDate(j,temp);
                //  date2=""+temp[j].getDatePublished().getYear()+temp[j].getDatePublished().getMonth()+temp[j].getDatePublished().getDay();
                int int_date1= Integer.parseInt(date1);
                int int_date2= Integer.parseInt(date2);
                if(int_date2<int_date1)
                {
                    min_index=j;
                }

            }
            tempEmployee = temp[min_index];
            temp[min_index]=temp[i];
            temp[i]=tempEmployee;
        }

        return temp;
    }
    /**
     * Used to check date and return it as a String value
     * @param index Index of the array
     * @param temp Temporary Employee array
     * @return String value of date
     */
    private String checkDate(int index,Employee[] temp)
    {
        String date_to_string = ""+temp[index].profile.getDateHired().getYear();
        if(temp[index].profile.getDateHired().getMonth()<10)
        {
            date_to_string=date_to_string+"0"+temp[index].profile.getDateHired().getMonth();
        }
        else
        {
            date_to_string=date_to_string+temp[index].profile.getDateHired().getMonth();
        }
        if(temp[index].profile.getDateHired().getDay()<10)
        {
            date_to_string=date_to_string+"0"+temp[index].profile.getDateHired().getDay();
        }
        else
        {
            date_to_string=date_to_string+temp[index].profile.getDateHired().getDay();
        }
        return date_to_string;
    }
    /**
     * @author Malav Doshi and Herik Patel
     * @return The number of employees in the database
     */
    public int getNumEmployee(){
        return numEmployee;
    }
}
