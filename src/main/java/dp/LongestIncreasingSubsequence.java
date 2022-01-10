package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        final int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
//        dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            for (int choiceStartIndex = i + 1; choiceStartIndex < n; choiceStartIndex++) {
                if (nums[i] < nums[choiceStartIndex]) {
                    dp[i] = Math.max(dp[i], 1 + dp[choiceStartIndex]);
                }
            }
        }
        // find the biggest length in dp
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(dp[i]);
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
