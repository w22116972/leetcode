package solution;

import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeter {

    private static final int LAND = 1;
    private static final int WATER = 0;
    private static final int VISITED = -1;

    public int islandPerimeter(int[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        int landPerimeter = 0;
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (!isCellVisited(grid, row, col) && isCellLand(grid, row, col)) {
                    landPerimeter += countPerimeterBFS(grid, row, col);
                }
            }
        }
        return landPerimeter;
    }

    private static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private int countPerimeterDFS(int[][] grid, int row, int col) {
        if (!isCellInGrid(grid, row, col) || isCellWater(grid, row, col)) {
            return 1;
        }

        if (isCellVisited(grid, row, col)) {
            return 0;
        }

        grid[row][col] = VISITED;

        return countPerimeterDFS(grid, row + 1, col) +
                countPerimeterDFS(grid, row - 1, col) +
                countPerimeterDFS(grid, row, col + 1) +
                countPerimeterDFS(grid, row, col - 1);
    }

    private int countPerimeterBFS(int[][] grid, int row, int col) {
        int perimeter = 0;
        Queue<Cell> nextVisitCells = new LinkedList<>();
        nextVisitCells.add(new Cell(row, col));
        while (!nextVisitCells.isEmpty()) {
            final Cell cell = nextVisitCells.poll();
            if (isCellVisited(grid, cell.row, cell.col) || isCellWater(grid, cell.row, cell.col)) {
                continue;
            }

            if (!isCellInGrid(grid, cell.row + 1, cell.col) || isCellWater(grid, cell.row + 1, cell.col)) {
                perimeter++;
            }
            if (isCellInGrid(grid, cell.row + 1, cell.col) && isCellLand(grid, cell.row + 1, cell.col)) {
                nextVisitCells.add(new Cell(cell.row + 1, cell.col));
            }


            if (!isCellInGrid(grid, cell.row - 1, cell.col) || isCellWater(grid, cell.row - 1, cell.col)) {
                perimeter++;
            }
            if (isCellInGrid(grid, cell.row - 1, cell.col) && isCellLand(grid, cell.row - 1, cell.col)) {
                nextVisitCells.add(new Cell(cell.row - 1, cell.col));
            }

            if (!isCellInGrid(grid, cell.row, cell.col + 1) || isCellWater(grid, cell.row, cell.col + 1)) {
                perimeter++;
            }
            if (isCellInGrid(grid, cell.row, cell.col + 1) && isCellLand(grid, cell.row, cell.col + 1)) {
                nextVisitCells.add(new Cell(cell.row, cell.col + 1));
            }

            if (!isCellInGrid(grid, cell.row, cell.col - 1) || isCellWater(grid, cell.row, cell.col - 1)) {
                perimeter++;
            }
            if (isCellInGrid(grid, cell.row, cell.col - 1) && isCellLand(grid, cell.row, cell.col - 1)) {
                nextVisitCells.add(new Cell(cell.row, cell.col - 1));
            }

            grid[cell.row][cell.col] = VISITED;
        }
        return perimeter;
    }

    private static boolean isCellInGrid(int[][]grid, int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
    }

    private static boolean isCellLand(int[][]grid, int row, int col) {
        return grid[row][col] == LAND;
    }

    private static boolean isCellWater(int[][]grid, int row, int col) {
        return grid[row][col] == WATER;
    }

    private static boolean isCellVisited(int[][]grid, int row, int col) {
        return grid[row][col] == VISITED;
    }
}
