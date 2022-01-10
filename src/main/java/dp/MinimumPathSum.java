package dp;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class MinimumPathSum {
    int recursion(int[][] grid) {
        return recur(grid, grid.length - 1, grid[0].length - 1);
    }

    int recur(int[][] grid, int i, int j) {
        // base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        // handle out of index
        // 用 MAX_VALUE 就不會被MIN給取到
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        return Math.min(
                recur(grid, i - 1, j),
                recur(grid, i, j-1)
        ) + grid[i][j];
    }

    int[][] memo;
    int topDown(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return topDownDp(grid, m - 1, n - 1);
    }

    int topDownDp(int[][] grid, int i, int j) {
        // base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        memo[i][j] = Math.min(topDownDp(grid, i - 1, j), topDownDp(grid, i, j -1)) + grid[i][j];
        return memo[i][j];
    }

    int bottomUp(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // base case
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(
                        dp[i - 1][j],
                        dp[i][j - 1]
                ) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
