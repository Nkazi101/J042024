package Week2.BankingApp;

public class SavingsAccount extends Account{

    private double interestRate;

    private int transactionLimit;

    private double minimumAmount;

    private int transactionCount;


   public SavingsAccount(String name, double accountBalance, String accountNo, String routingNo, double interestRate, int transactionLimit, double minimumAmount){

    super(name, accountBalance, accountNo, routingNo);
    this.interestRate = interestRate;
    this.transactionLimit = transactionLimit;
    this.minimumAmount = minimumAmount;
   }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(int transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public double getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(double minimumAmount) {
        this.minimumAmount = minimumAmount;
    }


    @Override
    public void withdraw(double amount){

        if(amount > 0){
            if(transactionCount < transactionLimit){
                if(getAccountBalance() - amount >= minimumAmount){
                    super.withdraw(amount);
                    transactionCount++;
                }else{
                    System.out.println("You cannot exceed the minimum amount");
                }
            }else{
                System.out.println("You've reached your transaction limit");
            }

        }else{
            System.out.println("Invalid value. Please enter a positive amount");
        }

    }
    

    @Override
    public void monthlyprocessing(){

        double interestValue = getAccountBalance() * interestRate;
        super.deposit(interestValue);

        //reset the transaction count at the end of every month
        transactionCount = 0;

    }


    @Override
    public void transfer(double amount, Account transferAccount){

       
        if(amount > 0){
            if(transactionCount < transactionLimit){
                if(getAccountBalance() - amount >= minimumAmount){
                    super.withdraw(amount);
                    transferAccount.deposit(amount);
                    transactionCount++;
                }else{
                    System.out.println("You cannot exceed the minimum amount");
                }
            }else{
                System.out.println("You've reached your transaction limit");
            }

        }else{
            System.out.println("Invalid value. Please enter a positive amount");
        }

    }
    


    
}
