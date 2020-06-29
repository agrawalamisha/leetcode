package medium.rotate2dImage;

public class Solution {
    public void rotate(int[][] matrix) {
        int [][] matCopy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            matCopy[i] = matrix[i].clone();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; i++) {
                matrix[i][j] = matrix[i][j + 1];
            }
        }
    }

    public void reduceIndex(int i, int j, int n) {
        if (i - n > 0) {

        }
    }
    public static void main(String[] args) {
        int [][] mat = new int[10][4];
        System.out.println(mat.length);
    }
}