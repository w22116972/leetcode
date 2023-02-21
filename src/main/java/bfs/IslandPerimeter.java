package bfs;

import java.util.LinkedList;
import java.util.Queue;

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
        int perimeter = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            final int[] poll = queue.poll();
            final int x = poll[0];
            final int y = poll[1];
            if (isVisited(grid, x, y)) {
                continue;
            }

            if (!isInGrid(grid, x + 1, y) || isWater(grid, x + 1, y)) {
                perimeter++;
            } else if (isLand(grid, x + 1, y)) {
                queue.add(new int[]{x + 1, y});
            }

            if (!isInGrid(grid, x - 1, y) || isWater(grid, x - 1, y)) {
                perimeter++;
            } else if ( isLand(grid, x - 1, y)) {
                queue.add(new int[]{x - 1, y});
            }

            if (!isInGrid(grid, x, y + 1) || isWater(grid, x, y + 1)) {
                perimeter++;
            } else if (isLand(grid, x, y + 1)){
                queue.add(new int[]{x, y + 1});
            }

            if (!isInGrid(grid, x, y + 1) || isWater(grid, x, y - 1)) {
                perimeter++;
            } else if (isLand(grid, x, y - 1)) {
                queue.add(new int[]{x, y - 1});
            }
            grid[x][y] = VISITED;
        }

        return perimeter;
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
