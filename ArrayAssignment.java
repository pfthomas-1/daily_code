// Import Statements
import java.util.Scanner;

public class ArrayAssignment {

    // Linebreak method for readability
    public static void linebreak() {
        System.out.println();
    }

    // Task 1: Declare an Array
    public static void task1() {
        System.out.println("Task 1: Declare an Array");

        // Declare an integer array named numbers with a size of 5.
        int[] numbers;
        numbers = new int[5];

        // Print all elements of the array to show their default values.
        System.out.println("Element 0 is " + numbers[0]);
        System.out.println("Element 1 is " + numbers[1]);
        System.out.println("Element 2 is " + numbers[2]);
        System.out.println("Element 3 is " + numbers[3]);
        System.out.println("Element 4 is " + numbers[4]);
        
        linebreak();
    }

    // Task 2: Declare an Array and fill the values in multiple lines

    public static void task2() {
        System.out.println("Task 2: Declare an Array and fill the values in multiple lines");

        // Declare an integer array named numbers with a size of 5.
        int[] numbers;
        numbers = new int[5];

        // Assign the values 21, 12, 22, 11, 2 to the array using separate assignment statements.
        numbers[0] = 21;
        numbers[1] = 12;
        numbers[2] = 22;
        numbers[3] = 11;
        numbers[4] = 2;

        // Print the complete array.
        System.out.println("Element 0 is " + numbers[0]);
        System.out.println("Element 1 is " + numbers[1]);
        System.out.println("Element 2 is " + numbers[2]);
        System.out.println("Element 3 is " + numbers[3]);
        System.out.println("Element 4 is " + numbers[4]);
        
        linebreak();
    }

    // Task 3: Declare an Array and fill the values in one line

    public static void task3() {
        System.out.println("Task 3: Declare an Array and fill the values in one line");

        // Declare and initialize an integer array named numbers with a size of 5 in one line.
        // Assign the values 21, 12, 22, 11, 2 directly.
        int[] numbers = {21, 12, 22, 11, 2};

        // Print the complete array.
        System.out.println("Element 0 is " + numbers[0]);
        System.out.println("Element 1 is " + numbers[1]);
        System.out.println("Element 2 is " + numbers[2]);
        System.out.println("Element 3 is " + numbers[3]);
        System.out.println("Element 4 is " + numbers[4]);

        linebreak();
    }

    // Task 4: Declare an Array and fill the values using a for loop
    public static void task4() {
        System.out.println("Task 4: Declare an Array and fill the values using a for loop");

        // Declare an integer array named numbers with a size of 5.
        int[] numbers = new int[5];

        // Use a for loop to populate the array starting with 3, then fill it with increasing multiples of 3.
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (i + 1) * 3;
        }

        // Print the complete array.
        System.out.println("Element 0 is " + numbers[0]);
        System.out.println("Element 1 is " + numbers[1]);
        System.out.println("Element 2 is " + numbers[2]);
        System.out.println("Element 3 is " + numbers[3]);
        System.out.println("Element 4 is " + numbers[4]);

        linebreak();
    }

    // Task 5: Declare an Array and fill the values using a for loop, char edition
    public static void task5() {
        System.out.println("Task 5: Declare an Array and fill the values using a for loop, char edition");

        // Declare a char array named charArray with a size of 5.
        char[] charArray = new char[5];

        // Set the first element to 'A'.
        charArray[0] = 'A';

        // Use a for loop to fill the array with the next respective letters, increasing by 2 each time. You must use math, you cannot hard code.
        for (int i = 1; i < charArray.length; i++) {
            charArray[i] = (char)(charArray[i-1] + 2);
        }

        // Print the complete array.
        System.out.println("Element 0 is " + charArray[0]);
        System.out.println("Element 1 is " + charArray[1]);
        System.out.println("Element 2 is " + charArray[2]);
        System.out.println("Element 3 is " + charArray[3]);
        System.out.println("Element 4 is " + charArray[4]);

        linebreak();
    }

    // Task 6: User-Defined Array with Random Values
    public static void task6() {
        System.out.println("Task 6: User-Defined Array with Random Values");

        Scanner scannerObject = new Scanner(System.in);

        // Prompt the user to enter the size of the array.
        System.out.print("Enter an integer to indicate the size of the array: ");
        int arrayLength = scannerObject.nextInt();
        
        scannerObject.close();

        // Create an array of that size.
        int[] userArray = new int[arrayLength];
        
        // Fill it with random numbers between 1 and 100 using a for loop.
        for (int i = 0; i < userArray.length; i++) {
            userArray[i] = 1 + (int)(Math.random() * 100);
        }

        // Print the array values.
        for (int i = 0; i < userArray.length; i++) {
            System.out.println("Element " + i + " is " + userArray[i]);
        }

        linebreak();
    }

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
    }
}
