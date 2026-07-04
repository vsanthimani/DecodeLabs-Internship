import java.util.Scanner;

public class CurrencyConverter {

    static Scanner sc = new Scanner(System.in);

    // Currency Names
    static String[] currencyNames = {
            "Indian Rupee (INR)",
            "US Dollar (USD)",
            "Euro (EUR)",
            "British Pound (GBP)",
            "Japanese Yen (JPY)",
            "UAE Dirham (AED)",
            "Australian Dollar (AUD)",
            "Canadian Dollar (CAD)"
    };

    // Exchange Rates (Base: INR)
    static double[] rateInINR = {
            1.0,      // INR
            83.20,    // USD
            90.50,    // EUR
            106.80,   // GBP
            0.56,     // JPY
            22.65,    // AED
            55.20,    // AUD
            61.30     // CAD
    };

    public static void main(String[] args) {

        boolean continueConversion = true;

        System.out.println("==========================================");
        System.out.println("      CURRENCY CONVERTER SYSTEM");
        System.out.println("==========================================");

        while (continueConversion) {

            displayCurrencies();

            int fromCurrency = getCurrencyChoice("Select Base Currency (1-8): ");
            int toCurrency = getCurrencyChoice("Select Target Currency (1-8): ");

            double amount = getAmount();

            double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);

            System.out.println("\n==========================================");
            System.out.println("          CONVERSION RESULT");
            System.out.println("==========================================");

            System.out.printf("Amount           : %.2f %s%n",
                    amount, getCurrencyCode(fromCurrency));

            System.out.printf("Converted Amount : %.2f %s%n",
                    convertedAmount, getCurrencyCode(toCurrency));

            System.out.println("==========================================");

            System.out.print("\nDo you want another conversion? (Y/N): ");
            char choice = sc.next().charAt(0);

            if (choice != 'Y' && choice != 'y') {
                continueConversion = false;
            }
        }

        System.out.println("\nThank you for using Currency Converter!");
        sc.close();
    }

    // Display Currency List
    public static void displayCurrencies() {

        System.out.println("\nAvailable Currencies:\n");

        for (int i = 0; i < currencyNames.length; i++) {
            System.out.println((i + 1) + ". " + currencyNames[i]);
        }
    }

    // Get Currency Choice
    public static int getCurrencyChoice(String message) {

        int choice;

        while (true) {

            System.out.print(message);

            if (sc.hasNextInt()) {

                choice = sc.nextInt();

                if (choice >= 1 && choice <= 8) {
                    return choice;
                }
            } else {
                sc.next();
            }

            System.out.println("Invalid choice! Please select between 1 and 8.");
        }
    }

    // Get Amount
    public static double getAmount() {

        double amount;

        while (true) {

            System.out.print("Enter Amount: ");

            if (sc.hasNextDouble()) {

                amount = sc.nextDouble();

                if (amount > 0) {
                    return amount;
                }
            } else {
                sc.next();
            }

            System.out.println("Invalid amount! Please enter a positive number.");
        }
    }

    // Currency Conversion Method
    public static double convertCurrency(double amount, int fromCurrency, int toCurrency) {

        double amountInINR;

        if (fromCurrency == 1) {
            amountInINR = amount;
        } else {
            amountInINR = amount * rateInINR[fromCurrency - 1];
        }

        if (toCurrency == 1) {
            return amountInINR;
        } else {
            return amountInINR / rateInINR[toCurrency - 1];
        }
    }

    // Currency Code Method
    public static String getCurrencyCode(int choice) {

        switch (choice) {
            case 1:
                return "INR";
            case 2:
                return "USD";
            case 3:
                return "EUR";
            case 4:
                return "GBP";
            case 5:
                return "JPY";
            case 6:
                return "AED";
            case 7:
                return "AUD";
            case 8:
                return "CAD";
            default:
                return "";
        }
    }
}