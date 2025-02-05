// BEGIN
import java.util.Scanner;

class GuessNumber {

    static int generateNumber(int min, int max) { // Returns a random number that is between min and max inclusive
        return (int)(min + Math.random() * (max + 1));
    }


    static void blankLine() { // Exists only for formatting and readability
        System.out.println("");
    }


    static void guessNumber() {
        Scanner scannerObject = new Scanner(System.in);

        int min = 0;
        int max = 100;

        int answer = generateNumber(min, max); // Choose a hidden number
        
        System.out.printf("Guess a magic number between %d and %d\n", min, max); // Prompt the user to start guessing

        // Repeat until the correct guess is made
        while (true) {
            blankLine();
            
            System.out.print("Enter your guess: "); // Ask for a guess
            int guess = scannerObject.nextInt(); // Get user input
            
            if (guess == answer) { // IF the guess is correct THEN
                System.out.printf("Yes, the number is %d", answer); // Display success message
                break; // Exit the loop
            } else if (guess > answer) { // ELSE IF the guess is too high THEN
                System.out.println("Your guess is too high"); //         Give a hint
            } else {//     ELSE
                System.out.println("You guess is too low"); // Give a different hint
            } //     END IF
        }

        scannerObject.close();
    }


    public static void main(String[] args) {
        guessNumber();
    }
    
    // END
}