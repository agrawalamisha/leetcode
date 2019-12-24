package easy.heightsChecker;

import java.util.Arrays;

public class Solution {
    public int heightChecker(int[] heights) {
        int [] freq = new int[101];
        for (int i = 0; i < heights.length; i++) {
            freq[heights[i]]++;
        }

        int counter = 0, index = 0;
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[i]; j++) {
                if (i != heights[index]) {
                    counter++;
                }
                index++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = {1, 1, 4, 2, 1, 3};
//        int[] heights = {7, 4, 5, 6, 4, 2, 1, 4, 6, 5, 4, 8, 3, 1, 8, 2, 7, 6, 3, 2};
        int [] arr2 = heights.clone();

        System.out.println("Before sort : " + Arrays.toString(heights));

        /*int counter = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] != heights[i]) {
                counter++;
            }
        }
        System.out.println("After sort : " + Arrays.toString(heights));*/
        System.out.println(solution.heightChecker(arr2));
    }
}
