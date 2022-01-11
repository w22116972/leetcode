package dp;

public class UniqueBinaryTree {
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    count += (1 * dp[i-1]);
                } else {
                    count += dp[j - 1] * dp[i - j];
                }
            }
            dp[i] = count;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinaryTree().numTrees(1));
    }
}
