// necessary imports go here
import java.util.Arrays;
import java.util.Scanner;

public class ArraySearch {

    public static int linearSearch(int[] array, int targetNum) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == targetNum) {
                return i;
            }
        }

        return -1;
    }

    public static void lineBreak() {
        System.out.println("");
    }

    public static void main(String[] args) {
        // TODO: Get array size from user using Scanner
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array as a positive integer: ");
        int arraySize = scanner.nextInt();

        // TODO: Validate input to ensure a positive integer for array size
        while (arraySize <= 0) {
            System.out.print(arraySize + " is not an integer, please enter a positive integer: ");
            arraySize = scanner.nextInt();
        }

        // TODO: Create an array of the specified size and fill with random numbers
        int[] intArray = new int[arraySize];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int)(Math.random() * 1000) + 1;
        }

        // TODO: Get target number from user using Scanner
        System.out.print("Enter the target number as a positive integer: ");
        int targetNum = scanner.nextInt();

        // TODO: Validate input to ensure a positive integer for the target number if found, -1 if not
        while (targetNum <= 0) {
            System.out.print(targetNum + " is not an integer, please enter a positive integer: ");
            targetNum = scanner.nextInt();
        }

        scanner.close();

        lineBreak();

        // Linear Search
        System.out.println("Starting linear search...");
        long linearStartTime = System.nanoTime();

        // TODO: Implement linear search to find the index of the target number
        int linearIndex = linearSearch(intArray, targetNum);

        if (linearIndex >= 0) {
            System.out.println("The number " + targetNum + " exists at index " + linearIndex + ".");
        } else {
            System.out.println("The number " + targetNum + " does not exist in the array and " + linearIndex + " was returned.");
        }

        long linearEndTime = System.nanoTime();
        System.out.println("Linear search took " + (linearEndTime - linearStartTime) + " nanoseconds.");

        lineBreak();

        // Sort the array using built-in method of the Arrays class
        System.out.println("Sorting the array...");

        // TODO: Sort the array as specified above
        Arrays.sort(intArray);

        lineBreak();

        // Binary Search
        System.out.println("Starting binary search...");
        long binaryStartTime = System.nanoTime();

        // TODO: Implement binary search to find the index of the target number if found, -1 if not
        int binaryIndex = Arrays.binarySearch(intArray, targetNum);

        long binaryEndTime = System.nanoTime();
        System.out.println("Binary search took " + (binaryEndTime - binaryStartTime) + " nanoseconds.");

        // TODO: Display the result of the binary search (index or not found)
        if (binaryIndex >= 0) {
            System.out.println("The number " + targetNum + " exists at index " + binaryIndex + ".");
        } else {
            System.out.println("The number " + targetNum + " does not exist in the array and " + binaryIndex + " was returned.");
        }

        lineBreak();

        // TODO: Display results specified in Display Output section
        System.out.println("The linear search method returned index " + linearIndex + " when it searched for the integer " + targetNum + ".");
        System.out.println("The binary search method returned index " + binaryIndex + " when it searched for the integer " + targetNum + ".");
        
        lineBreak();

        long linearTime = linearEndTime - linearStartTime;
        long binaryTime = binaryEndTime - binaryStartTime;

        System.out.println("Linear search took " + linearTime + " nanoseconds.");
        System.out.println("Binary search took " + binaryTime + " nanoseconds.");

        lineBreak();

        if (binaryTime < linearTime) {
            System.out.println("The binary search method was faster than the linearSearch() method by " + (linearTime - binaryTime) + " nanoseconds.");
        } else if (linearTime < binaryTime) {
            System.out.println("The linear search method was faster than the linearSearch() method by " + (binaryTime - linearTime) + " nanoseconds.");
        } else {
            System.out.println("The two search methods took the same amount of time.");
        }
    }
}
