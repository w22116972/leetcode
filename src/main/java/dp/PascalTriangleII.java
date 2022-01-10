package dp;

import java.util.LinkedList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        List<Integer> result = new LinkedList<>();
        for (int row = 0; row <= rowIndex; row++) {
            for (int col = 0; col <= row; col++) {
                if (row == 0 || col == 0 || row == col) {
                    dp[row][col] = 1;
                } else {
                    dp[row][col] = dp[row-1][col-1] + dp[row-1][col];
                }
            }
        }
        for (int i = 0; i <= rowIndex; i++) {
            result.add(dp[rowIndex][i]);
        }
        return result;
    }

    public List<Integer> optimize(int rowIndex) {
        List<Integer> dp = new LinkedList<>();
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangleII().getRow(3));
        System.out.println(new PascalTriangleII().getRow(0));
        System.out.println(new PascalTriangleII().getRow(1));
    }
}
