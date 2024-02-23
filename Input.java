import java.util.Scanner;

public class Input {
    public static double inputDoubleRange(String prompt, double min, double max) {
        double value;
        do {
            System.out.print(prompt);
            value = inputDouble(prompt);
            if (value < min || value > max) {
                System.out.println("Value must be between " + min + " and " + max + "!");
            } else {
                break;
            }
        } while (true);
        return value;
    }

    public static double inputDouble(String prompt) {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(new Scanner(System.in).next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.println();
            }
        }
        return value;
    }

    public static String input(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.next();
    }

    public static int inputInt(String prompt) {
        int value = 0;
        boolean isValidInput = false;
    
        while (!isValidInput) {
            try {
                value = Integer.parseInt(input(prompt));
                isValidInput = true; // Break out of the loop if parsing is successful
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.println();
            }
        }
    
        return value;
    }

    public static boolean inputBoolean(Scanner scanner, String prompt) {
        boolean result = false;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt + " ");
            String userInput = scanner.next().toLowerCase();

            if (userInput.equals("yes") || userInput.equals("y")) {
                result = true;
                validInput = true;
            } else if (userInput.equals("no") || userInput.equals("n")) {
                result = false;
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }

        return result;
    }
}