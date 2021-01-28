import java.util.Scanner;
import java.util.StringTokenizer;

public class Kiosk {

    public String input;
    public String name,command,number,dateIn;
    Date date;

    int serialNumber = 10001;

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

            if(st.hasMoreTokens()){ //Set date, if there in command

                dateIn = st.nextToken();
                date = new Date(dateIn);

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

        }
    }

    public boolean isNumber(String str){

        int i;
        for(i=0;i<str.length();i++){
            if(Character.isAlphabetic(str.charAt(i))){//If there is an alphabet, return false
                return false;
            }
        }

        return true;
    }

    public boolean isLowerCase(String cmd){

        int i;
        for(i=0;i<cmd.length();i++){//Check for lowercase in the command
            if(Character.isLowerCase(cmd.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public boolean validCommand(String cmd){
        if(cmd.equals("A") || cmd.equals("R") || cmd.equals("I") || cmd.equals("O") || cmd.equals("PA") || cmd.equals("PD") || cmd.equals("PN")){
            return true;
        }
        return false;
    }

}
