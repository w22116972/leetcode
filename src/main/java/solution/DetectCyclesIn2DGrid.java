package solution;

import java.util.*;

@Deprecated
// TODO Wrong Answer
public class DetectCyclesIn2DGrid {

    private final HashSet<String> visitedSet = new HashSet<>();

    public boolean containsCycle(char[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (!isVisited(row, col) && hasCycle(grid, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(char[][] grid, int startRow, int startCol) {
        boolean hasCycle = false;
        final char targetChar = grid[startRow][startCol];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol, -1, -1});

        while (!queue.isEmpty()) {
            final int[] poll = queue.poll();
            final int row = poll[0];
            final int col = poll[1];
            final int prevRow = poll[2];
            final int prevCol = poll[3];

            if (!isInGrid(grid, row, col) || grid[row][col] != targetChar) {
                continue;
            } else if (isVisited(row, col)) {
                return true;
            }
            visitedSet.add(row + "," + col);
            if (row + 1 != prevRow) {
                queue.add(new int[]{row + 1, col, row, col});
            }
            if (row - 1 != prevRow) {
                queue.add(new int[]{row - 1, col, row, col});
            }
            if (col + 1 != prevCol) {
                queue.add(new int[]{row, col + 1, row, col});
            }
            if (col - 1 != prevCol) {
                queue.add(new int[]{row, col - 1, row, col});
            }
        }
        return hasCycle;
    }

    private boolean isInGrid(char[][] grid, int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
    }

    private boolean isVisited(int row, int col) {
        return visitedSet.contains(row + "," + col);
    }
}
