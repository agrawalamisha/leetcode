package medium.wordSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Position { // implements Comparable{
    int x;
    int y;
    boolean isUsed;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.isUsed = false;
    }

    public boolean isAdjacent(Position p) {
        if (Math.abs(this.x - p.x) <= 1 && Math.abs(this.y - p.y) <= 1) {
            return true;
        }
        return false;
    }
    /*@Override
    public int compareTo(Position p) {
        if (p == null) {
            return 1;
        }
        if (p == this) {
            return 0;
        }
        if (p1.x == this.x && p1.y == p.y) {
            return 0;
        }
        return 1;
    }*/
}
class Solution {
    HashMap<Character, List<Position>> characterMap;

    public boolean exist(char[][] board, String word) {
        characterMap = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                List<Position> l = characterMap.get(board[i][j]);
                if (l == null) {
                    l = new ArrayList<>();
                    characterMap.put(board[i][j], l);
                }
                l.add(new Position(i, j));
            }
        }

        char[] ar = word.toCharArray();
        Stack<Position> order = new Stack<>();
        Position next = null;
        for (int i = 0; i < ar.length; i++) {
            Position prev = next;
            next = findNextCharacter(ar[i], prev);
            if (next != null) {
                order.push(next);
            }
            if (next == null) {
                if (!order.isEmpty()) {
                    prev = order.pop();
                    if (prev != null) {
                        prev.isUsed = false;
                        i--;
                        continue;
                    }

                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public Position findNextCharacter(char c, Position p) {
        List<Position> l = characterMap.get(c);
        if (l == null) {
            return null;
        }

        Position pos = null;
        for (int i = 0; i < l.size(); i++) {
            pos = l.get(i);

            if (p == null) {
                pos.isUsed = true;
                return pos;
            }

            if (p == pos || pos.isUsed) {
                continue;
            }

            if (pos.isAdjacent(p)) {
                pos.isUsed = true;
                return pos;
            } else {
                pos.isUsed = false;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
        char [][] board = {{'a', 'a'}};
        boolean res = sol.exist(board, "aaa");
        System.out.println(res);

    }
}