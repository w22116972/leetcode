package dfs;

public class DetectCyclesIn2DGrid {

    boolean[][] visitedMatrix = new boolean[500][500];

    public boolean containsCycle(char[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (!isVisited(row, col) && hasCycle(grid, row, col, -1, -1, grid[row][col])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(char[][] grid, int row, int col, int prevRow, int prevCol, char startChar) {
        if (!isInGrid(grid, row, col) || grid[row][col] != startChar) {
            return false;
        } else if (isVisited(row, col)) {
            return true;
        }
        visitedMatrix[row][col] = true;
        if (row + 1 != prevRow && hasCycle(grid, row + 1, col, row, col, startChar)) {
            return true;
        }
        if (row - 1 != prevRow && hasCycle(grid, row - 1, col, row, col, startChar)) {
            return true;
        }
        if (col + 1 != prevCol && hasCycle(grid, row, col + 1, row, col, startChar)) {
            return true;
        }
        if (col - 1 != prevCol && hasCycle(grid, row, col - 1, row, col, startChar)) {
            return true;
        }
        return false;
    }

    private boolean isInGrid(char[][] grid, int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
    }

    private boolean isVisited(int row, int col) {
        return visitedMatrix[row][col];
    }
}


