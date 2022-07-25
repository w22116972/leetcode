package hashtable;

import java.util.HashMap;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        final int boardLength = board.length;

        // valid 3 x 3 section
        for (int i = 0; i < boardLength; i += 3) {
            for (int j = 0; j < boardLength; j += 3) {
                if (!validSudo(i, j, board)) {
                    return false;
                }
            }

        }

        // valid row of board
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= boardLength; i++) {
            map.put(i, 0);
        }
        for (int row = 0; row < boardLength; row++) {
            for (int col = 0; col < boardLength; col++) {
                final char c = board[row][col];
                if (c == '.') {
                    continue;
                }
                final int num = c - 48;
                if (map.containsKey(num) && map.get(num) == 0) {
                    map.put(num, 1);
                } else {
                    System.out.println("num = " + num);
                    System.out.println("map.containsKey(num) = " + map.containsKey(num));

                    System.out.println("valid row of board with " + row + "," + col);
                    return false;
                }
            }
            map.clear();
            for (int i = 1; i <= boardLength; i++) {
                map.put(i, 0);
            }
        }

        map.clear();
        for (int i = 1; i <= boardLength; i++) {
            map.put(i, 0);
        }
        // valid col of board
        for (int col = 0; col < boardLength; col++) {
            for (int row = 0; row < boardLength; row++) {
                final char c = board[row][col];
                if (c == '.') {
                    continue;
                }
                final int num = c - 48;
                if (map.containsKey(num) && map.get(num) == 0) {
                    map.put(num, 1);
                } else {
                    System.out.println("valid col of board with " + row + "," + col);
                    return false;
                }
            }
            map.clear();
            for (int i = 1; i <= boardLength; i++) {
                map.put(i, 0);
            }
        }


        return true;
    }

    // valid 3x3 section
    // rowIndex is starting index of row
    public boolean validSudo(int rowIndex, int colIndex, char[][] board) {
        final int boardLength = board.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= boardLength; i++) {
            map.put(i, 0);
        }

        for (int i = rowIndex; i < rowIndex + 3; i++) {
            for (int j = colIndex; j < colIndex + 3; j++) {
                if (board[i][j] == '.') {
                     continue;
                }
                final int num = board[i][j] - 48;
                if (map.containsKey(num) && map.get(num) == 0) {
                    map.put(num, 1);
                } else if (!map.containsKey(num) || (map.containsKey(num) && map.get(num) == 1)) {
                    System.out.println("valid section with " + i + "," + j);
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final char c = '9' - 48;
        System.out.println("(int) c = " + (int) c);
    }
}
