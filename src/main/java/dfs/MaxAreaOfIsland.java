package dfs;

import java.util.HashSet;
import java.util.Map;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        int maxArea = 0;

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (isLand(grid, row, col)) {
                    final int currentArea = computeAreaOfIslandDFS(grid, row, col);
                    maxArea = Math.max(currentArea, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int computeAreaOfIslandDFS(int[][] grid, int startingRow, int startingCol) {
        int islandArea = 0;
        if (!isValidLocation(grid, startingRow, startingCol) || isWater(grid, startingRow, startingCol) ||
                isVisited(grid, startingRow, startingCol)) {
            return 0;
        }
        grid[startingRow][startingCol] = -1;
        islandArea += 1;

        islandArea += computeAreaOfIslandDFS(grid, startingRow - 1, startingCol);
        islandArea += computeAreaOfIslandDFS(grid, startingRow + 1, startingCol);
        islandArea += computeAreaOfIslandDFS(grid, startingRow, startingCol - 1);
        islandArea += computeAreaOfIslandDFS(grid, startingRow, startingCol + 1);

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


    // ---



    private int maxRow;
    private int maxCol;
    private int maxArea = 0;
    private int currentArea = 0;
    // store "row,col"
    private HashSet<String> visitedArea = new HashSet<>();

    public int sol(int[][] grid) {
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
