package easy.projections;

public class Solution {
    public int projectionArea(int[][] grid) {
        int xyTop = 0;
        int rowMax = 0;
        int colMax = 0;
        int xz = 0, yz = 0;
        for (int i = 0; i < grid.length; i++) {
            rowMax = 0;
            colMax = 0;

            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    xyTop++;
                }
                rowMax = Math.max(rowMax, grid[j][i]);
                colMax = Math.max(colMax, grid[i][j]);
            }
            xz += rowMax;
            yz += colMax;
        }
        return xyTop + yz + xz;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] grid = {{1, 0}, {0, 2}};
        System.out.println(solution.projectionArea(grid));
    }
}
