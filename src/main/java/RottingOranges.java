import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<Node> rottingOranges = new LinkedList<>();
        HashSet<String> freshOranges = new HashSet<>();
        int days = -1;

        final int maxRow = grid.length;
        final int maxCol = grid[0].length;


        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (grid[i][j] == 2) {
                    rottingOranges.add(new Node(i, j));
                } else if (grid[i][j] == 1) {
                    freshOranges.add(i + "," + j);
                }
            }
        }

        if (freshOranges.isEmpty()) {
            return 0;
        }

        while (!rottingOranges.isEmpty()) {
            final int currentRottingOrangeNumber = rottingOranges.size();
            for (int i = 0; i < currentRottingOrangeNumber; i++) {
                final Node rottedOrange = rottingOranges.poll();
                final Integer rottingRow = rottedOrange.row;
                final Integer rottingCol = rottedOrange.col;
                // rot 4 direction
                if (rottingRow - 1 >= 0 && grid[rottingRow - 1][rottingCol] == 1) {
                    rottingOranges.add(new Node(rottingRow - 1, rottingCol));
                    freshOranges.remove((rottingRow - 1) + "," + rottingCol);
                    grid[rottingRow - 1][rottingCol] = 2;
                }
                if (rottingRow + 1 < maxRow && grid[rottingRow + 1][rottingCol] == 1) {
                    rottingOranges.add(new Node(rottingRow + 1, rottingCol));
                    freshOranges.remove((rottingRow + 1) + "," + rottingCol);
                    grid[rottingRow + 1][rottingCol] = 2;
                }
                if (rottingCol - 1 >= 0 && grid[rottingRow][rottingCol - 1] == 1) {
                    rottingOranges.add(new Node(rottingRow, rottingCol - 1));
                    freshOranges.remove(rottingRow + "," + (rottingCol - 1));
                    grid[rottingRow][rottingCol - 1] = 2;
                }
                if (rottingCol + 1 < maxCol && grid[rottingRow][rottingCol + 1] == 1) {
                    rottingOranges.add(new Node(rottingRow, rottingCol + 1));
                    freshOranges.remove(rottingRow + "," + (rottingCol + 1));
                    grid[rottingRow][rottingCol + 1] = 2;
                }
            }
            days++;
        }
        return freshOranges.isEmpty()? days:-1;
    }

    static class Node {
        public Integer row;
        public Integer col;

        public Node(Integer row, Integer col) {
            this.row = row;
            this.col = col;
        }
    }
}
