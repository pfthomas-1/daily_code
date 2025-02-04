// Import necessary classes
import java.util.Scanner;

public class JavaQuickMaths {
    static void blankLine() { // Exists only for formatting and readability
        System.out.println("");
    }


    static void roundingLoop() { // 1. Loop from 1.0 to 5.0, incrementing by 0.5
        //    - Print the number
        //    - Apply and print results of:
        //      - Math.ceil()
        //      - Math.floor()
        //      - Math.rint()
        //      - Math.round()

        double ceilNum;
        double floorNum;
        double rintNum;
        double roundNum;

        System.out.println("Looping from 1.0 to 5.0 with rounding methods");

        for (double num = 1.0; num <= 5.0; num += 0.5) {
            ceilNum = Math.ceil(num);
            floorNum = Math.floor(num);
            rintNum = Math.rint(num);
            roundNum = Math.round(num);

            System.out.printf("Number: %s Ceil: %s Floor: %s Rint: %s Round: %s\n", num, ceilNum, floorNum, rintNum, (int)roundNum);
        }

        blankLine();
    }


    static double inputRounding(Scanner scannerObject) { // 2. Prompt the user to enter a decimal number
        //    - Store the number
        //    - Print the rounding results (ceil, floor, rint, round)

        System.out.print("Enter a decimel number: ");
        double num = scannerObject.nextDouble();

        double ceilNum = Math.ceil(num);
        double floorNum = Math.floor(num);
        double rintNum = Math.rint(num);
        double roundNum = Math.round(num);

        System.out.printf("Ceil: %s Floor: %s Rint: %s Round: %s\n", ceilNum, floorNum, rintNum, (int)roundNum);

        blankLine();

        return num;
    }


    static int inputInteger(Scanner scannerObject) { // 3. Prompt the user to enter an integer
        //    - Store the integer
        System.out.print("Enter an integer: ");
        int num = scannerObject.nextInt();

        return num;
    }


    static String inputString(Scanner scannerObject) {
        //    - Prompt the user to enter a string
        //    - Store the string

        System.out.print("Enter a word: ");
        String word = scannerObject.next();

        return word;
    }


    static void printIntAndString(int num, String word) {
        //    - Print the entered integer and string

        System.out.printf("You entered integer: %s\n", num);
        System.out.printf("You entered string: %s\n", word);

        blankLine();
    }


    static void casting(int intNum, double doubleNum) { // 4. Demonstrate type casting
        //    - Convert the integer to double (implicit cast) and print
        //    - Convert the decimal number to int (explicit cast) and print
        //    - Convert the integer to a char (ASCII representation) and print

        double castDouble = intNum;
        System.out.printf("Implicit cast (int -> double): %s\n", castDouble);

        int castInt = (int) doubleNum;
        System.out.printf("Explicit cast (double -> int): %s\n", castInt);

        char castChar = (char) intNum;
        System.out.printf("Casting int to char (ASCII): %s\n", castChar);

        blankLine();
    }


    static void inputChar(Scanner scannerObject) { // 5. Prompt the user to enter a character
        //    - Store the character
        //    - Convert the character to its ASCII value (int) and print

        System.out.print("Enter a character: ");
        char character = scannerObject.next().charAt(0);

        int castInt = (int) character;
        System.out.printf("ASCII value of '%s' is: %s\n", character, castInt);

        blankLine();
    }


    static void stringComparison(Scanner scannerObject, String storedString) { // 6. Demonstrate String vs. new String()
        //    - Create a String literal and assign it to two variables
        //    - Create another String using new String()
        //    - Compare the first two strings using == (reference check)
        //    - Compare one literal with the new String() object using ==
        //    - Compare the content of both strings using .equals()
        //    - Print the results

        System.out.println("String Comparisons:");

        String str1 = storedString;
        String str2 = storedString;
        String str3 = new String(storedString);

        System.out.printf("str1 == str2: %b\n", str1 == str2);
        System.out.printf("str1 == str3: %b\n", str1 == str3);
        System.out.printf("str1.equals(str3): %b\n", str1.equals(str3));
    }


    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in); // Create a Scanner object for user input

        roundingLoop();

        double storedDouble = inputRounding(scannerObject);

        int storedInteger = inputInteger(scannerObject);
        String storedString = inputString(scannerObject);
        printIntAndString(storedInteger, storedString);

        casting(storedInteger, storedDouble);

        inputChar(scannerObject);
        
        stringComparison(scannerObject, storedString);

        scannerObject.close(); // Close the Scanner object
    }
}
