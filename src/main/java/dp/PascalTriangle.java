package dp;

import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> sol(int numRows) {
        int[][] dp = new int[numRows][numRows];
        List<List<Integer>> result = new LinkedList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> rowResult = new LinkedList<>();
            for (int col = 0; col <= row; col++) {
                if (row == 0 || col == 0 || row == col) {
                    dp[row][col] = 1;
                    rowResult.add(1);
                } else {
                    dp[row][col] = dp[row-1][col-1] + dp[row-1][col];
                    rowResult.add(dp[row][col]);
                }
            }
            result.add(rowResult);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle().sol(1));
    }
}
