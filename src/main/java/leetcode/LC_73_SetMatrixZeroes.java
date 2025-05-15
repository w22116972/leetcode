package leetcode;

public class LC_73_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        } else if(matrix.length == 1 && matrix[0].length == 1) {
            matrix[0][0] = 0;
            return;
        }

        // Use 1st row and 1st col as marker 0 to achieve S = O(1)
        // e.g. m[i][0]: all i-row are 0s, m[0][j]: all j-col are 0s
        // If m[i][0] or m[0][j] is non-zero, then override by 0 is ok
        // If m[i][0] or m[0][j] is zero, then it is still 0
        // note that m[0][0] is affected by both m[i][0] and m[0][j]
        boolean isFirstColZero = false;
        boolean isFirstRowZero = false;

        // check if the first row contains any zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        // check if the first column contains any zero
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        // mark the zeros in the first row and first column
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark row
                    matrix[0][j] = 0; // mark col
                }
            }
        }

        // set zeros based on the markers
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // set the first row to zero if isFirstRowZero=true
        if (isFirstRowZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // set the first col to zero if isFirstColZero=true
        if (isFirstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
