import java.util.Random; // Unused
import java.util.Scanner;

public class MegaMillions {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random(); // Unused
    static double balance;
    static double totalWinnings = 0;
    static double totalSpent = 0;

    // variables used by playRound() and related methods
    static int[] ticketNumbers = new int[5];
    static int ticketMegaBall;
    static int[] winningNumbers = new int[5];
    static int winningMegaBall;
    static int megaplier;
    static double prize;

    // for formatting output
    static String thinLine = "--------------------------------------";
    static String thickLine = "======================================";

    static String buffer; // buffer to catch \n from inputs

    public static void main(String[] args) {
        initializeGame();
        
        // TODO: Run the game loop until the player can no longer play
        runGame();

        printGameSummary();

        scanner.close();
    }

    // TODO: Initialize the game (set balance, print welcome message)
        // Returns nothing
        // Parameters: none
        // Player starts with $50, see image in intstructions for what to print
    
    public static void initializeGame() {
        balance = 50.0;

        System.out.println("      WELCOME TO MEGA MILLIONS!");
        System.out.println(thickLine);
        System.out.printf("You start with $%.2f.%n", balance);

        lineBreak();
    }

    // TODO: Run the game loop (handle multiple rounds of play)
    public static void runGame() {
        boolean isGamblingAddict = true;

        while (isGamblingAddict) {
            isGamblingAddict = playRound();
        }
    }

    // METHODS CREATED TO MAKE playRound() easier to write
    public static int randInt(int min, int bound) { // int bound = number of possible integers
        return (int) (Math.random() * bound) + min;
    }

    public static void lineBreak() {
        System.out.println();
    }

    public static void roundHeader() { // Prints the Current Balance
        // round header
        System.out.println(thinLine);
        System.out.printf("Current Balance: %.2f%n", balance);
        System.out.println(thinLine);

        // spend $2 to buy ticket
        updateBalance(-2);

    }

    public static void getTicket() { // Handles all code related to creating the player's ticket
        // Ask player if they want to quick pick, validate with while loop
        String doQuickPlay;

        System.out.print("Do you want Quick Pick? (yes/no): ");
        doQuickPlay = scanner.next().toLowerCase();
        buffer = scanner.nextLine();

        while (doQuickPlay.charAt(0) != 'y' && doQuickPlay.charAt(0) != 'n') {
            System.out.print("Invalid Input; Do you want Quick Pick? (yes/no): ");
            doQuickPlay = scanner.next().toLowerCase();
            buffer = scanner.nextLine();
        }

        if (doQuickPlay.charAt(0) == 'y') {
            // fill ticketNumbers using generateNumbers()
            ticketNumbers = generateNumbers();

            // store random number between 1-25 in ticketMegaBall
            ticketMegaBall = randInt(1, 25);

            System.out.println("Your Quick Pick: " + java.util.Arrays.toString(ticketNumbers) + " Mega Ball: " + ticketMegaBall);
        } else {
            // fill ticketNumbers with 5 integer inputs between 1 and 70 using getValidNumbers(1, 70)
            // MUST REQUIRE UNIQUE NUMBERS
            int inputNum;

            System.out.println(thinLine);
            System.out.println("Building Ticket...");

            for (int i = 0; i < ticketNumbers.length; i++) {
                inputNum = getValidNumber("Number " + (i + 1) + " of 5", 1, 70);

                while (contains(ticketNumbers, inputNum)) {
                    System.out.println("Invalid Input! Each number must be unique!");
                    inputNum = getValidNumber("Number " + (i + 1) + " of 5", 1, 70);
                }

                ticketNumbers[i] = inputNum;
            }

            // get ticketMegaBall
            ticketMegaBall = getValidNumber("Mega Ball", 1, 25);
            System.out.println(thinLine);
        }
    }

    public static void getMegaplier() { // Handles code related to the megaplier
        String buyMegaplier;
        
        // set megaplier to 1 by default
        megaplier = 1;

        // see if player wants to/can get megaplier
        if (balance >= 1) { // Can the player afford a megaplier?
            System.out.print("Do you want to add Megaplier for $1? (yes/no): ");
            buyMegaplier = scanner.next().toLowerCase();
            buffer = scanner.nextLine();
    
            while (buyMegaplier.charAt(0) != 'y' && buyMegaplier.charAt(0) != 'n') {
                System.out.print("Invalid Input; Do you want to add Megaplier for $1? (yes/no): ");
                buyMegaplier = scanner.next().toLowerCase();
                buffer = scanner.nextLine();
            }

            if (buyMegaplier.charAt(0) == 'y') {
                megaplier = getRandomMegaplier();
                updateBalance(-1);
            }
        }
    }

    public static void getWinningNumbers() { // Handles all code related to generating the winning numbers and outputting the megaplier if 
        // Generate winningNumbers and winningMegaBall
        winningNumbers = generateNumbers();
        winningMegaBall = randInt(1, 25);

        // Winning Numbers Output
        System.out.println(thickLine);
        System.out.println("         WINNING NUMBERS:");
        System.out.println(thickLine);
        
        System.out.println(java.util.Arrays.toString(winningNumbers) + " Mega Ball: " + winningMegaBall);

        if (megaplier != 1) {
            System.out.println("Megaplier Drawn: x" + megaplier);
        }

        System.out.println(thickLine);
    }

    public static void postRoundOutput() { // Print prize and new balance
        System.out.printf("You won: $%.2f%n", prize);
        System.out.printf("New Balance: $%.2f%n", balance);
    }

    // TODO: Play one round (handle number selection, ticket purchase, drawing numbers, checking results, updating balance)
        // Returns boolean (would you like to play again? prompt at end of round)
        // Parameters: none
    
