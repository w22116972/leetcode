package bfs;

import java.util.*;

public class NumberOfIslands {
    HashSet<String> visited = new HashSet<>();

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int count = 0;


        final int totalRows = grid.length;
        final int totalCols = grid[0].length;

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (Objects.equals(grid[row][col], '1') &&
                        !visited.contains(row + "," + col)) {
                    bfs(row, col, grid);
                    count += 1;
                }
            }

        }
        return count;
    }

    private List<Point> directions = List.of(new Point(1, 0), new Point(-1, 0),
            new Point(0, 1), new Point(0, -1));

    public void bfs(int row, int col, char[][] grid) {
        final int totalRows = grid.length;
        final int totalCols = grid[0].length;

        visited.add(row + "," + col);
        // use queue to explore same island
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));
        while (!queue.isEmpty()) {
            final Point originPoint = queue.poll();
            for (Point explorePoint: directions) {
                int exploreRow = originPoint.row + explorePoint.row;
                int exploreCol = originPoint.col + explorePoint.col;
                if (exploreRow >= 0 && exploreRow < totalRows && exploreCol >= 0 && exploreCol < totalCols &&
                grid[exploreRow][exploreCol] == '1' && !visited.contains(exploreRow + "," + exploreCol)) {
                    queue.add(new Point(exploreRow, exploreCol));
                    visited.add(exploreRow + "," + exploreCol);
                }
            }

        }

    }

    static class Point {
        Integer row;
        Integer col;

        public Point(Integer row, Integer col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Objects.equals(this.row, point.row) && Objects.equals(this.col, point.col);
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
