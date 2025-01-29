import java.util.Scanner; // import Scanner class

public class CountDown {
    
    static void countDownFromInt() {
        while (true) { // loops until a valid input is entered and the for loop runs
            try { // ensures an integer is entered
                Scanner myScanner = new Scanner(System.in); // create scanner object
    
                System.out.print("Enter an integer to count down from: "); // prompt
                int number = myScanner.nextInt(); // store the inputted integer
    
                for (int num = number; num > 0; num--) { // loop that counts down from number, stops at 1
                    System.out.println(num);
                }
    
                myScanner.close(); // prevents a data leak

                break;
    
            } catch (Exception e) { // if anything other than an integer is entered
                System.out.println("That is not an integer, try again");
            }
        }
    }
    public static void main(String[] args) {
        countDownFromInt();
    }
}