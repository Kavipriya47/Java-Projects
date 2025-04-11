import java.util.*;

public class NumberGuessingGame {

    public static int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    public static String giveHint(int number, int guess) {
        if (guess > (number + 10) || guess < (number - 10)) {
            return "Cold";
        } else if (number == guess) {
            return "Right";
        } else {
            return "Hot";
        }
    }

    public static void runGuess() {
        int secretNumber = getRandomNumber();
        int userGuess;
        int attempts = 0;
        String hint;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100.");

        while (true) {
            System.out.print("Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            userGuess = scanner.nextInt();

            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Please enter a number within the range 1 to 100.");
                continue;
            }

            attempts++;
            hint = giveHint(secretNumber, userGuess);

            if (hint.equals("Right")) {
                System.out.println("🎉 You guessed it right in " + attempts + " attempts!");
                break;
            } else {
                System.out.println(hint);
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        runGuess();
    }
}
