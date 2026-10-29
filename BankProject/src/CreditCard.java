public class CreditCard extends Account {

    private int cardNumber;
    private String[] last10Charges = new String[10];
    private double[] last10ChargeAmounts = new double[10];
    private int numCharges;

    // default constructor
    public CreditCard() {
        super();
    }

    // parameterized constructor
    public CreditCard(String name, int taxID, double balance, int cardNumber) {
        super(name, taxID, balance);
        this.cardNumber = cardNumber;
    }

    // make a charge (withdrawal in base class)
    public void debitCharge(String chargeName, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid charge amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds for charge.");
            return;
        }

        balance -= amount; // reduce balance like a withdrawal

        // record in base withdrawals
        last10Widthdrawals[numWithdrawals % 10] = amount;
        numWithdrawals++;

        // record charge details
        last10Charges[numCharges % 10] = chargeName;
        last10ChargeAmounts[numCharges % 10] = amount;
        numCharges++;

        System.out.println("Charge of $" + amount + " for " + chargeName + " successful.");
    }

    // make a payment (deposit in base class)
    public void makePayment(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid payment amount.");
            return;
        }

        balance += amount; // payment increases balance

        last10Deposits[numDeposits % 10] = amount;
        numDeposits++;

        System.out.println("Payment of $" + amount + " successful.");
    }

    // display method
    public void display() {
        System.out.println("Credit Card for: " + name);
        System.out.println("Card Number: " + cardNumber);

        System.out.println("Last 10 Charges:");
        int count = Math.min(numCharges, 10);
        for (int i = 0; i < count; i++) {
            int index = (numCharges - count + i) % 10;
            System.out.println(last10Charges[index] + " - $" + last10ChargeAmounts[index]);
        }

        System.out.println("\nLast 10 Payments:");
        count = Math.min(numDeposits, 10);
        for (int i = 0; i < count; i++) {
            int index = (numDeposits - count + i) % 10;
            System.out.println("$" + last10Deposits[index]);
        }

        System.out.println("Current Balance: $" + balance);
    }
}

