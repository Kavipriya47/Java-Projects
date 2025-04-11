public class Calculator{

    public static String calculatorDisplay() {
        return "Welcome to Calculator\n" +
               "Choose one operation:\n" +
               "1. Add\n" +
               "2. Subtract\n" +
               "3. Multiply\n" +
               "4. Divide\n" +
               "5. Exit\n";
    }

    public static void userInput(Scanner scanner, int[] numbers) {
        System.out.print("Number 1 is: ");
        numbers[0] = scanner.nextInt();
        System.out.print("Number 2 is: ");
        numbers[1] = scanner.nextInt();
    }

    public static int addition(int a, int b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static String division(int a, int b) {
        if (b == 0) {
            return "Cannot divide by zero!";
        }
        int quotient = a / b;
        int remainder = a % b;
        return "Quotient: " + quotient + ", Remainder: " + remainder;
    }

    public static String calculatorFunction(int userChoice, Scanner scanner) {
        int[] numbers = new int[2];
        String result = "";

        if (userChoice >= 1 && userChoice <= 4) {
            userInput(scanner, numbers);
        }

        switch (userChoice) {
            case 1:
                result = "The sum is: " + addition(numbers[0], numbers[1]);
                break;
            case 2:
                result = "The difference is: " + subtraction(numbers[0], numbers[1]);
                break;
            case 3:
                result = "The product is: " + multiplication(numbers[0], numbers[1]);
                break;
            case 4:
                result = division(numbers[0], numbers[1]);
                break;
            case 5:
                result = "Exiting the calculator, bye bye!";
                break;
            default:
                result = "Operation does not exist - please provide the correct input";
                break;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(calculatorDisplay());
            System.out.print("Select the operation: ");

            try {
                int userChoice = scanner.nextInt();

                String result = calculatorFunction(userChoice, scanner);
                System.out.println(result);

                if (userChoice == 5) break;

            } catch (InputMismatchException e) {
                System.out.println("Operation does not exist - please provide the correct input");
                scanner.nextLine(); // clear invalid input
            }
        }

        scanner.close();
    }
}
