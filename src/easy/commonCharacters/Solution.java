package easy.commonCharacters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int [][] markers = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                markers[i][A[i].charAt(j) - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            int minMarker = Integer.MAX_VALUE;
            for (int j = 0; j < A.length; j++) {
                minMarker = Math.min(minMarker, markers[j][i]);
            }
            while (minMarker != 0 && minMarker != Integer.MAX_VALUE) {
                ans.add(Character.toString((char)(i + 'a')));
                minMarker--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr1 = {"bella", "label", "roller"};
        List<String> ans = solution.commonChars(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(ans);
    }
}
