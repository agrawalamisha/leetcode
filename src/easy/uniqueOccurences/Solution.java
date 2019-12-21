package easy.uniqueOccurences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] counter = new int[2001];
        Set<Integer> uniqueCounter = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            counter[arr[i] + 1000]++;
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 0) {
            } else {
                if (!uniqueCounter.contains(counter[i])) {
                    uniqueCounter.add(counter[i]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean uniqueOccurrences4(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        Set<Integer> uniqueCounter = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            counter.put(arr[i], counter.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if(!uniqueCounter.contains(entry.getValue())) {
                uniqueCounter.add(entry.getValue());
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        Map<Integer, Integer> uniqueCounter = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            counter.put(arr[i], counter.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if(!uniqueCounter.containsKey(entry.getValue())) {
                uniqueCounter.put(entry.getValue(), entry.getKey());
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean uniqueOccurrences3(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        return count.size() == new HashSet<>(count.values()).size();
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 2, 1, 1, 3};
        Solution solution = new Solution();
        System.out.println(solution.uniqueOccurrences(arr));
    }

}
