package solution;

import java.util.LinkedList;
import java.util.Queue;

// 0: land
// 1: water
public class NumberOfClosedIslands {

    private static final int LAND = 0;
    private static final int WATER = 1;
    private static final int VISITED = -1;

    // 1. 把與edge相連的陸地，及其所有連接的陸地都轉為海洋
    // 2. 轉完後再去找陸地的個數就能保證找出的都是封閉的陸地
    public int closedIsland2(int[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (isEdgeLand(grid, row, col)) {
                    markEdgeLandAsWaterBFS(grid, row, col);
                }
            }
        }

        // Resolve it as 200. Number of Islands
        int numberOfClosedIslands = 0;
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (!isVisited(grid, row, col) && isLand(grid, row, col)) {
                    markLandAsVisitedBFS(grid, row, col);
                    numberOfClosedIslands++;
                }
            }
        }
        return numberOfClosedIslands;
    }

    public static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private boolean isVisited(int[][] grid, int x, int y) {
        return grid[x][y] == VISITED;
    }

    private boolean isEdgeLand(int[][] grid, int x, int y) {
        return (x == 0 || y == 0 || x == grid.length - 1 || y == grid[0].length - 1) && grid[x][y] == LAND;
    }

    private boolean isWater(int[][] grid, int x, int y) {
        return grid[x][y] == WATER;
    }

    private boolean isLand(int[][] grid, int x, int y) {
        return grid[x][y] == LAND;
    }

    private boolean isValidCell(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    private void markEdgeLandAsWaterBFS(int[][] grid, int row, int col) {
        Queue<Cell> nextVisitCells = new LinkedList<>();
        nextVisitCells.add(new Cell(row, col));
        while (!nextVisitCells.isEmpty()) {
            final Cell cell = nextVisitCells.poll();
            if (isValidCell(grid, cell.row, cell.col) && isLand(grid, cell.row, cell.col)) {
                // mark land to water
                grid[cell.row][cell.col] = WATER;
                nextVisitCells.add(new Cell(cell.row + 1, cell.col));
                nextVisitCells.add(new Cell(cell.row - 1, cell.col));
                nextVisitCells.add(new Cell(cell.row, cell.col + 1));
                nextVisitCells.add(new Cell(cell.row, cell.col - 1));
            }
        }
    }

    private void markEdgeLandAsWaterDFS(int[][] grid, int row, int col) {
        if (!isValidCell(grid, row, col) || isWater(grid, row, col)) {
            return;
        }
        grid[row][col] = WATER;
        markEdgeLandAsWaterDFS(grid, row + 1, col);
        markEdgeLandAsWaterDFS(grid, row - 1, col);
        markEdgeLandAsWaterDFS(grid, row, col + 1);
        markEdgeLandAsWaterDFS(grid, row, col - 1);
    }


    private void markLandAsVisitedBFS(int[][] grid, int row, int col) {
        Queue<Cell> nextVisitCells = new LinkedList<>();
        nextVisitCells.add(new Cell(row, col));
        while (!nextVisitCells.isEmpty()) {
            final Cell cell = nextVisitCells.poll();
            if (isVisited(grid, cell.row, cell.col) || isWater(grid, cell.row, cell.col)) {
                continue;
            }
            grid[row][col] = VISITED;
            nextVisitCells.add(new Cell(cell.row + 1, cell.col));
            nextVisitCells.add(new Cell(cell.row - 1, cell.col));
            nextVisitCells.add(new Cell(cell.row, cell.col + 1));
            nextVisitCells.add(new Cell(cell.row, cell.col - 1));
        }
    }

    private void markLandAsVisitedDFS(int[][] grid, int row, int col) {
        if (!isValidCell(grid, row, col) || isVisited(grid, row, col) || isWater(grid, row, col)) {
            return;
        }
        grid[row][col] = VISITED;
        markLandAsVisitedDFS(grid, row + 1, col);
        markLandAsVisitedDFS(grid, row - 1, col);
        markLandAsVisitedDFS(grid, row, col + 1);
        markLandAsVisitedDFS(grid, row, col - 1);
    }
}
