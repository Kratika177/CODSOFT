/*
1. Generate a random number within a specified range, such as 1 to 100.

2. Prompt the user to enter their guess for the generated number.

3. Compare the user's guess with the generated number and provide feedback on whether the guess
is correct, too high, or too low.

4. Repeat steps 2 and 3 until the user guesses the correct number.

You can incorporate additional details as follows:

5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the number of attempts taken or rounds won.
*/




package NumberGuessingGame;
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random ran = new Random();
        
        int mr = 1;
        int maxr = 100;
        int ma = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int tn = ran.nextInt(maxr - mr + 1) + mr;
            System.out.println("I've chosen a number between " + mr + " and " + maxr + ".");
            
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            while (attempts < ma) {
                System.out.print("Enter your guess: ");
                int ug = scanner.nextInt();
                attempts++;

                if (ug == tn) {
                    System.out.println("Congratulations! You guessed the number " + tn + " correctly in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                    score++;
                    break;
                } else if (ug < tn) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + tn + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Game over. Your final score is: " + score);
    }
}
