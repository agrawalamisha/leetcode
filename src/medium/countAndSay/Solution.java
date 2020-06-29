package medium.countAndSay;

public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String prevStr = "11";
        int j = 0, counter = 0;
        for (int i = 3; i <= n; i++) {
            char[] prev = prevStr.toCharArray();
            char lastChar = prev[0];
            counter = 1;
            StringBuilder sb = new StringBuilder();
            while (j < prev.length - 1) {
                while (prev[j] == prev[j + 1]) {
                    j++;
                    prevStr = sb.toString();
                    counter++;
                }
                sb.append(counter).append(lastChar);
            }
        }
        return prevStr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(4));
    }
}
