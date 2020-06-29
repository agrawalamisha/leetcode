package easy.moveZeroes;

import java.util.Arrays;

public class Solution {
    public void moveZeroes2(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < size - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[size - 1] = 0;
                i--;
                size--;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] ar = {0, 0, 1};
        solution.moveZeroes(ar);

        System.out.println(Arrays.toString(ar));
    }
}
