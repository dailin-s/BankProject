public class Savings extends Account{
     /*
    Savings Class General Requirements
    A specific DERIVED class that represents a bank savings account. It must inherit
    Account.
    Methods:
    DoWithdraw( double amount) - adjust the balance and list it as a withdraw in the
    base class
    display() - display the accounts withdrawal and deposit record
    Constructor:
    A constructor with no parameters and one with name, taxID and balance
    parameters
    * */

    public Savings(){
        super();
    }

    public Savings(String name, int taxID, double balance){
        super(name, taxID, balance);
    }

    public void doWithdraw(double amount){
        if (amount <= 0){
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (amount > balance){
            System.out.println("Insufficient funds for withdrawal.");
            return;
        }

        balance -= amount;

        last10Widthdrawals[numWithdrawals % 10] = amount;
        numWithdrawals++;

        System.out.println("Withdrawal of $" + amount + "successful.");
    }

    public void Display(){
        System.out.println("Savings for: " + name);

        System.out.println("Last 10 Withdrawals");
        int count = Math.min(numWithdrawals, 10);
        for (int i = 0; i < count; i++){
            int index = (numWithdrawals - count + i) % 10;
            System.out.println("$" + last10Deposits[index]);
        }

        System.out.println("\nLast 10 deposits:");
        count = Math.min(numDeposits, 10);
        for (int i = 0; i < count; i++) {
            int index = (numDeposits - count + i) % 10;
            System.out.println("$" + last10Deposits[index]);
        }

        System.out.println("Current Balance: $" + balance);

    }
}
