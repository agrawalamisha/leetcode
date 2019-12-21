package easy.oddcells;

import java.util.Arrays;

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int [][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], 0);
        }
        for (int i = 0; i < indices.length; i++) {
            // indices[i][0], indices[i][1]
            // iterate through columns
            for (int j = 0; j < m; j++) {
                matrix[indices[i][0]][j]++;
            }
            // iterate through rows
            for (int j = 0; j < n; j++) {
                matrix[j][indices[i][1]]++;
            }
        }
        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % 2 == 1) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] ar = {{0, 1}, {1, 1}};
        System.out.println(solution.oddCells(2, 3, ar));
    }
}
