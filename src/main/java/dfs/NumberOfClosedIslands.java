package dfs;

public class NumberOfClosedIslands {

    private static final int LAND = 0;
    private static final int WATER = 1;
    private static final int VISITED = -1;

    private boolean isVisited(int[][] grid, int x, int y) {
        return grid[x][y] == VISITED;
    }

    private boolean isWater(int[][] grid, int x, int y) {
        return grid[x][y] == WATER;
    }

    private boolean isLand(int[][] grid, int x, int y) {
        return grid[x][y] == LAND;
    }

    private boolean isInGrid(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    public int closedIsland(int[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        int count = 0;
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (!isVisited(grid, row, col)
                        && isLand(grid, row, col)
                        && isInClosedIsland(grid, row, col)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isInClosedIsland(int[][] grid, int x, int y) {
        // base case
        if (!isInGrid(grid, x, y)) {
            return false;
        }
        if (isWater(grid, x, y) || isVisited(grid, x, y)) {
            return true;
        }
        // now current location is land
        grid[x][y] = VISITED;
        // use `&` instead of `&&` is because `&` will go thru all operators even it is false,
        // and it will mark necessary nodes as visited
        return isInClosedIsland(grid, x + 1, y) &
                isInClosedIsland(grid, x - 1, y) &
                isInClosedIsland(grid, x, y - 1) &
                isInClosedIsland(grid, x, y + 1);
    }
}
