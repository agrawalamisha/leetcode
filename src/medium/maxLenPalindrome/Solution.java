package medium.maxLenPalindrome;

public class Solution {
    /* public String getPalindrome(String s, int a, int b) {
        String palindrome = Character.toString(s.charAt(b - 1));
        while (a >= 0 && b < s.length()) {
            if (s.charAt(a) == s.charAt(b)) {
                palindrome = s.substring(a, b + 1);
                a--;
                b++;
            } else {
                break;
            }
        }
        return palindrome;
    } */
    public int getPalindromeLen(String s, int a, int b) {
        int len = 1;
        while (a >= 0 && b < s.length()) {
            if (s.charAt(a) == s.charAt(b)) {
                len = b - a + 1;
                a--;
                b++;
            } else {
                break;
            }
        }
        return len;
    }
    /*public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return s;
        }

        // int maxLen = 1, maxLenIndex = 0;
        String palindrome = Character.toString(s.charAt(0));
        for (int i = 0; i < s.length() - 1; i++) {
            String p1 = getPalindrome(s, i, i + 1);
            String p2 = getPalindrome(s, i - 1, i + 1);
            if (palindrome.length() < p1.length()) {
                palindrome = p1;
            }
            if (palindrome.length() < p2.length()) {
                palindrome = p2;
            }
        }
        return palindrome;
    }*/
    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        int maxLen = 1, maxLenIndex = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int p1Len = getPalindromeLen(s, i, i + 1);
            int p2Len = getPalindromeLen(s, i - 1, i + 1);
            if (p1Len > maxLen) {
                maxLen = p1Len;
                maxLenIndex = i;
            }
            if (p2Len > maxLen) {
                maxLen = p2Len;
                maxLenIndex = i;
            }
        }

        String palindrome;
        if (maxLen %2 == 0) {
            palindrome = s.substring(maxLenIndex - (maxLen/2) + 1, maxLenIndex + (maxLen/2) + 1);
        } else {
            palindrome = s.substring(maxLenIndex - (maxLen/2), maxLenIndex + (maxLen/2) + 1);
        }
        return palindrome;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
