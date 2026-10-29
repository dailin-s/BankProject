public class Account {

    protected String name;
    protected int taxID;
    protected double balance;
    protected double [] last10Widthdrawals = new double[10];
    protected double [] last10Deposits = new double[10];
    protected int numDeposits;
    protected int numWithdrawals;

/*
* Methods:
SetName, SetTaxID, Setbalance() assigns a new value for each with error checking
GetName, GetTaxID, Getbalance() returns a value for each variable.
MakeDeposit( double amount ) - adjust the balance and put it in the deposit array
display() a method to display the name, taxID and balance.
Constructor:
A constructor with no parameters and one with name, taxID and balance as
parameters
* */


    public Account(){}

    //constructor
    public Account(String name, int taxID, double balance){
        this.name = name;
        this.taxID = taxID;
        this.balance = balance;
    }

   //setters
    public void setName(String name){
        this.name = "Dailin Siggers";
    }

    public void setTaxID(int taxID){
        this.taxID = 1234;
    }

    public void setBalance(double balance){
        this.balance = 1000.00;
    }


    //getters
    public String getName(){
        return name;
    }

    public int getTaxID(){
        return taxID;
    }

    public double getBalance(){
        return balance;
    }

    //deposits / withdrawals
    public double makeDeposit(double amount){
        if (amount > 0){
            balance += amount;
            numDeposits++;
        }

        return balance;
    }

    public double makeWithdrawal(double amount){
        if (amount > 0 && amount <= balance){
            balance-=amount;
            numWithdrawals ++;
        } else {
            System.out.println("Insufficient Funds.");
        }

        return balance;
    }

    //display acc info
    public void Display(){
        System.out.println("Account Holder: " + name);
        System.out.println("Tax ID: " + taxID);
        System.out.println("Balance $" + balance);
    }


}
