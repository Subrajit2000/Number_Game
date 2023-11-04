import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalRounds = 0;
        int totalAttempts = 0;
        
        while (true) {
            totalRounds++;
            System.out.println("\n--- Round " + totalRounds + " ---");
            totalAttempts += playGame(scanner);

            // Display user's score
            System.out.printf("Your average attempts per round so far: %.2f%n", (double) totalAttempts / totalRounds);
            
            // Option for multiple rounds
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Thank you for playing!");
    }

    private static int playGame(Scanner scanner) {
        int number = new Random().nextInt(100) + 1;
        int attempts = 0;
        final int MAX_ATTEMPTS = 10;

        while (attempts < MAX_ATTEMPTS) {
            System.out.printf("Guess the number between 1 and 100 (Attempt %d/%d): ", attempts + 1, MAX_ATTEMPTS);
            int guess = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            attempts++;

            if (guess == number) {
                System.out.println("Congratulations! You guessed the correct number!");
                return attempts;
            } else if (guess < number) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
        }

        System.out.printf("Sorry, you've exceeded %d attempts. The number was %d.%n", MAX_ATTEMPTS, number);
        return MAX_ATTEMPTS;
    }
}
