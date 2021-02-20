/**
 * Used to create an employee
 * @author Malav Doshi and Herik Patel
 */
public class Employee {

    /**
     * profile object to store employee info
     */
    Profile profile;

    /**
     * Constructor for class Employee
     */
    public Employee(){
    }


    /**
     *Constructor for class Employee used to instantiate values
     * @author Malav Doshi and Herik Patel
     * @param profileIn Profile which we want to assign the object to
     */
    public Employee(Profile profileIn){
        profile = new Profile(profileIn.getName(), profileIn.getDepartment(), profileIn.getDateHired());
    }

    /**
     *This method is overridden in child classes
     */
    public void calculatePayment() { }


    /**
     * This method is used to check that we are not entering a employee multiple times
     * @author Malav Doshi and Herik Patel
     * @param obj Object which we want to compare to.
     * @return true if employee already exist else return false
     */
    @Override
    public boolean equals(Object obj){

        if(obj == null){
            return false;
        }

        if(!(obj instanceof Employee)){
            return false;
        }

        Employee emp = (Employee) obj;

        if((emp.profile.getName().equals(this.profile.getName())) && (emp.profile.getDepartment().equals(this.profile.getDepartment())) && (emp.profile.getDateHired().compareTo(this.profile.getDateHired())) == 0){
            return true;
        }

        return false;
    }


    /**
     * Used to convert fields like name, department, date hired to string
     * @author Malav Doshi and Herik Patel
     * @return String value of fields like name,department and date hired
     */
    @Override
    public String toString(){
        return profile.getName() + "::" + profile.getDepartment() + "::" + profile.getDateHired().getMonth() + "/" + profile.getDateHired().getDay() + "/" + profile.getDateHired().getYear();
    }
}
