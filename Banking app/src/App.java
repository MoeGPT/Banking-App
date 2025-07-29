
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;



public class App{


    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
// This is the start up section, User will either have to sign in or create an account. 
//Program should run even on intial start where no data exists.

    String fileName = "AccountInfo.dat";
    LinkedList<Account> allAccounts = FileHandler.loadAccounts(fileName);
    Account FAKEACCOUNT = new Account();
    FAKEACCOUNT.setfName("TEST ACCOUNT HERE");
    allAccounts.add(FAKEACCOUNT);

    Scanner sc = new Scanner(System.in);
    int choice = 0;
    boolean loop = true;

        while (true){
            System.out.println("1. Sign in  2. Create an account");
            
            if (sc.hasNextInt()){
                choice = sc.nextInt();
            
                if (choice == 1) {
                    System.out.println("UPDATE TO SEND TO LOGIN SCREEN");
                    break;
                } else if (choice == 2) {
                    Account uAccount = new Account();
                    signUp(uAccount);
                    allAccounts.add(uAccount);
                    //Account data should only save if new account is added, later will change for when accounts are modified too.
                    break;
                } 
                else if(choice == 3) {
// Temporary hidden choice to view acoounts to make sure they are saved properly will remove later
    while(loop == true){

        System.out.println("Show all accounts? 1. Yes 2. No");
        if(sc.hasNextInt()){
            choice = sc.nextInt();
            if(choice == 1) {
            
                for(Account i : allAccounts){
                    System.out.println(i.getName() + " hi");
                    System.out.println("TEST");
                }   
                loop = false;

            }
            else if (choice == 2) {
                System.out.println("System close");
                loop = false;

            }
            else{
                System.out.println("Please enter 1 or 2.");
             }

        } 
        else{
            System.out.println("Invalid Input. Please enter a number. ");
            sc.next();
        }
        break;
    }   
//ends here    

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
        
       
        // test case to see if accounts are stored properly in the linked list
    sc.close();
    System.out.println("This is the end of the program!");
    FileHandler.saveAccounts(allAccounts, fileName);
    }

    public static void signUp(Account user) throws Exception{
        File userNames = new File("src\\usernames.txt");
        Scanner scUser = new Scanner(userNames);
        Scanner sc = new Scanner(System.in);

        // first name
        while(true){
            System.out.println("Enter first name: ");
            String fName = sc.nextLine();
            if (charOnly(fName)) {
                user.setfName(fName);
                break;      
            } 
            else {
                System.out.println("Only letters allowed.");
                }
        }

        // last name
        while(true){
            System.out.println("Enter last name: ");
            String lName = sc.nextLine();
            if (charOnly(lName)) {
                user.setlName(lName);
                break;      
            } 
            else {
                System.out.println("Only letters allowed.");
                }
        }

        // sets email and ensure it mathces with typical email format ex. example@test.com
        while(true){
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        
        System.out.println("Please enter your email address: ");
        String eMail = sc.nextLine();
        
        Matcher matcher = pattern.matcher(eMail);
        if (matcher.matches()) {
                System.out.println("Valid email address.");
                user.setEmail(eMail);
                break;
            }
            else {
                System.out.println("Invalid email address. Please try again.");
            }

        }
        // Username
        while (true) {
           
            System.out.println("Choose a username: ");
            String userName = sc.nextLine();

            if (userName.matches("^[a-zA-Z0-9_]+$")) {
            String takenName;
            int y = 0;
            //should compare userName to each line of file
            while (scUser.hasNextLine()){
                takenName = scUser.nextLine();
                if(userName.equals(takenName)){
                    ++y;
                    break;
                }
            }
            if(y != 0){
                System.out.println("Username is already taken. Try again.");
                }

            else {
            //this should allow a new username to be added to the end of the file 
            System.out.println("Valid username.");
            user.setUsername(userName);

            try(FileWriter fw = new FileWriter(userNames, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)){
                out.println(userName);
                break;
            } catch (IOException e) {
            //exception handling left as an exercise for the reader
            }  
            }     
        }         
            else {
                System.out.println("Invalid format. Only letters, numbers, and underscores.");
            }
    }

    scUser.close();

        // Password
        while(true){
            String verifyP = "n";
            String passWord = "";
            while(!verifyP.equals(passWord)) {
                System.out.println("Please enter a password: ");
                passWord = sc.nextLine();
                System.out.println("Please confirm your password: ");
                verifyP = sc.nextLine();
            
                if (!verifyP.equals(passWord)){
                    System.out.println("Passwords do not match. Please try again.");
                }
            else {
                user.setPassword(passWord);
                break;
                }
            }
        break;
        }


    }
    public static boolean charOnly(String name) {
    char[] chars = name.toCharArray();
    for (char c : chars) {
        if(!Character.isLetter(c)) {
            return false;
        }
    }

    return true;
}
}
