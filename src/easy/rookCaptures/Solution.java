package easy.rookCaptures;

public class Solution {
    public int numRookCaptures(char[][] board) {

        int numPawns = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    for (int k = i; k < board.length; k++) {
                        if (board[k][j] == '.') {
                            // do nothing
                        } else if (board[k][j] == 'B') {
                            break;
                        } else if (board[k][j] == 'p') {
                            numPawns++;
                            break;
                        }
                    }
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] == '.') {
                            // do nothing
                        } else if (board[k][j] == 'B') {
                            break;
                        } else if (board[k][j] == 'p') {
                            numPawns++;
                            break;
                        }
                    }
                    for (int k = j; k < board.length; k++) {
                        if (board[i][k] == '.') {
                            // do nothing
                        } else if (board[i][k] == 'B') {
                            break;
                        } else if (board[i][k] == 'p') {
                            numPawns++;
                            break;
                        }
                    }
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[i][k] == '.') {
                            // do nothing
                        } else if (board[i][k] == 'B') {
                            break;
                        } else if (board[i][k] == 'p') {
                            numPawns++;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return numPawns;
    }
}
