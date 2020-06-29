package easy.rotateArray;

import java.util.Arrays;

public class Solution {
    public void rotate2(int[] nums, int k) {
        int[] numsCopy = nums.clone();
        int temp = nums [0], size = nums.length;
        for (int i = 0; i < size; i++) {
            nums[(i + k) % size] = numsCopy[i];
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0 || k % nums.length == 0) {
            return;
        }
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);

        // reverse elements upto k - 1
        int fromIndex = 0;
        int toIndex = k - 1;
        reverse(nums, fromIndex, toIndex);

        // reverse last len - k elements
        fromIndex = k;
        toIndex = nums.length - 1;
        reverse(nums, fromIndex, toIndex);

    }

    public void reverse(int[] a, int fromIndex, int toIndex) {
        if (fromIndex <= toIndex) {
            return;
        }
        int mid = ((toIndex - fromIndex) / 2) + fromIndex;
        int temp, counter = 0;
        for (int i = fromIndex; i <= mid; i++) {
            if ((toIndex - counter) != i) {
                temp = a[i];
                a[i] = a[toIndex - counter];
                a[toIndex - counter] = temp;
                counter++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int []a = {1, 2, 3};
//        solution.reverse(a, 0, 4);
        solution.rotate(a, 1);
        System.out.println(Arrays.toString(a));
    }
}