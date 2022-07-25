package dfs;

import java.util.HashSet;
import java.util.Map;

public class MaxAreaOfIsland {

    private int maxRow;
    private int maxCol;
    private int maxArea = 0;
    private int currentArea = 0;
    // store "row,col"
    private HashSet<String> visitedArea = new HashSet<>();

    public int maxAreaOfIsland(int[][] grid) {
        maxRow = grid.length;
        maxCol = grid[0].length;
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                dfs(grid, row, col);
                maxArea = Math.max(maxArea, currentArea);
                currentArea = 0;
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= maxRow || col >= maxCol || visitedArea.contains(row + "," + col)
                || grid[row][col] == 0) {
            return;
        } else {
            currentArea += 1;
            visitedArea.add(row + "," + col);
            dfs(grid, row + 1, col);
            dfs(grid, row, col + 1);
            dfs(grid, row - 1, col);
            dfs(grid, row, col - 1);
        }
    }
}
