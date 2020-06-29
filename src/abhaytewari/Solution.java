package abhaytewari;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public int getSubstringCount(String s1, String ss) {
        int count = 0;

        Pattern pattern = Pattern.compile(ss);
        Matcher matcher = pattern.matcher(s1);

        if (Pattern.matches("[A-Za-z]", s1)) {
            System.out.println("matched");
        } else {
            System.out.println("not matched");
        }

        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "1";
        String ss = "nn";
        System.out.println(s.getSubstringCount(s1, ss));
    }
}