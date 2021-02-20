import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * Used to create Date object
 * @author Malav Doshi and Herik Patel
 */
public class Date implements Comparable<Date> {
    /**
     * Year when the employee was hired
     */
    private int year;
    /**
     * Month when the employee was hired
     */
    private int month;
    /**
     * Day when the employee was hired
     */
    private int day;

    /**
     * Constructor Used to set values for Date object
     * @param date It is the date on which employee was hired
     */

    public Date(String date) {
        try {
            StringTokenizer st = new StringTokenizer(date,"/");
            month = Integer.parseInt(st.nextToken());
            day = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());
        }
        catch (Exception ignored){
        }

    }

    /**
     *Constructor used to instantiate values for date
     */
    public Date() {
        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH) + 1;//Since month in Calendar class starts at 0
        day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Used to get year for a date
     * @return Integer value which is year
     */

    public int getYear(){
        return year;
    }
    /**
     * Used to get month for a date
     * @return Integer value which is month
     */
    public int getMonth(){
        return month;
    }
    /**
     * Used to get day for a date
     * @return Integer value which is day
     */
    public int getDay(){
        return day;
    }

    /**
     * Checks if the date entered by user is valid or invalid
     * @return False if invalid date is entered else True
     */
    public boolean isValid() {
        Date today = new Date();

        int min_year = 1900;
        int max_day = 31;
        int max_month = 12;
        int feb = 2;
        int feb_29 = 29;
        int feb_28 = 28;
        int apr = 4;
        int jun = 6;
        int sept = 9;
        int nov = 11;

        if(year < min_year ){// If year < 1900 return false
            return false;
        }

        if(month<=0||day<=0) //Month and date cannot be zero
        {
            return false;
        }

        if(day > max_day){
            return false;
        }

        if(year > today.year){//If year > current year, return false
            return false;
        }

        if(month > max_month){// Max 12 months
            return false;
        }

        if(year == today.year && (month > today.month || day > today.day )){//If date beyond today, return false
            return false;
        }

        if(month == feb && day > feb_29){//Feb can't have more than 29 days at max
            return false;
        }

        if(!isLeapYear(year)){ // If year not a leap year and input date is greater than 28 in Feb, return false
            if(month == feb && day > feb_28){
                return false;
            }
        }

        if(month == apr || month == jun || month == sept || month == nov){//These months cant have date greater than 30
            return day <= max_day - 1;
        }
        return true;
    }

    /**
     *Used to check if a year is a leap year or not
     * @param y Year which we want to check
     * @return True if given year is leap year else false
     */
    private boolean isLeapYear(int y){
        int div_4 = 4;
        int div_100 = 100;
        int div_400 = 400;

        if(y % div_4 == 0){ //Check divisibility by 4

            //Check divisibility by 100
            //Check divisibility by 400
            if(y % div_100 == 0) return y % div_400 == 0;
            else {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to compare dates
     * @author Malav Doshi and Herik Patel
     * @param date Date which we want to compare it with
     * @return 1 if the date is greater than the date we compare to, 0 if both the dates are equal, -1 if date is smaller than the other date
     */
    @Override
    public int compareTo(Date date) {

        if(date.getYear() > this.year){ //Check for years
            return -1;
        }
        else if(date.getYear() < this.year){
            return 1;
        }

        else if (date.year == this.year) {

            if(date.month == this.month){ //Check for months

                if(date.day < this.day){// Check days if years and months equal of both the objects
                    return 1;
                }
                else if(date.day > this.day){
                    return -1;
                }
                else {
                    return 0; //Dates are equal
                }
            }
            else if(date.month < this.month){
                return 1;
            }
            else {
                return -1;
            }
        }

        return 1;
    }

    /**
     * Testbed main for Date class
     * @param args No input needed
     */
    public static void main(String[] args){
        Date test = new Date("2/29/2000");
        System.out.println("Test1: Expected output: true | Actual output: " + test.isValid());

        Date test1 = new Date("13/12/1999");
        System.out.println("Test2: Expected output: false | Actual output: " + test1.isValid());

        Date test2 = new Date("2/29/1995");
        System.out.println("Test3: Expected output: false | Actual output: " + test2.isValid());

        Date test3 = new Date("10/31/1999");
        System.out.println("Test4: Expected output: true | Actual output: " + test3.isValid());

        Date test4 = new Date("11/31/1999");
        System.out.println("Test5: Expected output: false | Actual output: " + test4.isValid());

        Date test5 = new Date("3/32/1909");
        System.out.println("Test6: Expected output: false | Actual output: " + test5.isValid());

        Date test6 = new Date("1/12/1899");
        System.out.println("Test7: Expected output: false | Actual output: " + test6.isValid());

        Date test7 = new Date("1/1/2002");
        System.out.println("Test8: Expected output: true | Actual output: " + test7.isValid());

        Date test8 = new Date("2/12/2021");
        System.out.println("Test9: Expected output: false | Actual output: " + test8.isValid());

    }

}

