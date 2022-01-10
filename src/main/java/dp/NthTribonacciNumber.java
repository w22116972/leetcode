package dp;

public class NthTribonacciNumber {
    public int tribonacci(int n) {
        int[] dp = new int[n];
        return recur(n, dp);
    }

    public int recur(int n, int[] dp) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            if (dp[n-1] == 0) {
                dp[n-1] = recur(n-1, dp) + recur(n-2, dp) + recur(n-3, dp);
            }
            return dp[n-1];
        }
    }
}
