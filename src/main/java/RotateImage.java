public class RotateImage {

    // (0, 0) -> (0, n-1)
    // (0, 1) -> (1, n−1)
    // (1, 0) -> (0, n-2)
    // (1, 1) -> (1, n-2)
    // (i, j) -> (j, n-1-i) = (old column, reversed row)

    // (i, j) -> transpose -> (j, i) -> reverse row -> (j, n-1-i)
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // reverse row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}
