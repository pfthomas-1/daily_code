public class Main
{
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 5;
        int num3 = 15;
        int num4 = 20;
        
        int[] myNum = {num1, num2, num3, num4};
        
        for (int num : myNum) {
            if (num % 15 == 0) {
                System.out.println(num + " | fizzbuzz");
            } else if (num % 3 == 0) {
                System.out.println(num + " | fizz");
            } else if (num % 5 == 0) {
                System.out.println(num + " | buzz");
            } else {
                System.out.println(num + " | not fizz, not buzz");
            }
        }
    }
}
