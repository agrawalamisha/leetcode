package easy.singleNumber;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        int singleNum = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                singleNum = entry.getKey();
            }
        }
        return singleNum;
    }
}
