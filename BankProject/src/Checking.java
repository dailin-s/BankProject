public class Checking extends Account {

    /*
    *
    Checking Class General Requirements
    A specific DERIVED class that represents a bank checking account. It must inherit
    (extends) Account.
    Variables (private):
    last10checks – an int array of size 10. The last 10 check numbers.
    Methods:
    WriteCheck( int checknum, double amount ) - adjust the balance and list it as a
    withdraw in the base class
    display() - display the accounts check register (number and amount) and deposit
    record.
    Constructor:
    A constructor with no parameters and one with name, taxID and balance
    parameters
    * */

    private int last10Checks [] = new int [10];
    private int numChecks;

    public Checking(){}

    public Checking(String name, int taxID, double balance){
        super(name, taxID, balance);
    }

    public void writeCheck(int checknum, double amount){
        if (amount>=0) {
            System.out.println("Invalid check amount.");
            return;
        }
        if (amount > balance){
            System.out.println("Inefficient funds for check #: " + checknum);
            return;
        }

        balance -= amount;

        last10Checks[numChecks % 10] = checknum;
        numChecks++;

        System.out.println("Check #: " + checknum + "for $" + amount + "written successfully.");
    }
}
