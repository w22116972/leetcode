package leetcode;

// Time Complexity = O(log n), because we are using binary search to find the number
// Space Complexity = O(1)
public class Q374_GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = guess(mid);
            if (result == 0) {
                return mid;
            } else if (result == -1) {
                right = mid - 1;
            } else if (result == 1) {
                left = mid + 1;
            }
        }
        return 0;
    }

    private int guess(int n) {
        return 0;
    }
}
