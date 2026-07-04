import java.util.Scanner;

public class ATM {

    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    public void start() {

        System.out.println("=====================================");
        System.out.println("        WELCOME TO ATM SYSTEM");
        System.out.println("=====================================");

        int attempts = 3;
        boolean login = false;

        while (attempts > 0) {

            System.out.print("Enter 4-Digit PIN: ");
            int pin = sc.nextInt();

            if (account.validatePin(pin)) {
                login = true;
                break;
            } else {
                attempts--;
                System.out.println("Incorrect PIN!");
                System.out.println("Remaining Attempts: " + attempts);
            }
        }

        if (!login) {
            System.out.println("\nAccount Blocked!");
            return;
        }

        int choice;

        do {

            System.out.println("\n=====================================");
            System.out.println("              ATM MENU");
            System.out.println("=====================================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Mini Statement");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    account.showBalance();
                    break;

                case 2:
                    System.out.print("Enter Deposit Amount: ₹");
                    double deposit = sc.nextDouble();
                    account.deposit(deposit);
                    break;

                case 3:
                    System.out.print("Enter Withdrawal Amount: ₹");
                    double withdraw = sc.nextDouble();
                    account.withdraw(withdraw);
                    break;

                case 4:
                    account.showTransactionHistory();
                    break;

                case 5:

                    System.out.print("Enter Old PIN: ");
                    int oldPin = sc.nextInt();

                    System.out.print("Enter New PIN: ");
                    int newPin = sc.nextInt();

                    account.changePin(oldPin, newPin);
                    break;

                case 6:
                    System.out.println("\nThank You For Using Our ATM.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);
    }
}
