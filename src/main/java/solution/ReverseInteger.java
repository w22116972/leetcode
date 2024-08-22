package solution;

import org.junit.jupiter.api.Assertions;


public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;

        boolean isPositive = x >= 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check overflow before adding the next digit
            if (isPositive && result > (Integer.MAX_VALUE - digit) / 10) {
                // Overflow positive number if result * 10 + digit > Integer.MAX_VALUE
                // To avoid overflow, we can check if result > (Integer.MAX_VALUE - digit) / 10
                return 0;
            } else if (!isPositive && result < (Integer.MIN_VALUE - digit) / 10) {
                // Overflow negative number if result * 10 + digit < Integer.MIN_VALUE
                // To avoid overflow, we can check if result < (Integer.MIN_VALUE - digit) / 10
                return 0;
            }

            result = result * 10 + digit;
        }
        return result;
    }

    public void test() {
        Assertions.assertEquals(321, reverse(123), "test positive number");
        Assertions.assertEquals(-321, reverse(-123), "test negative number");
        Assertions.assertEquals(21, reverse(120), "test number with leading 0s");
        Assertions.assertEquals(0, reverse(0), "test 0");
        Assertions.assertEquals(0, reverse(1534236469), "test overflow on positive number");
        Assertions.assertEquals(0, reverse(-1534236469), "test overflow on negative number");
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        reverseInteger.test();
    }
}
