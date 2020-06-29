package easy.arrayIntersection;

import java.util.*;

public class Solution {
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return nums1;
        } else if (nums2 == null || nums2.length == 0) {
            return nums2;
        }
        List<Integer> sol = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                sol.add(nums1[p1]);
                p1++;
                p2++;
            }
            while (p1 < nums1.length && p2 < nums2.length && nums1[p1] < nums2[p2]) {
                p1++;
            }
            while (p1 < nums1.length && p2 < nums2.length && nums2[p2] < nums1[p1]) {
                p2++;
            }
        }
        int [] ar = new int[sol.size()];
        for (int i = 0; i < sol.size(); i++) {
            ar[i] = sol.get(i);
        }
        return ar;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, false);
        }
        for (int i : nums2) {
            if (map.containsKey(i)) {
                map.put(i, true);
            }
        }
        int counter = 0;

        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                counter++;
            }
        }
        int [] ar = new int[counter];
        counter = 0;
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                ar[counter++] = entry.getKey();
            }
        }
        return ar;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] ar1 = {4, 9, 5};
        int [] ar2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution.intersect(ar1, ar2)));
    }
}
