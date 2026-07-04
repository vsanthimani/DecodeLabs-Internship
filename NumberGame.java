import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        char playAgain;

        System.out.println("======================================");
        System.out.println("         NUMBER GAME PROJECT");
        System.out.println("======================================");

        do {

            int randomNumber = random.nextInt(100) + 1;
            int guess;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                guess = sc.nextInt();

                // Check valid range
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess > randomNumber) {
                    System.out.println("Too High!");
                } else if (guess < randomNumber) {
                    System.out.println("Too Low!");
                } else {
                    guessedCorrectly = true;
                    break;
                }
            }

            System.out.println("\n================ RESULT ================");

            if (guessedCorrectly) {

                System.out.println("Congratulations!");
                System.out.println("You guessed the correct number.");
                System.out.println("Number = " + randomNumber);
                System.out.println("Attempts = " + attempts);

                if (attempts <= 3) {
                    System.out.println("Score : ★★★ Excellent!");
                } else if (attempts <= 6) {
                    System.out.println("Score : ★★ Good Job!");
                } else {
                    System.out.println("Score : ★ Nice Try!");
                }

            } else {
                System.out.println("Game Over!");
                System.out.println("You have used all " + maxAttempts + " attempts.");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("========================================");

            System.out.print("\nDo you want to play again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\nThank you for playing the Number Game!");
        sc.close();
    }
}