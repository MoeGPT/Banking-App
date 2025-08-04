
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;



public class App{

    public static final String fileName = "Accounts.dat";
    public static LinkedList<Account> allAccounts = FileHandler.loadAccounts(fileName);
    public static final Account FAKEACCOUNT = new Account();
    public static Account activeUser = null;



    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
// This is the start up section, User will either have to sign in or create an account. 
//Program should run even on initial start where no data exists.
//
        FAKEACCOUNT.setfName("This is a fake account");
        allAccounts.add(FAKEACCOUNT);

    Scanner sc = new Scanner(System.in);
    int choice;
    boolean loop = true;
    boolean loop2 = true;

        while (loop2){
            System.out.println("1. Sign in  2. Create an account 3. Exit");
            
            if (sc.hasNextInt()){
                choice = sc.nextInt();
            // considering changing this to a case blockS
                switch (choice) {
                    case 1:
                        System.out.println("UPDATE TO SEND TO LOGIN SCREEN");
                        logIn();
                        mainMenu();
                        break;

                    case 2:
                        Account uAccount = new Account();
                        signUp(uAccount);
                        //Account data should only save if new account is added, later will change for when accounts are modified too.

/* Debugging code to view acoounts to make sure they are saved properly

                        while (loop) {

                            System.out.println("Show all accounts? 1. Yes 2. No");
                            if (sc.hasNextInt()) {
                                choice = sc.nextInt();
                                if (choice == 1) {

                                    for (Account i : allAccounts) {
                                        System.out.println(i.getfName() + " hi");
                                        System.out.println(i.getFullAddress());
                                        System.out.println("///");
                                    }
                                    loop = false;

                                } else if (choice == 2) {
                                    System.out.println("System closed");
                                    loop = false;

                                } else {
                                    System.out.println("Please enter 1 or 2.");
                                }

                            } else {
                                System.out.println("Invalid Input. Please enter a number. ");
                                sc.next();
                            }
                        }
                        break;

 */
                        case 3:
                            loop2 = false;
                            break;
                        default:
                            System.out.println("Invalid Input. Please enter 1 or 2.");
                }
//ends here
            } 
            else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); 
            }
            break;
        }
        
       
        // test case to see if accounts are stored properly in the linked list

        System.out.println("This is the end of the program!");
        FileHandler.saveAccounts(allAccounts, fileName);

    }

    // sign up class

    public static void signUp(Account user) throws Exception{
        Random randGen = new Random();
        File userNames = new File("src\\usernames.txt");
        Scanner scUser = new Scanner(userNames);
        Scanner sc = new Scanner(System.in);
    // numbers for account and routing
        int rNum;
        long aNum;

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
        boolean loop = true;
        while(loop){
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
                loop = false;
                break;
                }
            }

        }

       
        // Routing and Account Number
        while(true){

            rNum = randGen.nextInt(900000000) + 100000000;
            aNum = randGen.nextLong(90000000000L) + 10000000000L;

            boolean isUnique = true;
            for (Account i : allAccounts) {
                if(i.getRoutNum() == rNum || i.getAccountNum() == aNum){
                    isUnique = false;
                    break;
                }
            }
            if(isUnique){
                user.setRoutNum(rNum);
                user.setAccountNum(aNum);
                break;
            }

        }
        // Address

        while(true){
            System.out.println("Please enter your street address. IN FORMAT \" 123 Steet rd \"");
            String street = sc.nextLine();
            // Checks if the address follows simple format
            if(street.matches("(?i)^[0-9]{1,5}\\s+[A-Za-z]+(?:\\s+[A-Za-z]+)*\\s+(St|Rd|Ave|Blvd|Ln|Dr|Ct)\\.?$")
            ){
                System.out.println("Address is valid.");
                user.setStreet(street);
                break;
            }
            else{
                System.out.println("Invalid format. Please try again.");
            }
        }

        // City
        while(true){
            System.out.println("Please enter your city.");
            String city = sc.nextLine();
            if(charOnly(city)){
                System.out.println("City is valid.");
                user.setCity(city);
                break;
            }
            else{
                System.out.println("Invalid format. Please try again.");
            }
        }

        // State
        while(true){
            System.out.println("Please enter your state. IN FORMAT \" MD OR TN \"");
            String state = sc.nextLine();
            if(isState(state)){
                System.out.println("State is valid.");
                user.setState(state);
                break;
            }
            else{
                System.out.println("Invalid format or state. Please try again.");
            }
        }

        // Zipcode
        while(true){
            System.out.println("Please enter your zip code. IN FORMAT \" 20770 \" ");
            String zipCode = sc.nextLine();
            if(zipCode.matches( "^\\d{5}$")){
                System.out.println("Zip code is valid.");
                user.setZip(zipCode);
                break;
            }
            else{
                System.out.println("Invalid format or zip code. Please try again.");
            }
        }
        allAccounts.add(user);
        System.out.println("Account successfully created!");
        System.out.println("Please log in to your account.");





    }
