import java.util.Scanner;

/**
 * Creates a Book object
 * @author Malav Doshi and Herik Patel
 */
public class Book {
    /**
     *5-digit serial number unique to the book
     */
    private String number; //a 5-digit serial number unique to the book
    /**
     * Name of the book
     */
    private String name;
    /**
     * To check availbility
     */
    private boolean checkedOut;
    /**
     * Date published
     */
    private Date datePublished;

    /** Constructor
     * @author Malav Doshi and Herik Patel
     */
    public Book(){

    }

    /**
     * Sets the name of book by assigning the value passed as parameter
     * @author Malav Doshi and Herik Patel
     * @param name takes name as parameter
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the serial number of the book
     * @author Malav Doshi and Herik Patel
     * @param number Unique book id
     */
    public void setNumber(String number){
        this.number = number;
    }

    /**
     *Sets published date for the book
     * @author Malav Doshi and Herik Patel
     * @param  date Date type parameter is passed to assign date for a book
     */
    public void setDatePublished(Date date){
        this.datePublished = date;
    }

    /**
     * Used to initialize a value to keep record if the book is checked out
     * @author Malav Doshi and Herik Patel
     * @param bool Takes a boolean value as parameter
     */
    public void setCheckedOut(Boolean bool){
        this.checkedOut = bool;
    }

    /**
     * Used to get name of book
     * @author Malav Doshi and Herik Patel
     * @return String value which is name of the book
     */
    public String getName(){
        return name;
    }

    /**
     * Returns a value which is unique book number
     * @author Malav Doshi and Herik Patel
     * @return String value which is unique number for a book
     */
    public String getNumber(){
        return number;
    }

    /**
     * Used to get published date for a book
     * @author Malav Doshi and Herik Patel
     * @return Date object
     */
    public Date getDatePublished(){
        return datePublished;
    }

    /**
     * Used to check if a book is available to checkout
     *@author Malav Doshi and Herik Patel
     * @return True if book is available to checkout else false
     */
    public Boolean getCheckedOut(){
        return checkedOut;
    }

    /**
     *
     * @param s1 String 1
     * @param s2 String 2
     * @return True if two strings are equal else return False
     */
    public boolean compareString(String s1, String s2){
        int i,j;

        if(s1.length() != s2.length()){ //If lengths not equal string are not equal
            return false;
        }
        for(i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){ //If chars are different String not equal
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param obj Object
     * @return False if obj is not instance of book
     */
    @Override
    public boolean equals(Object obj){

        if(obj == this){
            return true;
        }

        if(!(obj instanceof Book)){
            return false;
        }

        Book b = (Book)obj; //Typecast to book type

        if(Integer.parseInt(this.number) == Integer.parseInt(b.number)){
            return true;
        }

        return false;
    }

    /**
     * Used to compare two Date
     * @param d1 Date 1
     * @param d2 Date 2
     * @return False if two Date are not equal else return True
     */
    public boolean comapreDate(Date d1, Date d2) {
        if(d1.getYear() == d2.getYear() && d1.getDay() == d2.getDay() && d1.getMonth() == d2.getMonth()){
            return true;
        }
        return false;
    }

    /**
     * Used to return a string in a particular format
     * @return String in the format: "Book#(number)::Name::Date published::is/is not available"
     */
    @Override
    public String toString() {
        String str = "";
        if(!checkedOut) {
            str = str + "Book#" + number + "::" + name + "::" + datePublished.getMonth() + "/" + datePublished.getDay() + "/" + datePublished.getYear() + "::" + "is available.";
        }
        else{
            str = str + "Book#" + number + "::" + name + "::" + datePublished.getMonth() + "/" + datePublished.getDay() + "/" + datePublished.getYear() + "::" + "is not available.";
        }
        return str;
    }

}

