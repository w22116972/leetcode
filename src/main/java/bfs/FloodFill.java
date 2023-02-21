package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        final int srcColor = image[sr][sc];
        if (color == srcColor) {
            return image;
        }

        while (!queue.isEmpty()) {
            final int[] currentLocation = queue.poll();
            final int row = currentLocation[0];
            final int col = currentLocation[1];

            if (!isValid(image, row, col) || !isSameColor(image, row, col, srcColor)) {
                continue;
            }

            image[row][col] = color;

            queue.add(new int[]{row + 1, col});
            queue.add(new int[]{row - 1, col});
            queue.add(new int[]{row, col + 1});
            queue.add(new int[]{row, col - 1});
        }
        return image;
    }

    private boolean isValid(int[][] image, int row, int col) {
        final int totalRows = image.length;
        final int totalCols = image[0].length;
        return row >= 0 && row < totalRows && col >= 0 && col < totalCols;
    }

    private boolean isSameColor(int[][] image, int row, int col, int color) {
        return image[row][col] == color;
    }
}
