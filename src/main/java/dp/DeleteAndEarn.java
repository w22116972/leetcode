package dp;

public class DeleteAndEarn {

    // iterative
    public int greedy(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[10002]; // TODO
        // To avoid over iterate dp
        int maxNumber = 0;
        for (int i: nums) {
            dp[i] += i;
            maxNumber = Math.max(i, maxNumber);
        }

        for (int i = 2; i <= maxNumber; i++) {
            dp[i] = Math.max(
                    dp[i-1], // not take
                    dp[i] + dp[i-2] // take
            );
        }
        return dp[maxNumber];
    }
}
