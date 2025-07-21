import java.util.*;

/**
 *
 * @author moesp
 * Contains general banking information and will have basic banking methods to set, get, and modify information. 
 * i.e(check balance, or withdraw balance) 
 *
 * 
 **/
 
public class Account {
    
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


}
    
    
