package medium.validSudoku;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check 9 rows
        // check 9 columns
        // check 9 boxes
        int [] rowCounter = new int[10];
        int [] columnCounter = new int[10];
        int [] boxCounter = new int[10];

        for (int i = 0; i < board.length; i++) {
            rowCounter = new int[10];
            columnCounter = new int[10];
            for (int j = 0 ;j < board.length; j++) {
                // check ith row
                if (board[i][j] != '.') {
                    if (rowCounter[board[i][j] - '0'] == 1) {
                        return false;
                    }
                    rowCounter[board[i][j] - '0']++;
                }
                // check ith column
                if (board[j][i] != '.') {
                    if (rowCounter[board[j][i] - '0'] == 1) {
                        return false;
                    }
                    rowCounter[board[j][i] - '0']++;
                }
                int boxRowIndex = (i % 3);
                int boxColIndex = (j % 3);
                if (board[j][i] != '.') {
                    if (boxCounter[board[j][i] - '0'] == 1) {
                        return false;
                    }
                    rowCounter[board[j][i] - '0']++;
                }
            }
        }

        // 1, 2, 3 | 4, 5, 6 | 7, 8, 9


        for (int counter = 0; counter < 9; counter++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
//                    boxCounter
                }
            }
        }
        return true;
    }
}
