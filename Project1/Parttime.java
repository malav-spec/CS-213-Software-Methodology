/**
 * used to create a parttime employee
 * @author Malav Doshi and Herik Patel
 */
public class Parttime extends Employee{

    /**
     * Represents hourly wage for an employee
     */
    private double hourlyPayRate;
    /**
     * Represents payment for the an employee
     */
    private double payment = 0;
    /**
     * Represents total hours an employee worked
     */
    private int hours;
    /**
     * Represents how many extra hours an employee worked
     */
    private int extra_hours;
    /**
     * Constructor for the class Parttime
     */
    public Parttime(){
    }

    /**
     * Constructor for the class Parttime used to instantiate values
     * @author Malav Doshi and Herik Patel
     */
    public Parttime(Profile profile, double hourlyPayRate){
        super(profile);
        this.hourlyPayRate = hourlyPayRate;
    }

    /**
     * This method is used to set hours for part time employee
     * @author Malav Doshi and Herik Patel
     * @param hours time which we want to set for an employee
     */
    public void setHours(int hours){
        this.hours = hours;
    }

    /**
     * This method is used to get number of hours an employee worked
     * @author Malav Doshi and Herik Patel
     * @return number of hours of an employee
     */
    public int getHours(){
        return hours;
    }

    /**
     * This method is used to calculate payment for the part-time employee
     * @author Malav Doshi and Herik Patel
     */
    @Override
    public void calculatePayment() {

        double extra_payment;
        int max_hours = 80;
        double extra_rate = 1.5;

        if(hours > max_hours){ //Extra hours to be paid 1.5x hourly rate
            extra_hours = hours - max_hours;
            extra_payment = extra_hours * extra_rate * hourlyPayRate;
            payment += extra_payment;
            return;
        }

        payment = hours * hourlyPayRate;
    }


    /**
     * This method is used to compare objects to see if the employee is already present in the database
     * @author Malav Doshi and Herik Patel
     * @param obj Object to be compared
     * @return True if obj is same as the compared object. False otherwise.
     */
    @Override
    public boolean equals(Object obj){

        if(obj instanceof Parttime){
            return super.equals(obj);
        }
        return false;
    }


    /**
     * This method is used to convert fields such as payment and hourly rate to string and other info is obtained from the parent class
     * @author Malav Doshi and Herik Patel
     * @return string with all the info of a parttime employee
     */
    @Override
    public String toString(){
        return super.toString() + "::Payment $" + payment + "::PART TIME:: Hourly Rate $" + hourlyPayRate + "::Hours worked this period: " + hours;
    }
}
