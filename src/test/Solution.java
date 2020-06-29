package test;
// Java Code to sort 2D Matrix
// according to any Column
import java.util.*;
public class Solution {

    // Function to sort by column
    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        // Compare values according to columns
        //Arrays.sort(arr, new Comparator<int[]>() {
        Arrays.sort(arr, (entry1, entry2) -> {

            // To sort in descending order revert
            // the '>' Operator
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
        });  // End of function call sort().
    }

    // Driver Code
    public static void main(String args[])
    {
        int matrix[][] = { { 39, 27, 11, 42 },
                { 10, 93, 91, 90 },
                { 54, 78, 56, 89 },
                { 24, 64, 20, 65 } };
        // Sort this matrix by 3rd Column
        int col = 1;
        sortbyColumn(matrix, col - 1);

        // Display the sorted Matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}