package medium.groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<String> anagramSet;
        List<List<String>> anagramList = new ArrayList<>();
        HashMap<String, List<String>> counterMapping = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String characterMapping = toCharCount(strs[i]);
            if (!counterMapping.containsKey(characterMapping)) {
                List<String> anagramSet = new ArrayList<>();
                anagramSet.add(strs[i]);
                counterMapping.put(toCharCount(strs[i]), anagramSet);
            } else {
                List<String> anagramSet = counterMapping.get(characterMapping);
                anagramSet.add(strs[i]);
            }
        }

        for (List<String> l : counterMapping.values()) {
            anagramList.add(l);
        }
        return anagramList;
    }

    public String toCharCount(String s) {
        int[] counter = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < counter.length; i++) {
            sb.append(counter[i]).append("~");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] ar = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution2 solution = new Solution2();
        List<List<String>> anagramList = solution.groupAnagrams(ar);
        for (List<String> l : anagramList) {
            System.out.println(l);
        }
    }
}
