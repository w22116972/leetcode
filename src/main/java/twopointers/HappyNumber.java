package twopointers;

public class HappyNumber {


    public static boolean sol(int num) {
        int fast = num;
        int slow = num;
        do {
            fast = getSquareSum(getSquareSum(fast));
            slow = getSquareSum(slow);
        } while (slow != fast);
        return slow == 1;
    }

    public static int getSquareSum(int num) {
        int sum = 0;
        int digit;
        while (num > 0) {
            digit = num % 10;
            sum += (int) Math.pow(digit, 2);
            num /= 10;
        }
        return sum;
    }
}
