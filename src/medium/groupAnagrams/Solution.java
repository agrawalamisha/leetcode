package medium.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> anagramSet;
        List<List<String>> anagramList = new ArrayList<>();
        boolean[] isAdded = new boolean[strs.length];
        int[][] ar = new int[strs.length][26];
        Arrays.fill(isAdded, false);
        for (int i = 0; i < strs.length; i++) {
            ar[i] = getAlphabetRep(strs[i]);
        }
        for (int i = 0; i < ar.length; i++) {
            anagramSet = new ArrayList<>();
            if (!isAdded[i]) {
                anagramSet.add(strs[i]);
                isAdded[i] = true;
            }
            for (int j = i + 1; j < ar.length; j++) {
                if (!isAdded[j] && Arrays.compare(ar[i], ar[j]) == 0) {
                    anagramSet.add(strs[j]);
                    isAdded[j] = true;
                }
            }
            if (!anagramSet.isEmpty()) {
                anagramList.add(anagramSet);
            }
        }
        return anagramList;
    }

    public int[] getAlphabetRep(String s) {
        int [] ar = new int[26];
        s = s.toLowerCase();
        Arrays.fill(ar, 0);
        for (int i = 0; i < s.length(); i++) {
            ar[s.charAt(i) - 'a']++;
        }
        return ar;
    }

    public static void main(String[] args) {
        String[] ar = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution solution = new Solution();
        List<List<String>> anagramList = solution.groupAnagrams(ar);
        for (List<String> l : anagramList) {
            System.out.println(l);
        }
    }
}