package Week2.BankingApp;

public class Main {


    public static void main(String[] args){


        Account checkAcct = new CheckingAccount("Storm Agnew", 36700.56, "007","0900031",250.00 );


        System.out.println("Your account balance is: " + checkAcct.getAccountBalance());


        checkAcct.withdraw(650.50);

        System.out.println("Your new account balance is: " + checkAcct.getAccountBalance());


        checkAcct.deposit(420.22);        

        System.out.println("Your new account balance is: " + checkAcct.getAccountBalance());





    }
    
}
