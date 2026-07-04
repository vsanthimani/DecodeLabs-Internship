public class BankAccount {

    private String accountHolder;
    private int pin;
    private double balance;
    private StringBuilder transactionHistory;

    public BankAccount(String accountHolder, int pin, double balance) {
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = balance;
        transactionHistory = new StringBuilder();
        transactionHistory.append("Account Created with Balance: ₹")
                          .append(balance)
                          .append("\n");
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public boolean validatePin(int enteredPin) {
        return pin == enteredPin;
    }

    public void changePin(int oldPin, int newPin) {
        if (pin == oldPin) {
            pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect old PIN.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Amount.");
            return;
        }

        balance += amount;
        transactionHistory.append("Deposited : ₹")
                          .append(amount)
                          .append("\n");

        System.out.println("Deposit Successful.");
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance.");
            return;
        }

        balance -= amount;

        transactionHistory.append("Withdrawn : ₹")
                          .append(amount)
                          .append("\n");

        System.out.println("Withdrawal Successful.");
    }

    public void showBalance() {
        System.out.printf("Current Balance : ₹%.2f%n", balance);
    }

    public void showTransactionHistory() {

        System.out.println("\n========== MINI STATEMENT ==========");
        System.out.println(transactionHistory.toString());
        System.out.printf("Current Balance : ₹%.2f%n", balance);
    }
}
