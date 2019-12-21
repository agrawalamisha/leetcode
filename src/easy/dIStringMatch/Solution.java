package easy.dIStringMatch;

import java.util.Arrays;

public class Solution {
    public int[] diStringMatch(String S) {
        int upper = S.length();
        int lower = 0;
        int[] ans = new int[S.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'D') {
                ans[i] = upper--;
            } else {
                ans[i] = lower++;
            }
        }
        ans[S.length()] = lower;
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.diStringMatch("IDID")));
        System.out.println(Arrays.toString(solution.diStringMatch("III")));
    }
}
