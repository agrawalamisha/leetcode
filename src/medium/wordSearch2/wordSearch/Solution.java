package medium.wordSearch2.wordSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Solution {
    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && search(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        if  ((i < 0 || j < 0 || i >= board.length || j >= board[i].length ||
                visited[i][j]) || word.charAt(index) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (search(board, word, index + 1, i, j + 1) ||
                search(board, word, index + 1, i + 1, j) ||
                search(board, word, index + 1, i, j - 1) ||
                search(board, word, index + 1, i - 1, j)) {
            return true;
        }
        visited[i][j] = false;

        return false;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
//        char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
        char [][] board = {{'a'}};
        boolean res = sol.exist(board, "ab");
        System.out.println(res);

    }
}