    public static boolean playRound() {
        roundHeader();
        getTicket();
        getMegaplier();
        lineBreak();
        getWinningNumbers();
        lineBreak();

        // calculate prize using getPrize(), countMatches(), and megaplier (if applicable)
        prize = getPrize(countMatches(ticketNumbers, winningNumbers), (ticketMegaBall == winningMegaBall));
        updateBalance(prize);

        postRoundOutput();
        lineBreak();

        // Se if the player CAN play again
        if (balance < 2) {
            return false;
        }

        // See if player wants to play again; validate with while loop
        String playAgain;

        System.out.print("Do you want to play again? (yes/no): ");
        playAgain = scanner.next().toLowerCase();

        while (playAgain.charAt(0) != 'y' && playAgain.charAt(0) != 'n') {
            System.out.print("Invalid Input; Do you want to play again? (yes/no): ");
            playAgain = scanner.next().toLowerCase();
        }

        lineBreak();

        if (playAgain.charAt(0) == 'y') {
            return true;
        } else {
            return false;
        }
    }

    // TODO: Update balance after ticket purchase and winnings
        // Returns nothing
        // Parameters:
        //   - String event (either "gain" or "spend")
        //   - double amount (amount added to/subtracted from balance)
        // should update balance (always), totalWinnings (when gaining money), and totalSpend (when spending money)

    public static void updateBalance(double amount) {
        if (amount >= 0) {
            balance += Math.abs(amount);
            totalWinnings += Math.abs(amount); 
        } else {
            balance -= Math.abs(amount);
            totalSpent += Math.abs(amount);
        }
    }

    // TODO: Print game summary (total spent, total winnings, final balance)
        // Returns nothing
        // Parameters: none
        // See instructions for details on output
    
    public static void printGameSummary() {
        System.out.println(thickLine);
        System.out.println("              GAME OVER");
        System.out.println(thickLine);
        
        System.out.printf("Total Spent: %.2f%n", totalSpent);
        System.out.printf("Total Winnings: %.2f%n", totalWinnings);
        System.out.printf("Final Balance: %.2f%n", balance);
        System.out.println(thickLine);
    }

    // TODO: Generate an array of 5 unique random numbers (1-70)
        // Returns int[]
        // Parameters: None
        // Each number must be unique, use contains() to verify
    
    public static int[] generateNumbers() {
        int[] rolledNumbers = new int[5];
        int generatedNumber;

        for (int i = 0; i < rolledNumbers.length; i++) {
            do {
                generatedNumber = randInt(1, 70);
            } while (contains(rolledNumbers, generatedNumber));

            rolledNumbers[i] = generatedNumber;
        }

        return rolledNumbers;
    }

    // TODO: Get a valid number input from the user within a given range
        // Returns int
        // Parameters:
        //   - int min (minimum number)
        //   - int max (maximum number)
        // Use do-while loop to get integer input within range min-max
    
    public static int getValidNumber(String context, int min, int max) {
        int number;

        do {
            System.out.printf("%s: Enter a number between %d and %d: ", context, min, max);
            number = scanner.nextInt();
        } while (min >= number || number >= max);

        return number;
    }

    // TODO: Check if an array contains a specific number
        // Returns boolean
        // Parameters: int[] array (which gets checked), int targetNum (which is checked for)
    
    public static boolean contains(int[] array, int targetNum) {
        for (int el : array) {
            if (el == targetNum) {
                return true;
            }
        }

        return false;
    }

    // TODO: Count matching numbers between user and winning numbers
        // Returns integer
        // Parameters:
        //   - int[] ticketNumbers (array of numbers player drew)
        //   - int[] winningNumbers (array of numbers that elements of ticketNumbers are checked against)
        // use contains()
    
    public static int countMatches(int[] ticketNumbers, int[] winningNumbers) {
        int matches = 0;

        for (int number : ticketNumbers) {
            if (contains(winningNumbers, number)) {
                matches++;
            }
        }

        return matches;
    }

    // TODO: Determine the prize amount based on matches
        // Returns double
        // Parameters:
        //   - int matchCount (the number of matches supplied by countMatches())
        //   - boolean megaBallMatch (if player drew the right megaball number)
    
    public static double getPrize(int matchCount, boolean  megaBallMatch) {
        double prizeTemp = 0;

        switch (matchCount) {
            case 5 -> {
                if (megaBallMatch) {
                    prizeTemp = 100000000; // jackpot
                } else {
                    prizeTemp = 1000000;
                }
            }
            case 4 -> {
                if (megaBallMatch) {
                    prizeTemp = 10000;
                } else {
                    prizeTemp = 500;
                }
            }
            case 3 -> {
                if (megaBallMatch) {
                    prizeTemp = 200;
                } else {
                    prizeTemp = 10;
                }
            }
            case 2 -> {
                if (megaBallMatch) {
                    prizeTemp = 10;
                } else {
                    prizeTemp = 0;
                }
            }
            case 1 -> {
                if (megaBallMatch) {
                    prizeTemp = 4;
                } else {
                    prizeTemp = 0;
                }
            }
            case 0 -> {
                if (megaBallMatch) {
                    prizeTemp = 2;
                } else {
                    prizeTemp = 0;
                }
            }
            default -> {
                prizeTemp = 0;
            }
        }

        if (prizeTemp < 100000000) {
            prizeTemp *= megaplier;
        }

        return prizeTemp;
    }

    // TODO: Get a random Megaplier value (2x, 3x, 4x, or 5x)
        // Returns int
        // Parameters: none

    public static int getRandomMegaplier() {
        int rolledMegaplier = randInt(2, 4); // range of 2-5

        return rolledMegaplier;
    }
}
