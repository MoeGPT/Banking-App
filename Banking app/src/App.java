
import java.util.*;



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
       /* 
        File userNames = new File("C:\\Users\\moesp.MOEOS\\Coding project\\test as\\src\\usernames.txt");
        
        Scanner scnr = new Scanner(userNames);
        String test2 = scnr.nextLine();
        System.out.println(test2);
        
        */

// This is the start up section, User will either have to sign in or create an account.

        Scanner sc = new Scanner(System.in);
        int choice = 0;
    

        while (true){
            System.out.println("1. Sign in  2. Create an account");
            
            if (sc.hasNextInt()){
                choice = sc.nextInt();
            
                if (choice == 1) {
                    System.out.println("UPDATE TO SEND TO LOGIN SCREEN");
                    break;
                } else if (choice == 2) {
                    Account uAccount = new Account();
                    uAccount.signUp();
                    break;
                } else {
                    System.out.println("Please enter 1 or 2.");
                }
            } 
            else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); 
            }
        }

        sc.close();
        
    }
}
