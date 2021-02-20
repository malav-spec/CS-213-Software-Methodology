/**
 * used to create a Management employee
 * @author Malav Doshi and herik Patel
 */
public class Management extends Fulltime{
    /**
     * Represents Payment given to employee
     */
    private double payment = 0;
    /**
     * Represents role of the employee
     */
    private int role;
    /**
     * Represents compensation given to employee
     */
    private double compensation;

    /**
     *Constructor for the class Management
     */
    public Management(){
    }

    /**
     *Constructor used to instantiate values
     * @param profile profile of the employee
     * @param salary Salary of the employee
     * @param role Role of the management employee
     */
    public Management(Profile profile, double salary, int role) {
        super(profile, salary);
        this.role = role;
    }

    /**
     *This method is used to round off a number to two decimal places
     * @param number Value which we want to round off
     * @return value after rounding off the number
     */
    public double roundOff(double number){ //rounds off a number to two decimal places
        return Math.round(number * 100.0) / 100.0;
    }

    /**
     * This method is used to calculate compensation for employee
     */
    @Override
    public void calculatePayment() {

        double manager_comp = 5000.0, deptHead_comp = 9500.0, director_comp = 12000.0;
        double salary = super.getSalary();
        int pay_periods = 26;
        double hundred = 100.0;

        payment = salary / pay_periods;
        payment = Math.round(payment * hundred) / hundred; //Round off to two decimal places

        if(role == 1){
            compensation = roundOff(manager_comp / 26);
            payment += compensation;
        }
        else if(role == 2){
            compensation = roundOff(deptHead_comp / 26);
            payment += compensation;
        }
        else{
            compensation = roundOff(director_comp / 26);
            payment += compensation;
        }
    }


    /**
     * This method is used to compare objects to see if the employee is already present in the database
     * @param obj Object to be compared
     * @return True if obj is same as the compared object. False otherwise.
     */
    @Override
    public boolean equals(Object obj){

        if(obj instanceof Management){
            return super.equals(obj);
        }
        return false;
    }


    /**
     * This method is used to convert fields such as payment and salary to string and other info is obtained from the parent class
     * @return string with all the info about a fulltime management employee
     */
    @Override
    public String toString(){
        if (role == 1) {
            return super.getString() + "::Payment $" + payment + "::FULL TIME::Annual Salary $"  + salary + "::Manager Compensation $" + compensation;
        }
        else if(role == 2){
            return super.getString() + "::Payment $" + payment + "::FULL TIME::Annual salary $" + salary + "::Department Head Compensation $" + compensation;
        }

        return super.getString() + "::Payment $" + payment + "::FULL TIME::Annual salary $" + salary + "::Director Compensation $" + compensation;

    }
}
