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
    long accountNum; 
    double balance;
    String streetAddress;
    String city;
    String state;
    int zipCode;
    String country; 
    String fullAddress;

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
    
    public void setRoutNum(int num){
        this.routingNum = num;
    }

    public void setAccountNum(long num){
        this.accountNum = num;
    }
    
    public void setStreet(String street){
        this.streetAddress = street;
    }
    public void setCity(String city){
        this.city = city;
    }
    
    public void setState(String state){
        this.state = state;

    }
     
    public void setZip(int zipCode){
        this.zipCode = zipCode;
    }
    
    public void setCountry(String country){
        this.country = country;

    }
    
    public void setAddress(){
        this.fullAddress = streetAddress + " " + city +", " + state + " " + zipCode + ", " + country;
      
    }

    public int getRoutNum(){
        return routingNum;
    }
    public long getAccountNum(){
        return accountNum;
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
    
    
