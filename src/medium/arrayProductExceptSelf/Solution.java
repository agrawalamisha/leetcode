package medium.arrayProductExceptSelf;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length - 1;
        int[] lProd = new int[len + 1];
        int[] rProd = new int[len + 1];
        int[] prodArr = new int[len + 1];
        lProd[0] = 1;
        rProd[len] = 1;

        for (int i = 1; i <= len; i++) {
            lProd[i] = nums[i - 1] * lProd[i - 1];
        }

        for (int i = len - 1; i >= 0; i--) {
            rProd[i] = nums[i + 1] * rProd[i + 1];
        }

         for (int i = 0; i <= len; i++) {
            prodArr[i] = lProd[i] * rProd[i];
        }

        return prodArr;
    }
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length - 1;
        int[] prodArr = new int[len + 1];
        prodArr[0] = 1;

        for (int i = 1; i <= len; i++) {
            prodArr[i] = nums[i - 1] * prodArr[i - 1];
        }
        int rprod = 1;
        for (int i = len; i >= 0; i--) {
            int prev = rprod;
            prodArr[i] = rprod * prodArr[i];
            rprod = nums[i] * prev;
        }
        return prodArr;
    }

    public static void main(String[] args) {
        int [] ar = {1, 2, 3, 4};
        Solution solution = new Solution();
        int ar2[] = solution.productExceptSelf(ar);
        System.out.println(Arrays.toString(ar2));
    }
}
