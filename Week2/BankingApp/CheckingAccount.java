package Week2.BankingApp;

public class CheckingAccount extends Account {

    //instance variables unique to the checking account
    private double overdraftLimit;

    //default constructor
    public CheckingAccount(){

    }

    //parameterized constructor
    public CheckingAccount(String name, double accountBalance, String accountNo, String routingNo, double overdraftLimit){
        super(name, accountBalance, accountNo, routingNo);
        this.overdraftLimit = overdraftLimit;
    }

    //getters and setters
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }


    //methods - actions/behaviors which are associated with the class
    //override 
    @Override
    public void withdraw(double amount){

        if(amount > 0 && amount <= getAccountBalance() + overdraftLimit){
            
            //super keyword is used to refer to the immediate parent class of the current class you're in.
            super.withdraw(amount);
        }else{
            System.out.println("Your balance is insufficient or you have surpassed the overdraft limit");
        }

    }


    @Override
    public void transfer(double amount, Account transferAccount){

        //transferring is withdrawing an amount from one account, and depositing it in another account
        if(amount > 0 && amount <= getAccountBalance() + overdraftLimit){

            withdraw(amount);
            transferAccount.deposit(amount);
            System.out.println("You have successfully transferred: $" + amount + "from " + getAccountNo() + "to " + transferAccount.getAccountNo());

        }
        else{
            System.out.println("Transfer failed. You may have insufficinet funds or you've surpassed the overdraft limit");
        }

    }

    @Override
    public void monthlyprocessing(){
        //unimplemented
    }

    @Override
    public String toString() {
        return "CheckingAccount [getName()=" + getName() + ", getAccountBalance()=" + getAccountBalance()
                + ", getAccountNo()=" + getAccountNo() + ", getRoutingNo()=" + getRoutingNo() + "]";
    }
    

    
}
