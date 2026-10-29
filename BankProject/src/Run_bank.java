import java.util.Scanner;

public class Run_bank extends Account {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // create accounts
        Savings savings = new Savings("Alice", 1111, 100.0);
        Checking checking = new Checking("Bob", 2222, 100.0);
        CreditCard credit = new CreditCard("Charlie", 3333, 100.0, 123456);

        boolean running = true;

        while (running) {
            System.out.println("\nChecking balance: $" + checking.getBalance() +
                    " Savings balance: $" + savings.getBalance() +
                    " Credit Card balance: $" + credit.getBalance());

            System.out.println("\nMENU");
            System.out.println("1. Savings Deposit");
            System.out.println("2. Savings Withdrawal");
            System.out.println("3. Checking Deposit");
            System.out.println("4. Write A Check");
            System.out.println("5. Credit Card Payment");
            System.out.println("6. Make A Charge");
            System.out.println("7. Display Savings");
            System.out.println("8. Display Checking");
            System.out.println("9. Display Credit Card");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    savings.makeDeposit(input.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    savings.doWithdraw(input.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter deposit amount: ");
                    checking.makeDeposit(input.nextDouble());
                    break;
                case 4:
                    System.out.print("Enter check number: ");
                    int checkNum = input.nextInt();
                    System.out.print("Enter check amount: ");
                    double checkAmt = input.nextDouble();
                    checking.writeCheck(checkNum, checkAmt);
                    break;
                case 5:
                    System.out.print("Enter payment amount: ");
                    credit.makePayment(input.nextDouble());
                    break;
                case 6:
                    input.nextLine(); // clear buffer
                    System.out.print("Enter charge name: ");
                    String chargeName = input.nextLine();
                    System.out.print("Enter charge amount: ");
                    double chargeAmt = input.nextDouble();
                    credit.debitCharge(chargeName, chargeAmt);
                    break;
                case 7:
                    savings.getBalance();
                    break;
                case 8:
                    checking.getBalance();
                    break;
                case 9:
                    credit.display();
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        input.close();
        System.out.println("Exiting Bank App. Goodbye!");
    }
}
