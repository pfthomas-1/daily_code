// BEGIN
import java.util.Scanner;

class Dolt {
    
    public static void main(String[] args) {
        // Declare a variable for user input    
        Scanner scannerObject = new Scanner(System.in);

        int input = 0;
        // REPEAT AT LEAST ONCE
        do {
            System.out.print("Enter a positive number: "); // Prompt the user to enter a positive number
            input = scannerObject.nextInt(); // Read input

            if (input < 1) {
                System.out.println("Invalid input. Try again");
            }
        } while (input < 1); // WHILE (input is negative)

        System.out.printf("You entered: %d", input);// Display valid input message

        scannerObject.close();
        // END
    }
}