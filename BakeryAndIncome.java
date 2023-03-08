// Importing
import java.util.Random;
import java.util.Scanner;
/**
* Get the user's bakery order.
* Get the user's income and tell
* them if it is average, low or high.
*
* @author  Adrijan Vranjkovic
* @version 1.0
* @since   2023-02-14
*/

// Making class
public final class BakeryAndIncome {

    /**
     * This is a private constructor used to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private BakeryAndIncome() {
        throw new IllegalStateException("Utility class.");
    }

    /**
    * This is the main method.
    *
    * @param args Unused.
    */
    public static void main(String[] args) {
        // create instance of Random class.
        final Random rand = new Random();

        // Greeting the user and telling them about the program.
        System.out.println("Welcome to Adrijan's bakery.");
        System.out.println("We are selling croissants for 2.25$");
        System.out.println("If you buy 6 or more you don't pay HST.");
        System.out.println("If you buy 10 or more you get a mystery discount.");
        System.out.println("How many would you like to purchase");

        // Creating a scanner and using it to get user input.
        final Scanner scanner = new Scanner(System.in);
        final String userOrder = scanner.nextLine();

        // Making sure user doesn't enter a string.'
        try {

            // Make user input an int.
            final double orderAsInt = Integer.parseInt(userOrder);

            // Check for valid input.
            if (orderAsInt >= 10) {
                // calculate the cost of the order.
                final double orderPrice = 2.25 * orderAsInt;

                // Generate random integers in range 0 to 10.
                int randInt = rand.nextInt(9);
                randInt = randInt + 1;

                // Calculate the total with discount.
                final double total = orderPrice - randInt;

                // Display the total cost.
                System.out.println("The final price with a "
                    + randInt + "$ discount is "
                        + total + "$.");
            } else if (orderAsInt >= 6) {
                // calculate the cost of the order.
                final double orderPrice = 2.25 * orderAsInt;
                // Display the total cost.
                System.out.println("The final price is "
                    + orderPrice + "$.");
            } else if (orderAsInt >= 0) {
                // calculate the cost of the order.
                final double orderPrice = 2.25 * orderAsInt;

                // Calculate price with HST.
                final double hstTotal = 0.13 * orderPrice;
                final double total = orderPrice - hstTotal;

                // Display the total cost.
                System.out.println("The final price is "
                    + String.format("%.2f", total)
                        + "$, after HST.");
            } else {
                 // Display if user enters invalid input.
                System.out.println("That is not a valid input.");
            }

        } catch (NumberFormatException error) {
            // Display if user enters invalid input.
            System.out.println("Please enter a valid input!"
                + error.getMessage());
        }
        // Generate random integers in range 0 to 100000.
        int randInt2 = rand.nextInt(100000);
        randInt2 = randInt2 + 1;

        // Greet user and ask for their income.
        System.out.println("Enter your yearly income:");
        System.out.println("For example " + randInt2 + ".");

        // Read user input.
        final String userIncome = scanner.nextLine();

        // Make sure user doesn't enter a string.
        try {
            // Make user input an int.
            final double incomeAsInt = Double.parseDouble(userIncome);

            // Check for valid input.
            if (incomeAsInt < 0) {
                // Display invalid input.
                System.out.println("That is not a valid input.");

            } else if (incomeAsInt > 60000) {
                // Display above average income.
                System.out.println("Your income is above average.");
            } else if (incomeAsInt < 60000) {
                // Display below average income.
                System.out.println("Your income is under average.");
            } else {
                // Display average income.
                System.out.println("Your income is average.");
            }
        } catch (NumberFormatException error) {
            // Display error.
            System.out.println("Please enter a valid input!"
                + error.getMessage());
        }

        // Close scanner.
        scanner.close();
    }
}
