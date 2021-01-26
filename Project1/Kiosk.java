import java.util.Scanner;
import java.util.StringTokenizer;

public class Kiosk {

    public String input;
    public String name,command,number,dateIn;
    Date date;


    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Library Kiosk running.");


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

            if(isLowerCase(command)){
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
                    System.out.println("Invalid Command!");
                    continue;
                }
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

}
