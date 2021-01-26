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
