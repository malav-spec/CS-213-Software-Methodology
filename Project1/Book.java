import java.util.*;

public class Book {
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut;
    private Date datePublished;

    @Override
    public boolean equals(Object obj){ return false;}
    @Override
    public String toString() { return null;}
}
