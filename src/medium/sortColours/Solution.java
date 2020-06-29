package medium.sortColours;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int [] chars = {0, 1, 2};
        Arrays.fill(chars, 0);
        for (int i = 0; i < nums.length; i++) {
            chars[nums[i]]++;
        }
        int counter = 0;
        for (int i = 0; i < chars.length; i++) {
            while (chars[i] > 0) {
                nums[counter] = i;
                chars[i]--;
                counter++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = {2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(ar));
        solution.sortColors(ar);
        System.out.println(Arrays.toString(ar));
    }
}