// LOGIN CLASS
    public static void logIn(){
        Scanner sc = new Scanner(System.in);
        String username;
        String password;

    while(true) {
        System.out.println("Please enter your username: ");
        username = sc.nextLine();
        System.out.println("Please enter your password: ");
        password = sc.nextLine();
        if (userExists(username)) {
           if(password.equals(activeUser.getPassWord())){
               System.out.println("Welcome back! " + activeUser.getfName());
               break;
           }
           else {
               System.out.println("Incorrect password. Please try again.");
           }
        } else {
            System.out.println("Username does not exist. Try again.");
        }
    }

    }

    public static boolean userExists(String username){
        for(Account i : allAccounts){
            if(username.equals(i.getUserName())){
                activeUser = i;
                return true;
            }
        }
        return false;
    }

    public static void mainMenu() {
        System.out.println("Welcome to the Banking App!");
        Scanner sc = new Scanner(System.in);
        int option;
        boolean loop = true;
        while (loop) {
        System.out.println("1. View balance 2. Deposit money 3. Withdraw money 4. Transfer funds 5. View account info 6. Exit");
        option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.print("Your balance is $");
                System.out.printf("%.2f%n", + activeUser.getBalance());
                break;
            case 2:
                depositFunds();
                break;
            case 3:
                withdrawFunds();
                break;
            case 4:
                transferFunds();
                break;
            case 5:
                viewInfo();
                break;
            case 6:
                loop = false;
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }
    }

    public static void depositFunds(){
        Scanner sc = new Scanner(System.in);
        double amount;
        int x;
        boolean loop = true;
        while(loop){
            System.out.println("Please enter your deposit amount: (Enter 0 to exit)");
            amount = sc.nextDouble();
            if(amount == 0){
                System.out.println("Going back to main menu.");
                loop = false;
                break;
            }
            else if(amount < 0){
                System.out.println("Invalid deposit amount. Please try again."); }
            else{
                System.out.println("Your deposit amount is $" + amount);
                System.out.println("Do you want to deposit? 1.Yes or 2.No");
                x = sc.nextInt();
                if(x == 1){
                    activeUser.addBalance(amount);
                    loop = false;
                    break;
                }
                else if(x == 2) {
                    break;
                }
                break;
            }
        }
    }

    public static void withdrawFunds(){
        Scanner sc = new Scanner(System.in);
        double amount;
        int x;
        boolean loop = true;
        while(loop){
            System.out.println("Please enter your withdraw amount: (Enter 0 to exit)");
            amount = sc.nextDouble();
            if(amount == 0){
                System.out.println("Going back to main menu.");
                loop = false;
                break;
            }
            else if(amount < 0){
                System.out.println("Invalid withdraw amount. Please try again.");
            }
            else{
                System.out.println("Your withdraw amount is $" + amount);
                System.out.println("Do you want to withdraw? 1.Yes or 2.No");
                x = sc.nextInt();
                if(x == 1){
                    activeUser.removeBalance(amount);
                    loop = false;
                    break;
                }
                else if(x == 2) {
                    break;
                }
            }
        }

    }

    public static void transferFunds(){
        Scanner sc = new Scanner(System.in);
        double amount;
        int x;
        int routNum;
        Account account2 = null;
        boolean doesExist = false;

        boolean loop = true;
        while(loop){
            System.out.println("Please enter your transfer amount: (Enter 0 to exit)");
            amount = sc.nextDouble();
            if(amount == 0){
                System.out.println("Going back to main menu.");
                loop = false;
                break;
            }
            else if(amount < 0){
                System.out.println("Invalid transfer amount. Please try again.");
            }
            else if(amount > activeUser.getBalance()){
                System.out.println("You do not have enough money. Please try again.");
            }
            else{
                System.out.println("Your transfer amount is $" + amount);
                System.out.println("Please enter the routing number of the account you wish to transfer too.");
                routNum = sc.nextInt();

                for(Account i : allAccounts){
                    if(routNum == i.getRoutNum()){
                        account2 = i;
                        doesExist = true;
                        }
                    }

                if(!doesExist) {
                    System.out.println("Account does not exist. Please try again.");
                }
                else{
                    System.out.println("Your transfer amount is $" + amount + " to " + account2.getfName() + " " + account2.getlName() + " account.");
                    System.out.println("Do you want to transfer? 1.Yes or 2.No");
                    x = sc.nextInt();
                    if (x == 1) {
                        activeUser.removeBalance(amount);
                        account2.addBalance(amount);
                        System.out.println("Transfer completed!");
                        loop = false;
                        break;
                        }
                    else {
                        break;
                        }

                }

            }

        }

    }

    public static void viewInfo(){
        System.out.println("Full Name: " + activeUser.getfName() + " " + activeUser.getlName());
        System.out.println("Email: " + activeUser.geteMail());
        System.out.println("Username: " + activeUser.getUserName());
        System.out.println("Password: " + activeUser.getPassWord());
        System.out.println("Routing Number: " + activeUser.getRoutNum());
        System.out.println("Account Number: " + activeUser.getAccountNum());
        System.out.println("Balance: " + activeUser.getBalance());
        System.out.println("Address: " + activeUser.getFullAddress());


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
    public static boolean isState(String input) {
        Set<String> states = new HashSet<>(Arrays.asList(
                "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
                "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
                "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
                "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY",
                "DC"
        ));
        return states.contains(input.trim().toUpperCase());
    }
}
