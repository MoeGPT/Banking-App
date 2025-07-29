import java.io.*;
import java.util.*;

public class FileHandler implements Serializable{

    
    
    
    public static void saveAccounts(LinkedList<Account> listName, String fileName) {
        try {
           ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
           out.writeObject(listName);
           out.close();
           
           System.out.println("info saved!");
        } catch (Exception e) {
            System.out.println("Error getting accounts ");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static LinkedList<Account> loadAccounts(String filename) {
        LinkedList<Account> accounts = new LinkedList<>();

        File file = new File(filename);
        if (!file.exists()) return accounts; // Return empty list if file doesn't exist

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            accounts = (LinkedList<Account>) in.readObject();
            System.out.println("Accounts loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }

        return accounts;
    }
    /* 
    public static void getAccounts(Linked){
        for(file)
        System.out.println();

    }
        */
}
