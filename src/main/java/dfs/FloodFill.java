package dfs;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        final int srcColor = image[sr][sc];
        if (srcColor == color) {
            return image;
        }
        fillDFS(image, sr, sc, srcColor, color);
        return image;
    }

    public void fillDFS(int[][] image, int row, int col, int srcColor, int dstColor) {
        if (!isValid(image, row, col) || !isSameColor(image, row, col, srcColor)) {
            return;
        }
        image[row][col] = dstColor;

        fillDFS(image, row + 1, col, srcColor, dstColor);
        fillDFS(image, row - 1, col, srcColor, dstColor);
        fillDFS(image, row, col + 1, srcColor, dstColor);
        fillDFS(image, row, col - 1, srcColor, dstColor);
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
