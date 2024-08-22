package solution;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        for (int row = 0; row < numRows; row++) {
            List<Integer> numbersInRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    numbersInRow.add(1);
                } else {
                    numbersInRow.add(triangle.get(row - 1).get(col - 1) + triangle.get(row - 1).get(col));
                }
            }
            triangle.add(numbersInRow);
        }
        return triangle;
    }
}
