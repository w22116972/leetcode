package hashmapset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VerifySudokuBoard {
    public boolean verifySudokuBoard(int[][] board) {
        // Create hash sets for each row, column, and subgrid to keep
        //  track of numbers previously seen on any given row, column, or subgrid.
        // Note: Declare an array of hash sets with size 9
        Set<Integer>[] rowSets = new HashSet[9];
        // Note: use Arrays.setAll() to initialize each hash set in the array
        Arrays.setAll(rowSets, i -> new HashSet<>());

        Set<Integer>[] columnSets = new HashSet[9];
        Arrays.setAll(columnSets, i -> new HashSet<>());

        Set<Integer>[][] subgridSets = new HashSet[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                subgridSets[i][j] = new HashSet<>();
            }
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int num = board[r][c];
                if (num == 0) {
                    continue;
                }
                // Check if 'num' has been seen in the current row, column, or subgrid.
                if (rowSets[r].contains(num) || columnSets[c].contains(num) || subgridSets[r / 3][c/ 3].contains(num)) {
                    return false;
                }
                // Add the number to the hash sets for the current row, column, and subgrid.
                rowSets[r].add(num);
                columnSets[c].add(num);
                subgridSets[r / 3][c / 3].add(num);
            }
        }
        return true;
    }
}
