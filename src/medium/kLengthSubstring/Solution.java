package medium.kLengthSubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /*
    * int ans = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;

        for (int j = 0; j < S.length(); j++) {
            while (set.contains(S.charAt(j))) {
                set.remove(S.charAt(i++));
            }
            set.add(S.charAt(j));

            if (j - i + 1 == K) {
                ans++;
                set.remove(S.charAt(i++));
            }
        }
        return ans;
    }
    * */
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (S == null || S.length() < K) {
            return 0;
        }
        int start = 0, end = 0, num = 0;
        Set<Character> freq = new HashSet<>();
        char[] ar = S.toCharArray();
        while (end < ar.length) {
            while (freq.contains(ar[end])) {
                freq.remove(ar[start]);
                start++;
            }
            freq.add(ar[end]);

            if (end - start + 1 == K) {
                num++;
                freq.remove(ar[start]);
                start++;
            }
            end++;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.numKLenSubstrNoRepeats("abcdbbea", 3); // should be 5
        System.out.println(ans);
    }
}