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
    double balance = 0.00;
    String streetAddress;
    String city;
    String state;
    String zipCode;
    String fullAddress;

    public String getfName(){
        return this.fName;

    }
    public String getlName(){
        return this.lName;
    }
    public String geteMail(){
        return this.eMail;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getPassWord(){
        return this.passWord;
    }

    public String getFullAddress(){
        setAddress();
        return this.fullAddress;
    }
    public double getBalance(){
        return this.balance;
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
     
    public void setZip(String zipCode){
        this.zipCode = zipCode;
    }

    
    public void setAddress(){
        this.fullAddress = streetAddress + ", " + city +" " + state + ", " + zipCode;
      
    }

    public void addBalance(double amount){
        this.balance += amount;
    }

    public void removeBalance(double amount){
        this.balance -= amount;
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
    
    
