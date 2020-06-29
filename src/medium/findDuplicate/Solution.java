package medium.findDuplicate;

public class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n != (i + 1)) {
                if (nums[n - 1] == n) {
                    return n;
                }
                int temp = nums[n - 1];
                nums[n - 1] = n;
                nums[i] = temp;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {8, 7, 1, 10, 17, 15, 18, 11, 16, 9, 19, 12, 5, 14, 3, 4, 2, 13, 18, 18};

        System.out.println(solution.findDuplicate(nums));
    }
}