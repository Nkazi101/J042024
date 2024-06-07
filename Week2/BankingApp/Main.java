package Week2.BankingApp;

import java.util.HashMap;
import java.util.Map;

public class Main {

    

    public static void main(String[] args){


        //we created an instance of the CheckingAccount class
        Account checkAcct = new CheckingAccount("Storm Agnew", 36700.56, "007","0900031",250.00 );

        Account savingsAcct = new SavingsAccount("Star", 60456.70, "100","0810044", 6.7, 5, 5000);

        

        System.out.println("Your account balance is: " + checkAcct.getAccountBalance());


        checkAcct.withdraw(650.50);

        System.out.println("Your new account balance after withdrawal is: " + checkAcct.getAccountBalance());


        checkAcct.deposit(420.22);        

        System.out.println("Your new account balance after depositing is: " + checkAcct.getAccountBalance());


        checkAcct.transfer(900.89, savingsAcct);

        System.out.println(checkAcct.getName() + " your new balance after your transfer is: " + checkAcct.getAccountBalance());
        System.out.println(savingsAcct.getName() + " your new balance after receiving a transfer is: " + savingsAcct.getAccountBalance());


        //declared the hashmap
        Map<String, Account> acclookup = new HashMap<>();

         //adds a key-value pair to the HashMap
        acclookup.put(checkAcct.getAccountNo(), checkAcct);
        acclookup.put(savingsAcct.getAccountNo(), savingsAcct);

        //retrieves the value associated with the specified key
        System.out.println(acclookup.get("007"));


    }
    
}


//a static method belongs to the class itself and a non-static method belongs to each object that is generated from the class.
// if your method does something that doesn't depend on the individual characteristics of it's class, make it static. Otherwise, it should non-static.

