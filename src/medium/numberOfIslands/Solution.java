package medium.numberOfIslands;

public class Solution {
    public int numIslands(char[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        int islandCounter = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islandCounter += isIsland(grid, i, j);
                }
            }
        }
        return islandCounter;
    }

    public int isIsland(char grid[][], int i, int j) {
        int island = 0;
        int up, down, left, right;

        if (i == 0) {
            up = '0';
        } else {
            up = grid[i - 1][j];
        }
        if (i == grid.length - 1) {
            down = '0';
        } else {
            down = grid[i + 1][j];
        }
        if (j == 0) {
            left = '0';
        } else {
            left = grid[i][j - 1];
        }
        if (j == grid[i].length - 1) {
            right = '0';
        } else {
            right = grid[i][j + 1];
        }

        if (up == '0' &&
                down == '0' &&
                left == '0' &&
                right == '0') {
            island = 1;
        }

        return island;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] ar = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(solution.numIslands(ar));
    }
}