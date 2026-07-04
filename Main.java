public class Main {

    public static void main(String[] args) {

        // Create Bank Account
        BankAccount account = new BankAccount(
                "Shanthi",
                1234,          // Default PIN
                10000.00       // Initial Balance
        );

        // Start ATM
        ATM atm = new ATM(account);
        atm.start();
    }
}
