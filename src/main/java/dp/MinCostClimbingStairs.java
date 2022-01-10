package dp;

public class MinCostClimbingStairs {
    int[] dp;
    public int topDown(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        return minCostToStair(cost, n);
    }

    private int minCostToStair(int[] cost, int i) {
        if (i < 0) {
            return 0;
        }
        if (i == 0 || i == 1) {
            return cost[i];
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        dp[i] = cost[i] + Math.min(minCostToStair(cost, i - 1), minCostToStair(cost, i - 2));
        return dp[i];
    }

    public int bottomUp(int[] cost) {
        final int n = cost.length;
        int[] dp2 = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                dp2[i] = cost[i];
            } else {
                dp2[i] = cost[i] + Math.min(dp2[i - 1], dp2[i - 2]);
            }
        }
        return Math.min(dp2[n - 1], dp2[n - 2]);
    }
}
