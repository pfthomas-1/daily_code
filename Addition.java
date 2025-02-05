// BEGIN
import java.util.Scanner;

class Addition {
    
    static int generateNumber(int min, int max) { // Returns a random number that is between min and max inclusive
        return (int)(min + Math.random() * (max + 1));
    }


    static void additionQuestion() {
        Scanner scannerObject = new Scanner(System.in);

        // Generate two random numbers between 0 and 9
    
        int number1 = generateNumber(0, 9); // SET number1 = RANDOM(0-9)
        int number2 = generateNumber(0, 9); // SET number2 = RANDOM(0-9)


        // Prompt user for input
        
        System.out.printf("What is %d + %d? ", number1, number2); // PRINT "What is " + number1 + " + " + number2 + "? "
        int answer = scannerObject.nextInt(); // READ answer

        while (answer != number1 + number2) { // Keep asking until the user gets it right
            System.out.printf("Wrong answer. Try again. What is %d + %d? ", number1, number2); // PRINT "Wrong answer. Try again. What is " + number1 + " + " + number2 + "? "
            answer = scannerObject.nextInt(); // READ answer    
        }

        // Correct answer message

        System.out.println("You got it!"); // PRINT "You got it!"
        
        scannerObject.close();
    }
    

    public static void main(String[] args) {
        additionQuestion();
    }

    // END
}