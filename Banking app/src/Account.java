import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;



/**
 *
 * @author moesp
 * Contains general banking information and will have basic banking methods to set, get, and modify information. 
 * i.e(check balance, or withdraw balance) 
 *
 * 
 **/
 
public class Account{
    
    String fName;
    String lName;
    String eMail;
    String userName;
    String passWord;
    int routingNum;
    int accountNum; 
    Float balance;
    String streetAddress;
    String state;
    int zipCode;
    String country; 
    Scanner sc = new Scanner(System.in);

    File userNames = new File("C:\\Users\\moesp.MOEOS\\Coding project\\test as\\src\\usernames.txt");
    
    
    
    public void signUp() throws Exception{
        setfName();
        setlName();
        setEmail();
        setLogin();
        setAccountInfo();
        setAddress();
        
       
    }
    // sets first name
    public void setfName(){
        System.out.println("Please enter your first name: ");
        this.fName = sc.nextLine();
        
        if (!charOnly(fName)){
            System.out.println("*Please only enter characters*");
            setfName();
        }

    }
    // sets last name
    public void setlName(){
        System.out.println("Please enter your last name: ");
        this.lName = sc.nextLine();
        
        if (!charOnly(lName)){
            System.out.println("*Please only enter characters*");
            setlName();
        }
    }
    //sets email and ensure it is in a valid format
    public void setEmail(){
        //Pattern for email format
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        
        System.out.println("Please enter your email address: ");
        this.eMail = sc.nextLine();
        
        Matcher matcher = pattern.matcher(eMail);
        if (matcher.matches()) {
                System.out.println("Valid email address.");
            }
            else {
                System.out.println("Invalid email address. Please try again.");
                setEmail();
            }



    }
    // sets the username and checks to see if it already exists
    public void setUsername() throws Exception{
        System.out.println("Please enter a username: ");
        this.userName = sc.nextLine();
        
        // input validation 
        if (userName.matches("^[a-zA-Z0-9_]+$")) {
            Scanner scUser = new Scanner(userNames);
            String takenName;
            while(scUser.hasNextLine()){
            takenName = scUser.nextLine();
                if(userName.equals(takenName)){
                    System.out.println("That username is already taken. Please try again");
                    this.userName = sc.nextLine();
            }
            
            }
            scUser.close();

            //this should allow a new username to be added to the end of the file 
            System.out.println("Valid username.");
            try(FileWriter fw = new FileWriter(userNames, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(userName);
            } catch (IOException e) {
            //exception handling left as an exercise for the reader
            }       

     
        } 
        else {
            System.out.println("Invalid username. Only letters, digits, and underscores are allowed.");
        }

    }
    
    // sets and verify password
    public void setPassword(){
    String verifyP = "n";
    while(!verifyP.equals(passWord)) {
        System.out.println("Please enter a password: ");
        this.passWord = sc.nextLine();
        
        System.out.println("Please confirm your password: ");
        verifyP = sc.nextLine();
        
        if (!verifyP.equals(passWord)){
            System.out.println("Passwords do not match. Please try again.");
        }
    }


    }
    
    public void setLogin() throws Exception{
        setUsername();
        setPassword();
    }
    public void setAccountInfo(){

    }
    
    public void setStreet(){}
    
    public void setState(){}
     
    public void setZip(){}
    
    public void setCountry(){}
    
    public void setAddress(){
        setStreet();
        setState();
        setZip();
        setCountry();
    }
    
    public void showAdd(){}
    
    public void showState(){}
    
    public void showZip(){}
    
    public void showCountry(){}
    
    public void showAddress(){
        showAdd();
        showZip();
        showState();
        showCountry();
    }
    //checks 
    
    public boolean charOnly(String name) {
    char[] chars = name.toCharArray();
    for (char c : chars) {
        if(!Character.isLetter(c)) {
            return false;
        }
    }

    return true;
}


}
    
    
