package solution;

import java.util.*;

/**
 * There are 3 ways to mark a cell as visited: 1. Hashset 2. Boolean 2D array 3. dummy value
 * Space complexity of 3 ways: 1. O(mn) 2. O(mn) 3. O(1)
 * Here I choose the 3rd way to mark a cell as visited.
 */
public class NumberOfIslands {
    private static final char VISITED_CELL = '-';

    private boolean isCellVisited(char[][] grid, int row, int col) {
        return grid[row][col] == VISITED_CELL;
    }

    private boolean isCellValid(char[][] grid, int row, int col) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        return row >= 0 && col >= 0 && row < totalRows && col < totalCols;
    }

    private boolean isCellLand(char[][] grid, int row, int col) {
        return grid[row][col] == '1';
    }

    private boolean isCellWater(char[][] grid, int row, int col) {
        return grid[row][col] == '0';
    }

    // Use BFS to explore all the nodes in the same island
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int numberOfIslands = 0;
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {

                if (isCellLand(grid, row, col) && !isCellVisited(grid, row, col)) {
                    markVisitedByBFS(grid, row, col);
                    numberOfIslands += 1;
                }
            }
        }
        return numberOfIslands;
    }


    public static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void markVisitedByBFS(char[][] grid, int row, int col) {
        Queue<Cell> nextVisitCells = new LinkedList<>();
        nextVisitCells.add(new Cell(row, col));

        while (!nextVisitCells.isEmpty()) {
            final Cell cell = nextVisitCells.poll();

            if (!isCellValid(grid, cell.row, cell.col) ||
                    isCellWater(grid, cell.row, cell.col) ||
                    isCellVisited(grid, cell.row, cell.col)) {
                continue;
            }
            // mark visited cell by dummy value
            grid[row][col] = VISITED_CELL;
            // put neighbors to queue of nextVisitCells
            nextVisitCells.add(new Cell(cell.row + 1, cell.col));
            nextVisitCells.add(new Cell(cell.row - 1, cell.col));
            nextVisitCells.add(new Cell(cell.row, cell.col + 1));
            nextVisitCells.add(new Cell(cell.row, cell.col - 1));
        }
    }

    public void markVisitedByDFS(char[][] grid, int row, int col) {
        if (!isCellValid(grid, row, col) ||
                isCellWater(grid, row, col) ||
                isCellVisited(grid, row, col)) {
            return;
        }
        // mark visited cell by dummy value
        grid[row][col] = VISITED_CELL;
        // put neighbors to queue of nextVisitCells
        markVisitedByDFS(grid, row + 1, col);
        markVisitedByDFS(grid, row - 1, col);
        markVisitedByDFS(grid, row, col + 1);
        markVisitedByDFS(grid, row, col - 1);
    }
}
