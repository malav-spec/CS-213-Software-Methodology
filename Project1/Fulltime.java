/**
 * Used to create a Fulltime employee
 * @author Malav Doshi and Herik Patel
 */
public class Fulltime extends Employee{

    /**
     * Represents salary of the employee
     */
    public double salary;
    /**
     * Represents Payment given to employee
     */
    public double payment = 0;
    /**
     *Constructor for class Fulltime
     */
    public Fulltime(){
    }

    /**
     *Parameterised constructor of Fulltime class.
     * @author Malav Doshi and Herik Patel
     * @param profile Profile of fulltime employee
     * @param salary Salary of fulltime employee
     */
    public Fulltime(Profile profile, double salary){

        super(profile);
        this.salary = salary;
    }

    /**
     * Used to get the salary of a full time employee
     * @author Malav Doshi and Herik Patel
     * @return Salary of fulltime employee
     */
    public double getSalary(){
        return salary;
    }

    /**
     * Returns the common data of employee
     * @author Malav Doshi and Herik Patel
     * @return string from toString() method in Employee class
     */
    public String getString(){
        return super.toString();
    }

    /**
     *This method is used to calculate to payment for salary of a full-time employee
     * @author Malav Doshi and Herik Patel
     */
    @Override
    public void calculatePayment() {

        payment = salary / 26;
        payment = Math.round(payment * 100.0) / 100.0; //Round off to two decimal places

    }

    /**
     * This method is used to compare objects to see if the employee is already present in the database
     * @author Malav Doshi and Herik Patel
     * @param obj Object to be compared
     * @return True if obj is same as the compared object. False otherwise.
     */
    @Override
    public boolean equals(Object obj){

        if(obj instanceof Fulltime){
            return super.equals(obj);
        }
        return false;
    }

    /**
     * This method is used to convert fields such as payment and salary to string and other info is obtained from the parent class
     * @author Malav Doshi and Herik Patel
     * @return string with all the info about a fulltime employee
     */
    @Override
    public String toString(){
        return super.toString() + "::Payment $" + payment + "::FULL TIME::Annual Salary $"  + salary;
    }
}
