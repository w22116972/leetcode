package dfs;

public class NumberOfIslands {
    public int sol(char[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        int totalIslands = 0;

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (isLand(grid, row, col)) { // only if the cell is a land
                    // we have found an island
                    totalIslands++;
                    visitIslandDFS(grid, row, col);
                }
            }
        }
        return totalIslands;
    }

    private boolean isValidLocation(char[][] grid, int row, int col) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        return row >= 0 && col >= 0 && row < totalRows && col < totalCols;
    }

    private boolean isLand(char[][] grid, int row, int col) {
        return grid[row][col] == '1';
    }

    private boolean isWater(char[][] grid, int row, int col) {
        return grid[row][col] == '0';
    }

    private boolean isVisited(char[][] grid, int row, int col) {
        return grid[row][col] == '-';
    }

    private void visitIslandDFS(char[][] grid, int row, int col) {
        if (!isValidLocation(grid, row, col) || isWater(grid, row, col) || isVisited(grid, row, col)) {
            return;
        }
        grid[row][col] = '-';
        // recursively dfs
        visitIslandDFS(grid, row + 1, col);
        visitIslandDFS(grid, row - 1, col);
        visitIslandDFS(grid, row, col + 1);
        visitIslandDFS(grid, row, col - 1);
    }
}
