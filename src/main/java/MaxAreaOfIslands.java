import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIslands {
    public int maxAreaOfIsland(int[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        int maxArea = 0;

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (isLand(grid, row, col)) {
                    final int currentArea = computeAreaOfIslandBFS(grid, row, col);
                    maxArea = Math.max(currentArea, maxArea);
                }
            }
        }
        return maxArea;
     }

    public int computeAreaOfIslandBFS(int[][] grid, int startingRow, int startingCol) {
        Queue<int[]> queue = new LinkedList<>();
        int islandArea = 0;
        queue.add(new int[]{startingRow, startingCol});
        while (!queue.isEmpty()) {
            final int[] currentLocation = queue.poll();
            final int row = currentLocation[0];
            final int col = currentLocation[1];
            if (!isValidLocation(grid, row, col) || isWater(grid, row, col) || isVisited(grid, row, col)) {
                continue;
            }
            islandArea++;
            grid[row][col] = -1;

            queue.add(new int[]{row + 1, col});
            queue.add(new int[]{row - 1, col});
            queue.add(new int[]{row, col + 1});
            queue.add(new int[]{row, col - 1});
        }
        return islandArea;
    }

    private boolean isLand(int[][] grid, int row, int col) {
        return grid[row][col] == 1;
    }

    private boolean isWater(int[][] grid, int row, int col) {
        return grid[row][col] == 0;
    }

    private boolean isVisited(int[][] grid, int row, int col) {
        return grid[row][col] == -1;
    }

    private boolean isValidLocation(int[][] grid, int row, int col) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        return row >= 0 && col >= 0 && row < totalRows && col < totalCols;
    }

}
