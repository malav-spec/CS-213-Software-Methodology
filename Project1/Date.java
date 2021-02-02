import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * @author Malav Doshi and Herik Patel
 * Used to create Date object
 */
public class Date {
    /**
     * year of publishing
     */
    private int year;
    /**
     * month of publishing
     */
    private int month;
    /**
     * day of publishing
     */
    private int day;

    /**
     * Used to set values for Date object
     * @param date It is the date entered for book
     */

    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date,"/");
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
    }

    /**
     *
     * @author Malav Doshi and Herik Patel
     */
    public Date() {
        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH) + 1;//Since month in Calendar class starts at 0
        day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Used to get year for a date
     * @author Malav Doshi and Herik Patel
     * @return Integer value which is year
     */

    public int getYear(){
        return year;
    }
    /**
     * Used to get month for a date
     * @author Malav Doshi and Herik Patel
     * @return Integer value which is month
     */
    public int getMonth(){
        return month;
    }
    /**
     * Used to get day for a date
     * @author Malav Doshi and Herik Patel
     * @return Integer value which is day
     */
    public int getDay(){
        return day;
    }

    /**
     * Checks if the date entered by user is valid or invalid
     * @author Malav Doshi and Herik Patel
     * @return False if invalid date is entered else True
     */
    public boolean isValid() {
        Date today = new Date();

        if(year < 1900 ){// If year < 1900 return false
            return false;
        }

        if(month<=0||day<=0) //Month and date cannot be zero
        {
            return false;
        }

        if(day > 31){
            return false;
        }

        if(year > today.year){//If year > current year, return false
            return false;
        }

        if(month > 12){// Max 12 months
            return false;
        }

        if(year == today.year && (month > today.month || day > today.day )){//If date beyond today, return false
            return false;
        }

        if(month == 2 && day > 29){//Feb can't have more than 29 days at max
            return false;
        }

        if(!isLeapYear(year)){ // If year not a leap year and input date is greater than 28 in Feb, return false
            if(month == 2 && day > 28){
                return false;
            }
        }

        if(month == 4 || month == 6 || month == 9 || month == 11){//These months cant have date greater than 30
            if(day > 30){
                return false;
            }
        }
        return true;
    }

    /**
     *Used to check if a year is a leap year or not
     * @author Malav Doshi and Herik Patel
     * @param y Year
     * @return True if given year is leap year else false
     */
    private boolean isLeapYear(int y){
        if(y % 4 == 0){ //Check divisibility by 4

            if(y % 100 == 0){//Check divisibility by 100

                if(y % 400 == 0){//Check divisibility by 400

                    return true;
                }
                else{
                    return false;
                }
            }
            else {
                return true;
            }
        }
        return false;
    }
}