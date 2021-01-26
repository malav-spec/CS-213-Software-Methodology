public class Library {
    private Book[] books; // array-based implementation of the bag data structure
    private int numBooks; // the number of books currently in the bag

    public Library() { //default constructor to create an empty bag
        books = new Book[4];
        numBooks = 0;
    }

    public void setNumBooks(int num){
        numBooks = num;
    }

    public int getNumBooks(){
        return numBooks;
    }

    public Book[] getBookLib(){
        return books;
    }

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

    public boolean remove(Book book) {
        int f = find(book);
        return true;
    }

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

    public void print() {
        int i;
        for(i=0;i<numBooks;i++){
            System.out.println("Book#"+books[i].getNumber()+"::"+books[i].getName()+"::"+books[i].getDatePublished().getMonth()+"/"+books[i].getDatePublished().getDay()+"/"+books[i].getDatePublished().getYear()+"::is available.");
        }
    }
    public void print_using_date()
    {
        Book[] books2 =new Book[numBooks];

       // double d=Double.parseDouble("23");
        System.out.print("");

    }
    public void checkout(String book_number)  // Check if book is available to checkout by searching it using its unique number
    {
        if(numBooks==0)
            System.out.println("No books to Checkout");

        for(int i =0 ;i<numBooks;i++)
        {
            if(books[i].getNumber().equals((book_number)))
            {
                if(books[i].getCheckedOut()) {
                    System.out.println("Book Not Available");
                    return;
                }
                else {
                    books[i].setCheckedOut(true);
                    System.out.println(books[i].getCheckedOut());
                    return;
                }

            }
        }
        System.out.println("Bok Number does not exist");
    }


    private void grow() { // helper method to grow the capacity by 4

        Book[] temp = new Book[books.length + 4]; //Declare and initialize a temp array of length +4 than original one
        int i,j;

        for(i=0;i < books.length;i++){
            temp[i] = books[i]; //Transfer elements to the new array
        }

        books = temp; //Give the reference of the new array to the original array
    }

    private int find(Book book) { // helper method to find a book in the bag. Returns the index of the book to be removed
        int i;
        for(i=0;i<numBooks;i++){
            if(books[i].equals(book)){
                return i;
            }
        }
        return -1; //This means book not found in the lib.
    }

    public boolean isBookAvailable(){
        return false;
    }
}
