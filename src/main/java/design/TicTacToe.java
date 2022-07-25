package design;

public class TicTacToe {

    private int[][] board;

    public TicTacToe(int n) {
        this.board = new int[n][n];
    }

    public int move(int row, int col, int player) {
        this.board[row][col] = player;

        if (isVerticalWin(col, player) || isHorizontalWin(row, player) || isDiagonalWin(row, col, player)) {
            return player;
        } else {
            return 0;
        }
    }

    // T = O(n)
    private boolean isVerticalWin(int col, int player) {
        for (int[] ints : board) {
            if (ints[col] != player) {
                return false;
            }
        }
        return true;
    }

    // T = O(n)
    private boolean isHorizontalWin(int row, int player) {
        for (int col = 0; col < board[0].length; col++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    // T = O(n)
    private boolean isDiagonalWin(int row, int col, int player) {
        boolean isLeftDiagonalWin = true;
        for (int d = 0; d < board.length; d++) {
            if (board[d][d] != player) {
                isLeftDiagonalWin = false;
                break;
            }
        }

        boolean isRightDiagonalWin = true;
        for (int d = 0; d < board.length; d++) {
            if (board[d][board.length - 1 - d] != player) {
                isRightDiagonalWin = false;
                break;
            }
        }

        return isLeftDiagonalWin || isRightDiagonalWin;
    }
}
