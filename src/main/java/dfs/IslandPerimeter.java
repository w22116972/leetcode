package dfs;

public class IslandPerimeter {

    private static final int LAND = 1;
    private static final int WATER = 0;
    private static final int VISITED = -1;

    public int islandPerimeter(int[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        int count = 0;
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (isLand(grid, row, col)) {
                    count += countPerimeter(grid, row, col);
                }
            }
        }
        return count;
    }

    private int countPerimeter(int[][] grid, int row, int col) {
        if (!isInGrid(grid, row, col) || isWater(grid, row, col)) {
            return 1;
        } else if (isVisited(grid, row, col)) {
            return 0;
        }
        grid[row][col] = VISITED;
        return countPerimeter(grid, row + 1, col) +
                countPerimeter(grid, row - 1, col) +
                countPerimeter(grid, row, col + 1) +
                countPerimeter(grid, row, col - 1);
    }

    private static boolean isInGrid(int[][]grid, int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
    }

    private static boolean isLand(int[][]grid, int row, int col) {
        return grid[row][col] == LAND;
    }

    private static boolean isWater(int[][]grid, int row, int col) {
        return grid[row][col] == WATER;
    }

    private static boolean isVisited(int[][]grid, int row, int col) {
        return grid[row][col] == VISITED;
    }
}
