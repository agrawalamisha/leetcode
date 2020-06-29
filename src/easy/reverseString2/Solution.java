package easy.reverseString2;

import java.util.Arrays;

public class Solution {
    public void reverseWords(char[] s) {
        // reverse the compelte string
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }

        // reverse each word
        /*
        eulb si
        */
        int startPos = 0;
        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                int len = (i - startPos);
                int end = startPos + len - 1;
                for (int j = startPos; j < startPos + (len / 2); j++) {
                    char temp = s[j];
                    s[j] = s[end];
                    s[end] = temp;
                    end--;
                }
                startPos = i + 1;
            }

        }
    }

    public static void main(String[] args) {
        char[] ar = {'i','s',' ','b','l','u','e'};
        Solution solution = new Solution();
        solution.reverseWords(ar);
        System.out.println(Arrays.toString(ar));
    }
}