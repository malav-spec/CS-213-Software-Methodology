import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Used to take input and process it accordingly
 * @author Malav Doshi and Herik Patel
 */
public class Kiosk {
    /**
     * User input
     */
    public String input;
    /**
     *  Data about book object
     */
    public String name,command,number,dateIn;
    /**
     * Date object
     */
    Date date;
    /**
     * Book serial number
     */
    int serialNumber = 10001;

    /**
     * Used to take user input unless Q is Entered it process different commands entered by user such as PA ,PD
     */
    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Library Kiosk running.");


        Library lib = new Library();

        for(;;){//Infinite loop to keep the session running

            input = sc.nextLine();

            if(input.equals("Q")){ // Checks for 'Q' to quit the session
                System.out.print("Kiosk session ended.");
                return;
            }

            StringTokenizer st = new StringTokenizer(input,",",false);

            if(st.hasMoreTokens()) { //Set the command
                command = st.nextToken();
            }

            if(!validCommand(command)){
                System.out.println("Invalid command!");
                continue;
            }

            if(isLowerCase(command)){//Check for lower case commands
                System.out.println("Invalid command!");
                continue;
            }


            if(st.hasMoreTokens()) { //Set Name or number
                String temp = st.nextToken();

                if (isNumber(temp)) {
                    number = temp;
                } else {
                    name = temp;
                }
            }
            else if(command.length() == 1){
                System.out.println("Invalid command!");
                continue;
            }

            if(st.hasMoreTokens()){ //Set date, if there in command

                dateIn = st.nextToken();
                date = new Date(dateIn);

                if(date.getMonth() == 0 || date.getDay() == 0 || date.getYear() == 0){
                    System.out.println("Invalid Date!");
                    continue;
                }

                if(!date.isValid()){//If date not valid give a warning
                    System.out.println("Invalid Date!");
                    continue;
                }
            }

            if(command.equals("A")){ //Calls the Add command from the library
                Book newBook = new Book();
                newBook.setName(name);
                newBook.setDatePublished(date);
                newBook.setNumber(Integer.toString(serialNumber));
                lib.add(newBook);
                serialNumber++; //increase sr. number after adding
                System.out.println(name + " added to the library.");
                continue;
            }
            else if(command.equals("R")){ //Calls the remove function from the lib
                Book newBook = new Book();
                newBook.setNumber(number);
                if(lib.remove(newBook)){
                    System.out.println("Book#"+number+" removed.");
                }
                else{
                    System.out.println("Unable to remove, the library does not have this book.");
                }
            }
            else if(command.equals("O")){ //Calls the checkOut function from the lib
                Book newBook = new Book();
                newBook.setNumber(number);
                if(!lib.checkOut(newBook)){
                    System.out.println("Book#"+number+" is not available");
                }
                else{
                    System.out.println("You've checked out "+"Book#"+number+". Enjoy!");
                }

            }
            else if(command.equals("I")){ // Calls the returns function from the lib
                Book newBook = new Book();
                newBook.setNumber(number);
                if(!lib.returns(newBook)){
                    System.out.println("Unable to return "+"Book#"+number+".");
                }
                else{
                    System.out.println("Book#"+number+" return has completed. Thanks!");
                }
            }

            else if(command.equals("PA")){ //Calls the print function from the lib
                System.out.println("** List of books in the library");
                lib.print();
                System.out.println("** End of list");
            }
            else if(command.equals("PD")){ //Calls the print function from the lib
                System.out.println("**List of books by the dates published.");
                lib.printByDate();
                System.out.println("** End of list");
            }
            else if(command.equals("PN")){ //Calls the print by number function from the lib
                System.out.println("** List of books in the library");
                lib.printByNumber();
                System.out.println("** End of list");
            }

        }
    }

    /**
     * Used to check if a string value is a number or not
     * @author Malav Doshi and Herik Patel
     * @param str Takes user input to verify
     * @return True if given string is a number else false
     */
    public boolean isNumber(String str){

        int i;
        for(i=0;i<str.length();i++){
            if(Character.isAlphabetic(str.charAt(i))){//If there is an alphabet, return false
                return false;
            }
        }

        return true;
    }

    /**
     * Used to check if given string is in lowercase
     * @author Malav Doshi and Herik Patel
     * @param cmd Takes user input to check
     * @return True if string is in lowercase else returns false
     */
    public boolean isLowerCase(String cmd){

        int i;
        for(i=0;i<cmd.length();i++){//Check for lowercase in the command
            if(Character.isLowerCase(cmd.charAt(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * Used to check if the command entered by user is valid or not
     * @author Malav Doshi and Herik Patel
     * @param cmd Takes user input to check
     * @return False if comman is invalid else True
     */
    public boolean validCommand(String cmd){
        if(cmd.equals("A") || cmd.equals("R") || cmd.equals("I") || cmd.equals("O") || cmd.equals("PA") || cmd.equals("PD") || cmd.equals("PN")){
            return true;
        }
        return false;
    }

}


