package hashtable;

import java.util.HashSet;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        HashSet<String> unvisited = new HashSet<>();

        final int rowLength = matrix.length;
        final int colLength = matrix[0].length;

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (matrix[row][col] == 0) {
                    unvisited.add(row + "," + col);
                }
            }
        }

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (unvisited.contains(row + "," + col)) {
                    for (int i = 0; i < rowLength; i++) {
                        matrix[i][col] = 0;
                    }
                    for (int i = 0; i < colLength; i++) {
                        matrix[row][i] = 0;
                    }
                }
            }
        }


    }
}
