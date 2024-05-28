package Week2.BankingApp;

public abstract class Account  {

//instance variables
private String name;
private double accountBalance;
private String accountNo;
private String routingNo;

//default constructor
public Account(){

}

//parameterized constructor
public Account(String name, double accountBalance, String accountNo, String routingNo){

    this.name = name;
    this.accountBalance = accountBalance;
    this.accountNo = accountNo;
    this.routingNo = routingNo;

    // The this keyword is an essential part of Java's object-oriented programming:

//Differentiating instance variables from local variables: Ensures that the code refers to the current object's fields.
//Invoking current class methods: Allows calling another method within the same class.
//Invoking current class constructors: Facilitates constructor chaining for better code reuse and initialization.

}

//getters and setters
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public double getAccountBalance() {
    return accountBalance;
}
public void setAccountBalance(double accountBalance) {
    this.accountBalance = accountBalance;
}
public String getAccountNo() {
    return accountNo;
}
public void setAccountNo(String accountNo) {
    this.accountNo = accountNo;
}
public String getRoutingNo() {
    return routingNo;
}
public void setRoutingNo(String routingNo) {
    this.routingNo = routingNo;
}


public void withdraw(double amount){

    //do we need do any checks on the amount before using it
    //what should i do with the amount with respect to the accountbalance
    //we need to check whether we have enough 
    if(amount > 0 && amount <= accountBalance){
        //accountBalance = accoutBalance - amount;
        accountBalance -= amount;
    }
}

public void deposit(double amount){

    if(amount > 0){
        //add the amount to the accountBalance
        accountBalance += amount;

    }


}

public abstract void transfer(double amount, Account transferAccount);

public abstract void monthlyprocessing();


    
}
