package backtracking;

public class WordSearch {

    private int rowSize;
    private int columnSize;
    boolean[][] isVisited;

    public boolean exist(char[][] board, String word) {

        rowSize = board.length;
        columnSize = board[0].length;
        isVisited = new boolean[rowSize][columnSize];
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < columnSize; col++) {
                if (backtrack(row, col, 0, word, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, int i, String word, char[][] board) {
        if (i == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= rowSize || col > columnSize ||
            isVisited[row][col] || board[row][col] != word.charAt(i)) {
            return false;
        }
        isVisited[row][col] = true;
        boolean result = backtrack(row + 1, col, i + 1, word, board) ||
                backtrack(row - 1, col, i + 1, word, board) ||
                backtrack(row, col + 1, i + 1, word, board) ||
                backtrack(row, col - 1, i + 1, word, board);
        isVisited[row][col] = false;
        return result;
    }

    public static void main(String[] args) {

    }
}
