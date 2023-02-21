package bfs;

import java.util.LinkedList;
import java.util.Queue;

// 0: land
// 1: water
public class NumberOfClosedIslands {

    // 1. 把與edge相連的陸地，及其所有連接的陸地都轉為海洋
    // 2. 轉完後再去找陸地的個數就能保證找出的都是封閉的陸地
    public int closedIsland2(int[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        int count = 0;
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (isEdgeLand(grid, row, col)) {
                    markEdgeWater(grid, row, col);
                }
            }
        }

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (!isVisited(grid, row, col)
                        && isLand(grid, row, col)
                        && isIsland(grid, row, col)) {
                    count++;
                }
            }
        }
        return count;
    }

    private void markEdgeWater(int[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            final int[] currentPosition = queue.poll();
            final int row = currentPosition[0];
            final int col = currentPosition[1];
            if (isInGrid(grid, row, col) && isLand(grid, row, col)) {
                // mark land to water
                grid[row][col] = WATER;
                queue.add(new int[]{row + 1, col});
                queue.add(new int[]{row - 1, col});
                queue.add(new int[]{row, col + 1});
                queue.add(new int[]{row, col - 1});
            }
        }
    }

    private boolean isIsland(int[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            final int[] currentPosition = queue.poll();
            final int row = currentPosition[0];
            final int col = currentPosition[1];
            if (isLand(grid, row, col)) {
                grid[row][col] = VISITED;
                queue.add(new int[]{row + 1, col});
                queue.add(new int[]{row - 1, col});
                queue.add(new int[]{row, col + 1});
                queue.add(new int[]{row, col - 1});
            }
        }
        return true;
    }

    private static final int LAND = 0;
    private static final int WATER = 1;
    private static final int VISITED = -1;

    // TODO wrong
    public int closedIsland(int[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        int count = 0;

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (isLand(grid, row, col)
                        && isInClosedIsland(grid, row, col)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isInClosedIsland(int[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        boolean isClosed = true;

        while (!queue.isEmpty()) {
            final int[] currentLocation = queue.poll();
            final int row = currentLocation[0];
            final int col = currentLocation[1];
            if (!isInGrid(grid, row, col)) {
                isClosed = false;
            }
            if (isVisited(grid, row, col) ||
                    isWater(grid, row, col)) {
                continue;
            }

            if (isLand(grid, row, col)) {
                grid[row][col] = VISITED;
                queue.add(new int[]{row + 1, col});
                queue.add(new int[]{row - 1, col});
                queue.add(new int[]{row, col + 1});
                queue.add(new int[]{row, col - 1});
            }

        }
        return isClosed;
    }

    private boolean isVisited(int[][] grid, int x, int y) {
        return grid[x][y] == VISITED;
    }

    private boolean isAtBoarder(int[][] grid, int x, int y) {
        return x == 0 || y == 0 || x == grid.length - 1 || y == grid[0].length - 1;
    }

    private boolean isEdgeLand(int[][] grid, int x, int y) {
        return (x == 0 || y == 0 || x == grid.length - 1 || y == grid[0].length - 1) &&
                grid[x][y] == LAND;
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
}
