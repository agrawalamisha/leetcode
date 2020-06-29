package easy.palindrome;

public class Solution {
    public boolean isPalindrome1(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        String ss = s.toLowerCase();
        ss = ss.replaceAll("[^a-z0-9]", "");
        StringBuilder sb = new StringBuilder(ss);
        sb.reverse();
        if (ss.equals(sb.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        char[] ar = s.toLowerCase().toCharArray();
        int start = 0, end = ar.length - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(ar[start])) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(ar[end])) {
                end--;
                continue;
            }
            if (ar[start] != ar[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isAlphaNumeric(char c) {
        if (Character.isAlphabetic(c) == true || (c >= '0' && c <= '9')) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(res);
    }
}
