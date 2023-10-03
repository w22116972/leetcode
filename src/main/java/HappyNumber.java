import java.util.HashSet;

public class HappyNumber {

    public boolean isHappy(int n) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        while (true) {
            int sum = 0;
            for (char c: String.valueOf(n).toCharArray()) {
                sum += (int) Math.pow(Character.getNumericValue(c), 2);
            }
            if (seenNumbers.contains(sum)) {
                return false;
            } else if (sum == 1) {
                return true;
            } else {
                seenNumbers.add(sum);
                n = sum;
            }
        }
    }


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
