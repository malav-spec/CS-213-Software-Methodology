/**
 * Creates library object
 * @author Malav Doshi and Herik Patel
 */
public class Library {
    /**
     * Array of Book object
     */
    private Book[] books; // array-based implementation of the bag data structure
    /**
     * To store how many books are in library
     */
    private int numBooks; // the number of books currently in the bag

    /**
     *Constructor
     * @author Malav Doshi and Herik Patel
     */
    public Library() { //default constructor to create an empty bag
        books = new Book[4];
        numBooks = 0;
    }

    /**
     * Maintains how many books are there in the Library
     * @author Malav Doshi and Herik Patel
     * @param num Total books present
     */
    public void setNumBooks(int num){
        numBooks = num;
    }

    /**
     * Used to get how many books are there in the Library
     * @author Malav Doshi and Herik Patel
     * @return Total book in Library
     */
    public int getNumBooks(){
        return numBooks;
    }

    /**
     *Gets Book in Library
     * @author Malav Doshi and Herik Patel
     * @return Array of Book
     */
    public Book[] getBookLib(){
        return books;
    }

    /**
     * Adds Book object to the Library
     * @author Malav Doshi and Herik Patel
     * @param book object from kiosk
     */
    public void add(Book book) {  //Add the book to the lib.
        if(numBooks == 0){
            books[0] = book;
            numBooks++;
            return;
        }
        if(numBooks == books.length){ //If the bag is full call grow() to increase the capacity
            grow();
        }
        books[numBooks] = book;
        numBooks++;
    }

    /**
     * Used to remove book from library and maintain the record
     * @author Malav Doshi and Herik Patel
     * @param book object from kiosk
     * @return False if book is not in the library else True
     */
    public boolean remove(Book book) {  //removes book by updating values in the array
        int book_not_available=-1;
        int f = find(book);
        if(f==book_not_available)       //if book does not exist no changes are made
        {
            return false;
        }
        if(f==numBooks-1)
        {
            numBooks--;
            return true;
        }
        for(int i=f;i<numBooks-1;i++)   // Overwriting the values in the array to remove particular book
        {
            books[i].setName(books[i+1].getName());
            books[i].setNumber(books[i+1].getNumber());
            books[i].setCheckedOut(books[i+1].getCheckedOut());
            books[i].setDatePublished(books[i+1].getDatePublished());

        }
        numBooks--;
        return true;

    }

    /**
     * Used to see if the book is checkout or available
     * @author Malav Doshi and Herik Patel
     * @param book object from kiosk
     * @return False if book is already checkedout
     */
    public boolean checkOut(Book book) {

        int f = find(book);

        if(f == -1){
            return false;
        }

        if(books[f].getCheckedOut()){
            return false;
        }

        books[f].setCheckedOut(true);
        return true;

    }

    /**
     * When user returns the book it updates the record
     * @author Malav Doshi and Herik Patel
     * @param book object from kiosk
     * @return True if book is successfully returned or False
     */
    public boolean returns(Book book) {
        int f = find(book);

        if(f == -1){
            return false;
        }

        if(!books[f].getCheckedOut()){
            return false;
        }

        books[f].setCheckedOut(false);
        return true;
    }

    /**
     * Used to print book in the Library
     * @author Malav Doshi and Herik Patel
     */
    public void print() {
        int i;
        String print_stmt = "";
        for(i=0;i<numBooks;i++){
            print_stmt=print_stmt+"Book#"+books[i].getNumber()+"::"+books[i].getName()+"::"+books[i].getDatePublished().getMonth()+"/"+books[i].getDatePublished().getDay()+"/"+books[i].getDatePublished().getYear();
            if(books[i].getCheckedOut())
            {
                print_stmt=print_stmt+"::is not available.";
            }
            else
            {
                print_stmt=print_stmt+"::is available.";
            }

            System.out.println(print_stmt);
            print_stmt = "";
        }
    }

    /**
     * Used to print books in ascending order by dates
     * @author Malav Doshi and Herik Patel
     */
    public void printByDate()
    {
        Book[] sorted_list = sorted_Array();   // This function returns sorted array
        String print_stmt = "";
        int i;
        for(i=0;i<numBooks;i++) {
            print_stmt=print_stmt+"Book#"+books[i].getNumber()+"::"+books[i].getName()+"::"+books[i].getDatePublished().getMonth()+"/"+books[i].getDatePublished().getDay()+"/"+books[i].getDatePublished().getYear();
            if(books[i].getCheckedOut())
            {
                print_stmt=print_stmt+"::is not available.";
            }
            else
            {
                print_stmt=print_stmt+"::is available.";
            }
            System.out.println(print_stmt);
            print_stmt="";
        }
    }

