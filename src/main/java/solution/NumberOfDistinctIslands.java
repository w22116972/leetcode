package solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfDistinctIslands {

    // Use coordinate relative to the starting point to build the island path
    public int numberofDistinctIslands(int[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        // e.g. "[0,0][1,0][1,1]"
        Set<String> distinctIslands = new HashSet<>();

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (isLand(grid, row, col) && !isVisited(grid, row, col)) {
                    distinctIslands.add(buildIslandPathByCoordinateBFS(grid, row, col));
                }
            }
        }
        return distinctIslands.size();
    }

    // Use direction to build the island path
    // O: origin, R: right, L: left, U: up, D: down
    public int numberofDistinctIslands2(int[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        Set<String> distinctIslands = new HashSet<>();

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (isLand(grid, row, col) && !isVisited(grid, row, col)) {
                    distinctIslands.add(buildIslandPathByCoordinateDFS(grid, row, col));
                }
            }
        }
        return distinctIslands.size();
    }

    public static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    // use BFS + coordinate relative to the starting point to build the island path
    private String buildIslandPathByCoordinateBFS(int[][] grid, int row, int col) {
        StringBuilder path = new StringBuilder();
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(row, col));
        while (!queue.isEmpty()) {
            final Cell cell = queue.poll();
            if (!isInGrid(grid, cell.row, cell.col) || isVisited(grid, cell.row, cell.col) || isWater(grid, cell.row, cell.col)) {
                continue;
            }
            grid[cell.row][cell.col] = VISITED;
            path.append("[").append(cell.row - row).append(",").append(cell.col - col).append("]");
            queue.add(new Cell(cell.row + 1, cell.col));
            queue.add(new Cell(cell.row - 1, cell.col));
            queue.add(new Cell(cell.row, cell.col + 1));
            queue.add(new Cell(cell.row, cell.col - 1));
        }
        return path.toString();
    }

    // use DFS + coordinate relative to the starting point to build the island path
    private String buildIslandPathByCoordinateDFS(int[][] grid, int row, int col) {
        StringBuilder path = new StringBuilder();
        if (!isInGrid(grid, row, col) || isVisited(grid, row, col) || isWater(grid, row, col)) {
            return path.toString();
        }
        grid[row][col] = VISITED;
        path.append("[").append(row).append(",").append(col).append("]");
        path.append(buildIslandPathByCoordinateDFS(grid, row + 1, col));
        path.append(buildIslandPathByCoordinateDFS(grid, row - 1, col));
        path.append(buildIslandPathByCoordinateDFS(grid, row, col + 1));
        path.append(buildIslandPathByCoordinateDFS(grid, row, col - 1));
        return path.toString();
    }

    // use DFS + direction to build the island path
    private String buildIslandPathByDirectionDFS(int[][] grid, int row, int col, char direction) {
        StringBuilder path = new StringBuilder();
        if (!isInGrid(grid, row, col) || isVisited(grid, row, col) || isWater(grid, row, col)) {
            return path.toString();
        }
        grid[row][col] = VISITED;
        path.append(direction);
        path.append(buildIslandPathByDirectionDFS(grid, row + 1, col, 'D'));
        path.append(buildIslandPathByDirectionDFS(grid, row - 1, col, 'U'));
        path.append(buildIslandPathByDirectionDFS(grid, row, col + 1, 'R'));
        path.append(buildIslandPathByDirectionDFS(grid, row, col - 1, 'L'));
        path.append("B");
        return path.toString();
    }

    // convert above function into BFS
    private String buildIslandPathByDirectionBFS(int[][] grid, int row, int col) {
        StringBuilder path = new StringBuilder();
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(row, col));
        path.append("O");
        while (!queue.isEmpty()) {
            final Cell cell = queue.poll();
            if (!isInGrid(grid, cell.row, cell.col) || isVisited(grid, cell.row, cell.col) || isWater(grid, cell.row, cell.col)) {
                continue;
            }
            grid[cell.row][cell.col] = VISITED;
            if (isInGrid(grid, cell.row + 1, cell.col) && isLand(grid, cell.row + 1, cell.col)) {
                queue.add(new Cell(cell.row + 1, cell.col));
                path.append("D");
            }
            if (isInGrid(grid, cell.row - 1, cell.col) && isLand(grid, cell.row - 1, cell.col)) {
                queue.add(new Cell(cell.row - 1, cell.col));
                path.append("U");
            }
            if (isInGrid(grid, cell.row, cell.col + 1) && isLand(grid, cell.row, cell.col + 1)) {
                queue.add(new Cell(cell.row, cell.col + 1));
                path.append("R");
            }
            if (isInGrid(grid, cell.row, cell.col - 1) && isLand(grid, cell.row, cell.col - 1)) {
                queue.add(new Cell(cell.row, cell.col - 1));
                path.append("L");
            }
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
