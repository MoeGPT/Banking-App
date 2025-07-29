import java.io.*;
import java.util.*;

public class FileHandler implements Serializable{

    
    
    
    public static void saveAccounts(LinkedList<Account> fileName) {
        try {
           FileOutputStream fileOut = new FileOutputStream("C:\\Users\\moesp.MOEOS\\Coding project\\Banking app\\src\\AccountInfo.dat");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(fileName);
           out.close();
           fileOut.close();

           System.out.println("info saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* 
    public static void getAccounts(Linked){
        for(file)
        System.out.println();

    }
        */
}
