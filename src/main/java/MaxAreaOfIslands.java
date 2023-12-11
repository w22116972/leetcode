import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIslands {
    private static final int VISITED_CELL = -1;

    public int maxAreaOfIsland(int[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        int maxArea = 0;

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (isLand(grid, row, col)) {
                    final int currentArea = getAreaOfIslandBFS(grid, row, col);
                    maxArea = Math.max(currentArea, maxArea);
                }
            }
        }
        return maxArea;
    }


    private boolean isLand(int[][] grid, int row, int col) {
        return grid[row][col] == 1;
    }

    private boolean isWater(int[][] grid, int row, int col) {
        return grid[row][col] == 0;
    }

    private boolean isCellVisited(int[][] grid, int row, int col) {
        return grid[row][col] == VISITED_CELL;
    }

    private boolean isCellValid(int[][] grid, int row, int col) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        return row >= 0 && col >= 0 && row < totalRows && col < totalCols;
    }


    public static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int getAreaOfIslandBFS(int[][] grid, int row, int col) {
        Queue<Cell> nextVisitCells = new LinkedList<>();
        int islandArea = 0;
        nextVisitCells.add(new Cell(row, col));
        while (!nextVisitCells.isEmpty()) {
            final Cell cell = nextVisitCells.poll();
            if (!isCellValid(grid, cell.row, cell.col) || isWater(grid, cell.row, cell.col) || isCellVisited(grid, cell.row, cell.col)) {
                continue;
            }
            islandArea++;
            grid[row][col] = VISITED_CELL;

            nextVisitCells.add(new Cell(cell.row + 1, cell.col));
            nextVisitCells.add(new Cell(cell.row - 1, cell.col));
            nextVisitCells.add(new Cell(cell.row, cell.col + 1));
            nextVisitCells.add(new Cell(cell.row, cell.col - 1));
        }
        return islandArea;
    }

    public int getAreaOfIslandDFS(int[][] grid, int row, int col) {
        if (!isCellValid(grid, row, col) || isWater(grid, row, col) || isCellVisited(grid, row, col)) {
            return 0;
        }
        grid[row][col] = VISITED_CELL;
        return 1 + getAreaOfIslandDFS(grid, row + 1, col) + getAreaOfIslandDFS(grid, row - 1, col) + getAreaOfIslandDFS(grid, row, col + 1) + getAreaOfIslandDFS(grid, row, col - 1);
    }

}
