import java.util.Calendar;
import java.util.StringTokenizer;


public class Date {

    private int year;
    private int month;
    private int day;

    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date,"/");
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
    }

    public Date() {
        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH) + 1;//Since month in Calendar class starts at 0
        day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    public boolean isValid() {
        Date today = new Date();

        if(year < 1900 ){// If year < 1900 return false
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
