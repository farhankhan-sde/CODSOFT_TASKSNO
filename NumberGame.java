import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        System.out.println("=================================");
        System.out.println("        NUMBER GUESSING GAME");
        System.out.println("=================================");

        do {
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    int roundScore = maxAttempts - attempts + 1;
                    totalScore += roundScore;
                    System.out.println("Attempts used: " + attempts);
                    System.out.println("Round score: " + roundScore);
                    guessed = true;
                    break;
                } else if (guess < number) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessed) {
                System.out.println("You used all attempts.");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("Total score: " + totalScore);
            System.out.print("Play another round? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\nThanks for playing!");
        System.out.println("Final score: " + totalScore);
        sc.close();
    }
}
