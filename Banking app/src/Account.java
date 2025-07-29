import java.io.*;



/**
 *
 * @author moesp
 * Contains general banking information and will have basic banking methods to set, get, and modify information. 
 * i.e(check balance, or withdraw balance) 
 *
 * 
 **/
 
public class Account implements Serializable{
    private static final long serialVersionUID = 12L;

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

    public String getName(){
        return this.fName;

    }
    // sets first name
    public void setfName(String name){
        this.fName = name;
    }
    // sets last name
    public void setlName(String name){
        this.lName = name;
    }
    public void setEmail(String email) {
        this.eMail = email;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public void setPassword(String password) {
        this.passWord = password;
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
    



}
    
    
