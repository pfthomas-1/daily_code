/* * * * * * * * * * * *\
 * Philip Thomas       *
 * January 30th, 2025  *
 * CSC 151 2801        *
\* * * * * * * * * * * */

import java.util.Scanner;

public class Factorial {

    static void calculateFactorial(long num) {
        long factorial = 1;

        Boolean isValid = true;

        if (num >= 0) {
            for (long i = num; i > 0; i--) {
                if ((factorial * i) < factorial) {
                    isValid = false;
                    break;
                } else {
                    factorial *= i;
                }
            }

            if (isValid){
                System.out.println(String.format("The factorial of %s is %s.", num, factorial));
            } else {
                System.err.println(String.format("The factorial of %s has overflowed.", num));
            }
        } else {
            System.err.println(String.format("%s is a negative number and has no factorial", num));
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = myScanner.nextInt();

        calculateFactorial(number);

        myScanner.close();
    }
}
