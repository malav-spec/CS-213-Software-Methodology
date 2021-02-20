/**
 * Used to crate a profile of an employee
 * @author Malav Doshi and Herik Patel
 */
public class Profile {
    /**
     * Represents Name of the employee
     */
    private String name; //employee’s name in the form “lastname,firstname”
    /**
     * Represents Department of the employee
     */
    private String department; //department code: CS, ECE, IT
    /**
     * Represents Date at which the employee was hired
     */
    private Date dateHired;

    /**
     * Constructor for Profile class used to instantiate values
     * @param name First and last name of the employee
     * @param department Name of the department in which employee works
     * @param dateHired Date at which employee was hired
     */
    public Profile(String name, String department, Date dateHired){
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }
    /**
     *This method is used to get name of the employee
     * @return Name of the employee
     */
    public String getName(){
        return name;
    }

    /**
     *This method is used to get department of the employee
     * @return Department of the employee
     */
    public String getDepartment(){
        return department;
    }

    /**
     *This method is used to get date at which employee was hired
     * @return Date at which employee was hired
     */
    public Date getDateHired(){
        return dateHired;
    }

    /**
     * This method is used to set name for the profile object
     * @param name Name of the employee
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is used to set department for the profile object
     * @param department Department of the employee
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * This method is used to set hiring date for the profile object
     * @param dateHired Date at which employee was hired
     */
    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return null;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
