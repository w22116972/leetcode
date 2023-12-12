import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        final int startingColor = image[sr][sc];
        if (color == startingColor) {
            return image;
        }
        return floodFillDFSHelper(image, sr, sc, color, startingColor);
    }

    public int[][] floodFillDFSHelper(int[][] image, int row, int col, int color, int startingColor) {
        if (!isValid(image, row, col) || !isSameColor(image, row, col, startingColor)) {
            return image;
        }
        image[row][col] = color;
        floodFillDFSHelper(image, row + 1, col, color, startingColor);
        floodFillDFSHelper(image, row - 1, col, color, startingColor);
        floodFillDFSHelper(image, row, col + 1, color, startingColor);
        floodFillDFSHelper(image, row, col - 1, color, startingColor);
        return image;
    }


    public int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
        final int startingColor = image[sr][sc];
        if (color == startingColor) {
            return image;
        }

        Queue<Cell> nextVisitCells = new LinkedList<>();
        nextVisitCells.add(new Cell(sr, sc));
        while (!nextVisitCells.isEmpty()) {
            final Cell cell = nextVisitCells.poll();

            if (!isValid(image, cell.row, cell.col) || !isSameColor(image, cell.row, cell.col, startingColor)) {
                continue;
            }

            image[cell.row][cell.col] = color;

            nextVisitCells.add(new Cell(cell.row + 1, cell.col));
            nextVisitCells.add(new Cell(cell.row - 1, cell.col));
            nextVisitCells.add(new Cell(cell.row, cell.col + 1));
            nextVisitCells.add(new Cell(cell.row, cell.col - 1));
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

    public static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
