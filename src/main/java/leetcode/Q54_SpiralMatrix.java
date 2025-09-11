package leetcode;

import java.util.List;
import java.util.ArrayList;

public class Q54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Result list to store spiral order
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        final int m = matrix.length;
        final int n = matrix[0].length;
        // Define the boundaries of the spiral
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        // Traverse the matrix in spiral order
        while (top <= bottom && left <= right) {
            // Traverse from top left to top right
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++; // Move the top boundary down

            // Traverse from top right to bottom right
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move the right boundary left

            // Traverse from bottom right t bottom o left
            // if top++ is > bottom, then skip
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--; // Move the bottom boundary up
            }

            // Traverse from bottom left to top left
            // if right-- is < left, then skip
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }
        // Time complexity: O(m*n), each element is visited once
        return result;
    }
}
