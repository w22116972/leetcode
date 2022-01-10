package dp;

public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
//        int[] dp = new int[n+2];
        return Math.max(recur(nums, 0, n - 2), recur(nums, 1, n - 1));
    }

    private int recur(int[] house, int start, int end) {
        int n = house.length;
        int[] dp = new int[n+2];
        for (int i = end; i >= start; i--) {
            dp[i] = Math.max(house[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }
}
