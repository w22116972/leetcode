package solution;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {

    //
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rowLength = board.length;
        int colLength = board[0].length;
        boolean[][] visitedCells = new boolean[rowLength][colLength];

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (!visitedCells[row][col] && board[row][col] == 'O') {
                    List<Cell> islandCells = new ArrayList<>();
                    boolean isIsland = markSurroundedRegionDFS(board, row, col, visitedCells, islandCells);
                    // If the region is surrounded by 'X', mark it as 'X'
                    if (isIsland) {
                        for (Cell cell : islandCells) {
                            board[cell.row][cell.col] = 'X';
                        }
                    }
                }
            }
        }
    }

    static class Cell {
        int row;
        int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private boolean isCellInGrid(char[][] board, int row, int col) {
        return row >= 0 && col >= 0 && row < board.length && col < board[0].length;
    }

    private boolean markSurroundedRegionDFS(char[][] board, int row, int col, boolean[][] visitedCells, List<Cell> islandCells) {
        if (!isCellInGrid(board, row, col)) {
            return false;
        } else if (visitedCells[row][col] || board[row][col] == 'X') {
            return true;
        }

        visitedCells[row][col] = true;
        islandCells.add(new Cell(row, col));

        boolean isIsland = true;

        isIsland &= markSurroundedRegionDFS(board, row + 1, col, visitedCells, islandCells);
        isIsland &= markSurroundedRegionDFS(board, row - 1, col, visitedCells, islandCells);
        isIsland &= markSurroundedRegionDFS(board, row, col + 1, visitedCells, islandCells);
        isIsland &= markSurroundedRegionDFS(board, row, col - 1, visitedCells, islandCells);

        return isIsland;
    }
}
