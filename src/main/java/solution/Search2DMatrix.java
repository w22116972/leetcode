package solution;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {


        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        // use binary search to find which row
        int head = 0;
        int tail = rowSize - 1;
        int targetRow = 0;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (matrix[mid][0] > target) {
                tail = mid - 1;
            } else if (matrix[mid][0] < target && matrix[mid][colSize - 1] > target) {
                targetRow = mid;
                break;
            } else if (matrix[mid][0] == target || matrix[mid][colSize - 1] == target) {
                return true;
            } else { // matrix[mid][0] < target && matrix[mid][colSize - 1] <= target
                head = mid + 1;
            }
        }


        head = 0;
        tail = colSize - 1;
        while (head <= tail) {
            int mid = (head + tail) / 2; // mid = 0
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] > target) {
                tail = mid - 1;
            } else { // matrix[mid][0] < target && matrix[mid][colSize - 1] <= target
                head = mid + 1;
            }

        }

        return false;

        // use binary search to find which col
    }


    public static void main(String[] args) {
        final Search2DMatrix sol = new Search2DMatrix();
        System.out.println(sol.searchMatrix(new int[][]{{0, 2}}, 1));

    }
}
