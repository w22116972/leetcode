package dp;

public class MaximumSubarray {
    public int bottomUp(int[] nums) {
        final int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        // base case
        dp[0] = nums[0];
        for (int i = 1; i < n; i ++) {
            // 1. 自己作為子陣列的起點
            // 2. 與前面的子陣列結合成為新的子陣列
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        // find max of all dp[i]
        int maxSumOfSubarray = Integer.MIN_VALUE;
        for (int i: dp) {
            maxSumOfSubarray = Math.max(maxSumOfSubarray, i);
        }
        return maxSumOfSubarray;
    }
}
