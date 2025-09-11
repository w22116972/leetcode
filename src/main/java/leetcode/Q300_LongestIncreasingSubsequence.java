package leetcode;

import java.util.Arrays;

public class Q300_LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // Assume dp[i] = longest length of subseq if the end of element is nums[i]
        int[] dp  = new int[n];
        // because if we see every element as their own subseq, then they have at least 1 length
        Arrays.fill(dp, 1);
        int maxLength = 1;
        // Iterate through each element starting from the second one
        for (int i = 1; i < n; i++) {
            // Check all elements before i
            for (int j = 0; j < i; j++) {
                // If nums[i] can extend the subsequence ending at nums[j]
                // nums[i] 能否接在 nums[j] 之後形成更長的遞增子序列
                // 這樣每個 i 都會考慮所有可能的前一個元素 j，確保找到最長的遞增子序列。j 只會小於 i，因為子序列必須是原本順序。
                //簡單來說，j 是在找所有能接到 i 的前一個元素，i 則是目前要計算的目標。
                if (nums[i] > nums[j]) {
                    // Update dp[i] to the maximum length found so far
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return maxLength;
    }
}
