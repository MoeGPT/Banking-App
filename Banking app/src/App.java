
import java.util.*;
import java.io.*;



public class App implements Serializable {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    // intializes file with fake data to ensure programs runs on first start. in the future I may change this to a exception to force p
      /*  Account testData = new Account();
    
        try {
           FileOutputStream fileOut = new FileOutputStream("C:\\Users\\moesp.MOEOS\\Coding project\\Banking app\\src\\AccountInfo.dat");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(testData);
           out.close();
           fileOut.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        */
       /* 
        File userNames = new File("C:\\Users\\moesp.MOEOS\\Coding project\\test as\\src\\usernames.txt");
        
        Scanner scnr = new Scanner(userNames);
        String test2 = scnr.nextLine();
        System.out.println(test2);
        
        */

// This is the start up section, User will either have to sign in or create an account.
        LinkedList<Account> allAccounts = new LinkedList<Account>();
       
//Program should run even on intial start where no data exists.
       try{ 
        FileInputStream fileIn = new FileInputStream("C:\\Users\\moesp.MOEOS\\Coding project\\Banking app\\src\\AccountInfo.dat");
        ObjectInputStream dataIn = new ObjectInputStream(fileIn);
        allAccounts = (LinkedList<Account>) dataIn.readObject();
        fileIn.close();
        dataIn.close();
       }
       finally {

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
                    allAccounts.add(uAccount);
                    break;
                } 
                else {
                    System.out.println("Please enter 1 or 2.");
                }
            } 
            else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); 
            }
        }
        
        FileHandler.saveAccounts(allAccounts);
        for(Account i : allAccounts){
            System.out.println(i);
            System.out.println("TEST");

        }
    
        sc.close();
       }
    }
}
