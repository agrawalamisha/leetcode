package medium.remDup;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
//        int[] nums2 = nums.clone();
        int size = nums.length, temp, last = nums[0];
        for (int i = 0; i < size - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                temp = nums[i];
                size--;
                for (int j  = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = temp;
                i--;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 1, 1, 2, 3};
        System.out.println("Size " + solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
