package codility;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Smartnews1 {

    public int solution(int[][] A) {
        // write your code in Java SE 8
        int count = 0;
        final int totalRows = A.length;
        final int totalCols = A[0].length;
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                // mark visited node to 0
                if (A[row][col] != 0) {
                    int currentCountry = A[row][col];
                    // mark visited node to 0
                    A[row][col] = 0;
                    Queue<Axis> queue = new LinkedList<>();
                    queue.add(new Axis(row, col));
                    while (!queue.isEmpty()) {
                        final Axis startAxis = queue.poll();
                        for (Axis direction: directions) {
                            int exploreRow = startAxis.row + direction.row;
                            int exploreCol = startAxis.col + direction.col;
                            if (exploreRow >= 0 && exploreRow < totalRows
                                    && exploreCol >= 0 && exploreCol < totalCols
                                    && A[exploreRow][exploreCol] == currentCountry
                                    && A[exploreRow][exploreCol] != 0) { // not yet visited
                                queue.add(new Axis(exploreRow, exploreCol));
                                A[exploreRow][exploreCol] = 0;
                            }
                        }

                    }
                    count++;
                }
            }
        }
        return count;
    }

    private final List<Axis> directions = Stream.of(new Axis(1, 0), new Axis(-1, 0),
            new Axis(0, 1), new Axis(0, -1)).collect(Collectors.toList());


    static class Axis {
        Integer row;
        Integer col;

        public Axis(Integer row, Integer col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Axis axis = (Axis) o;
            return Objects.equals(this.row, axis.row) && Objects.equals(this.col, axis.col);
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
