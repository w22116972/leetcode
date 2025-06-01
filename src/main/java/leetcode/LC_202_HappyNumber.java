package leetcode;

public class LC_202_HappyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while (true) {
            slow = computeNum(slow);
            fast = computeNum(computeNum(fast));
            if (fast == 1) {
                return true;
            } else if (fast == slow) {  // detect cycle
                return false;
            }
        }
    }

    private int computeNum(int n) {
        int result = 0;
        while (n > 0) {
            result += Math.pow((n % 10), 2);
            n /= 10;
        }
        return result;
    }
}