    /**String print_stmt = "";
        int i;
        for(i=0;i<numBooks;i++) {
            print_stmt=print_stmt+"Book#"+books[i].getNumber()+"::"+books[i].getName()+"::"+books[i].getDatePublished().getMonth()+"/"+books[i].getDatePublished().getDay()+"/"+books[i].getDatePublished().getYear();
            if(books[i].getCheckedOut())
            {
                print_stmt=print_stmt+"::is not available.";
            }
            else
            {
                print_stmt=print_stmt+"::is available.";
            }
            System.out.println(print_stmt);
            print_stmt="";
        }
     * Used to print books in ascending order by book number
     * @author Malav Doshi and Herik Patel
     */
    public void printByNumber() {
        
        int i,j;

        if(numBooks == 0){// IF the list is empty just return
            return;
        }

        for(i=0;i<numBooks-1;i++){  //Selection sort

            int min = i;

            for(j=i+1;j<numBooks;j++){
                if(Integer.parseInt(books[j].getNumber()) < Integer.parseInt(books[min].getNumber())){
                    min = j;
                }
            }
            Book temp = books[min];
            books[min] = books[i];
            books[i] = temp;
        }
        
        String print_stmt = "";
        for(i=0;i<numBooks;i++) {
            print_stmt=print_stmt+"Book#"+books[i].getNumber()+"::"+books[i].getName()+"::"+books[i].getDatePublished().getMonth()+"/"+books[i].getDatePublished().getDay()+"/"+books[i].getDatePublished().getYear();
            if(books[i].getCheckedOut())
            {
                print_stmt=print_stmt+"::is not available.";
            }
            else
            {
                print_stmt=print_stmt+"::is available.";
            }
            System.out.println(print_stmt);
            print_stmt="";
        }
    }

    /**
     * Used to sort the Book array by date
     * @author Malav Doshi and Herik Patel
     * @return Book array which is sorted by dates
     */
    private Book[] sorted_Array() //Returns an sorted array
    {
        Book[] temp = books;
        Book[]  swap_var= new Book[1];
        Book swap_obj = new Book();
        String date1="";
        String date2="";

        int min_index;
        for(int i=0;i<numBooks-1;i++)
        {
            min_index=i;
            for (int j=i+1;j<numBooks;j++ )
            {
                date1 = check_Date(min_index,temp);  // Takes the date and turns it into a string value
                date2 = check_Date(j,temp);
                //  date2=""+temp[j].getDatePublished().getYear()+temp[j].getDatePublished().getMonth()+temp[j].getDatePublished().getDay();
                int int_date1= Integer.parseInt(date1);
                int int_date2= Integer.parseInt(date2);
                if(int_date2<int_date1)
                {
                    min_index=j;
                }

            }
            swap_obj.setName(temp[min_index].getName());                   //Creating Book Object to store values of the minimum index
            swap_obj.setDatePublished(temp[min_index].getDatePublished());
            swap_obj.setNumber(temp[min_index].getNumber());
            swap_obj.setCheckedOut(temp[min_index].getCheckedOut());
            swap_var[0]=swap_obj;

            temp[min_index].setName(temp[i].getName());                     //Swap values using temporary array
            temp[min_index].setNumber(temp[i].getNumber());
            temp[min_index].setCheckedOut(temp[i].getCheckedOut());
            temp[min_index].setDatePublished(temp[i].getDatePublished());

            temp[i].setName(swap_var[0].getName());
            temp[i].setNumber(swap_var[0].getNumber());
            temp[i].setCheckedOut(swap_var[0].getCheckedOut());
            temp[i].setDatePublished(swap_var[0].getDatePublished());


        }

        return temp;
    }

    /**
     * Used to check date and return it as a String value
     * @author Malav Doshi and Herik Patel
     * @param index Index of the array
     * @param temp Temporary Book array
     * @return String value of date
     */
    private String check_Date(int index,Book[] temp)
    {
        String date_to_string = ""+temp[index].getDatePublished().getYear();
        if(temp[index].getDatePublished().getMonth()<10)
        {
            date_to_string=date_to_string+"0"+temp[index].getDatePublished().getMonth();
        }
        else
        {
            date_to_string=date_to_string+temp[index].getDatePublished().getMonth();
        }
        if(temp[index].getDatePublished().getDay()<10)
        {
            date_to_string=date_to_string+"0"+temp[index].getDatePublished().getDay();
        }
        else
        {
            date_to_string=date_to_string+temp[index].getDatePublished().getDay();
        }
        return date_to_string;
    }

    /**
     * Increases size of the Book array by 4
     * @author Malav Doshi and Herik Patel
     * @author Malav Doshi and Herik Patel
     */
    private void grow() { // helper method to grow the capacity by 4

        Book[] temp = new Book[books.length + 4]; //Declare and initialize a temp array of length +4 than original one
        int i,j;

        for(i=0;i < books.length;i++){
            temp[i] = books[i]; //Transfer elements to the new array
        }

        books = temp; //Give the reference of the new array to the original array
    }

    /**
     * Used to find if book is in the record
     * @author Malav Doshi and Herik Patel
     * @param book object from kiosk
     * @return Integer value if book is found returns the index of book
     */
    private int find(Book book) { // helper method to find a book in the bag. Returns the index of the book to be removed
        int i;
        for(i=0;i<numBooks;i++){
            if(books[i].equals(book)){
                return i;
            }
        }

        return -1; //This means book not found in the lib.
    }

    /**
     * Used to see if book is available
     * @author Malav Doshi and Herik Patel
     * @return False
     */
    public boolean isBookAvailable(){
        return false;
    }
}

