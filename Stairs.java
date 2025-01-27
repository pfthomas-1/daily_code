import java.util.Scanner;

class Stairs {
    public static void main(String[] args) {
        // Initialize Scanner
        Scanner scanner = new Scanner(System.in);
        
        // Get Character from user
        System.out.print("Enter a Character: ");
        char ch = scanner.next().charAt(0);
        
        // Convert char to String so .repeat is useable
        String symbol = Character.toString(ch);
        
        // Get Stair size from user
        System.out.print("Enter an Integer: ");
        int steps = scanner.nextInt();
        
        // Variables to store integers for .repeat()
        int spaceLength = steps;
        int stepLength = 0;
        
        // Generate the Staircase
        for (int i = 0; i < steps; i++) {
            spaceLength--;
            stepLength++;
            System.out.println(((" ").repeat(spaceLength)) + (symbol.repeat(stepLength)));
        }
    }
}
