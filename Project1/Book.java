import java.util.*;

public class Book {
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut;
    private Date datePublished;

    public Book(){

    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public void setDatePublished(Date date){
        this.datePublished = date;
    }

    public void setCheckedOut(Boolean bool){
        this.checkedOut = bool;
    }

    public String getName(){
        return name;
    }

    public String getNumber(){
        return number;
    }

    public Date getDatePublished(){
        return datePublished;
    }

    public Boolean getCheckedOut(){
        return checkedOut;
    }

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

    public boolean comapreDate(Date d1, Date d2) {
        if(d1.getYear() == d2.getYear() && d1.getDay() == d2.getDay() && d1.getMonth() == d2.getMonth()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return null;
    }

}

