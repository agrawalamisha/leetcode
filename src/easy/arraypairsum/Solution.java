package easy.arraypairsum;

import java.util.Arrays;

public class Solution {
    public int arrayPairSum2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public int arrayPairSum(int[] nums) {
        int [] counter = new int[20001];
        for (int num : nums) {
            counter[num + 10000]++;
        }
        int sum = 0, numCount = 0;
        for (int i = 0; i < 20001; i++) {
            if (numCount == nums.length) {
                break;
            }
            while (counter[i] > 0) {
                numCount++;
                counter[i]--;
                if (numCount % 2 == 1) {
                    sum += (i - 10000);
                }
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] ar = {1, 2, 3, 2};
        System.out.println(solution.arrayPairSum(ar));
    }
}
