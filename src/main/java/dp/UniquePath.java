package dp;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        return getNumberOfWaysAt(m - 1, n - 1);
    }
    private int getNumberOfWaysAt(int row, int col) {
        if (row == 0 && col == 0) {
            return 1;
        } else if (row == 1 && col == 0) {
            return 1;
        } else if (row == 0 && col == 1) {
            return 1;
        } else if (row < 0 || col < 0) {
            return 0;
        }
        return getNumberOfWaysAt(row - 1, col) + getNumberOfWaysAt(row, col - 1);
    }

    int memo[][];

    public int topDown(int m, int n) {
        memo = new int[m][n];
        return topDownDp(m - 1, n - 1);
    }

    public int topDownDp(int i, int j) {
        if (i == 0 && j == 0) {
            return 1;
        } else if (i == 1 && j == 0) {
            return 1;
        } else if (i == 0 && j == 1) {
            return 1;
        } else if (i < 0 || j < 0) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        memo[i][j] = topDownDp(i - 1, j) + topDownDp(i, j - 1);
        return memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePath().uniquePaths(3, 2));
        System.out.println(new UniquePath().uniquePaths(3, 7));
    }
}
