// Imports
import java.util.Scanner;

public class AllInOne {
    public static int calcSum(int num1, int num2, int num3) { // Calculate sum
        int sum = num1 + num2 + num3;

        return sum;
    }


    public static int calcMaximum(int num1, int num2, int num3) { // Find max
        int max = num1;
        if (num2 > max) {
            max = num2;
        }
        if (num3 > max) {
            max = num3;
        }
        
        return max;
    }


    public static int calcMinimum(int num1, int num2, int num3) { // Find min
        int min = num1;
        if (num2 < min) {
            min = num2;
        }
        if (num3 < min) {
            min = num3;
        }

        return min;
    }


    public static double calcAverage(int sum) { // Calculate average
        double average = sum / 3.0;

        return average;
    }


    public static boolean checkPositive(int num1, int num2, int num3) { // Check if all numbers are positive
        return (num1 > 0 && num2 > 0 && num3 > 0);
    }


    public static void printResults(int sum, int max, int min, double average, boolean allPositive, int num1, int num2, int num3) { // Print results
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Average: " + average);
        System.out.println("All numbers are positive: " + allPositive);
        System.out.printf("Formatted Output: The sum of %d, %d, and %d is %d.\n", num1, num2, num3, sum);
    }


    public static void processNumbers(int num1, int num2, int num3) {
        // Calculate sum
        int sum = calcSum(num1, num2, num3);
 
        // Find max
        int max = calcMaximum(num1, num2, num3);
 
        // Find min
        int min = calcMinimum(num1, num2, num3);
 
        // Calculate average
        double average = calcAverage(sum);
 
        // Check if all numbers are positive
        boolean allPositive = checkPositive(num1, num2, num3);
 
        // Print results
        printResults(sum, max, min, average, allPositive, num1, num2, num3);
    }


    public static void getUserInput() {
        Scanner scannerObject = new Scanner(System.in);

        System.out.print("Enter the first integer: ");

        while (!scannerObject.hasNextInt()) {            
            System.out.print("Invalid Input! please input an integer value: ");
            scannerObject.next();
        }

        int num1 = scannerObject.nextInt();

        System.out.print("Enter the second integer: ");
        scannerObject.nextLine();

        while (!scannerObject.hasNextInt()) {
            System.out.print("Invalid Input! please input an integer value: ");
            scannerObject.next();
        }

        int num2 = scannerObject.nextInt();

        System.out.print("Enter the third integer: ");
        scannerObject.nextLine();

        while (!scannerObject.hasNextInt()) {
            System.out.print("Invalid Input! please input an integer value: ");
            scannerObject.next();
        }

        int num3 = scannerObject.nextInt();
        
        processNumbers(num1, num2, num3);
    }

    
    public static void main(String[] args) {
        getUserInput();
    }
}