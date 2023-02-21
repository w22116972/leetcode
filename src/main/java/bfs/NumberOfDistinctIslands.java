package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfDistinctIslands {

    // 用一個Set存放不同的島嶼 (存放內容可以是用字串串接)
    // 每次走訪時，如果是 land就把該land的座標減去起點的座標，即可得到相對座標

    public int numberofDistinctIslands(int[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        // e.g. "[0,0][1,0][1,1]"
        Set<String> distinctIslands = new HashSet<>();

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (isLand(grid, row, col)) {
                    distinctIslands.add(buildIslandPath(grid, row, col));
                }
            }
        }

        return distinctIslands.size();
    }

    private String buildIslandPath(int[][] grid, int startRow, int startCol) {
        StringBuilder path = new StringBuilder();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        while (!queue.isEmpty()) {
            final int[] location = queue.poll();
            final int row = location[0];
            final int col = location[1];

            if (!isInGrid(grid, row, col) || isVisited(grid, row, col) || isWater(grid, row, col)) {
                continue;
            }
            // is land
            grid[row][col] = VISITED;
            path.append("[").append(row - startRow).append(",").append(col - startCol).append("]");
            queue.add(new int[]{row + 1, col});
            queue.add(new int[]{row - 1, col});
            queue.add(new int[]{row, col + 1});
            queue.add(new int[]{row, col - 1});
        }
        return path.toString();
    }


    private static final int LAND = 1;
    private static final int WATER = 0;
    private static final int VISITED = -1;

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
