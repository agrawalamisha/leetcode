package medium.twoNumSum;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] sol = new int[2];
        HashMap<Integer, Integer> arrayMapped = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            arrayMapped.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (arrayMapped.containsKey(complement) && i != arrayMapped.get(complement)) {
                sol[0] = i;
                sol[1] = arrayMapped.get(complement);
                break;
            }
        }
        return sol;
    }

    public int[] twoSum2(int[] nums, int target) {
        int [] sol = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    sol[0] = i;
                    sol[1] = j;
                    break;
                }
            }
        }
        return sol;
    }
}
