package dfs;

import java.util.ArrayList;
import java.util.List;

public class nQueens {

    public List<List<String>> solveNQueens(int n) {
        // init result
        final List<List<String>> result = new ArrayList<>();
        dfs(buildBoard(n), 0, result);
        return result;
    }

    private char[][] buildBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

    public List<String> createResultFromBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int col = 0; col < board.length; col++) {
                stringBuilder.append(board[row][col]);
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    public void dfs(char[][] board, int row, List<List<String>> result) {
        // termination condition
        int n = board.length;
        if (row == n) { // reaches bottom
            // put board into result
            result.add(createResultFromBoard(board));
            return;
        }
        // column as choices
        for (int col = 0; col < n; col++) {
            // 1. if it's not valid, then choose next column
            if (!isValid(board, row, col)) {
                continue;
            }
            // make a choice (put the queen here since it's valid)
            board[row][col] = 'Q';
            // 2. dfs go deeper with row + 1
            dfs(board, row + 1, result);
            // 3. cancel the choice
            board[row][col] = '.';
        }
    }


    boolean isValid(char[][] board, int currentRow, int currentCol) {
        final int n = board.length;
        // check currentCol, no other Q in the same currentCol
        for (int row = 0; row < n; row++) {
            if (board[row][currentCol] == 'Q') {
                return false;
            }
        }
        // 因為是從row的上到下放置，所以只需要檢查上方，因為下方還沒放置，輪到下方時也會檢查上方
        // 先檢查斜左上 (r-1, c-1)
        for (int row = currentRow - 1, col = currentCol - 1; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 'Q') {
                return false;
            }
        }
        // 檢查斜右上 (r-1, c+1)
        for (int row = currentRow - 1, col = currentCol + 1; row >= 0 && col < n; row--, col++) {
            if (board[row][col] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
