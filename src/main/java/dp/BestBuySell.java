package dp;

public class BestBuySell {
    // 第i天 = 1~n
    // 交易上限 = k
    // 是否持有 = [0, 1]

    // 2 cases from 4 choices
    // dp[i][k][0] = max(dp[i-1][k][1] + prices[i], dp[i-1][k][0])
    // dp[i][k][1] = max(dp[i-1][k-1][0] - prices[i], dp[i-1][k][1])

    // base case
    // dp[0][...][0] = 0;
    // dp[0][...][1] = Integer.MIN_VALUE;
    // dp[...][0][0] = 0;
    // dp[...][0][1] = Integer.MIN_VALUE;

    public int best1(int[] prices) {
        // have only 1 transaction -> k = 1
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        // base case
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;

        for (int day = 1; day <= n; day++) {
            dp[day][0] = Math.max(dp[day - 1][0], dp[day-1][1] + prices[day]);
            dp[day][1] = Math.max(dp[day - 1][1], -prices[day]); //
        }
        // TODO
        return -1;
    }
}
