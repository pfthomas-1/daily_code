// BEGIN

class ThreeIsNotTheMagicNumber {
    public static void main(String[] args) {
        // Loop through numbers 1 to 20
        for (int i = 0; i <= 20; i++) { // FOR each number from 1 to 20 DO
            if (i % 3 == 0) { // IF number is divisible by 3 THEN
                continue; // Skip this iteration
            } else {
                System.out.println(i); // Print the number
            }
        }
    }
    // END
}