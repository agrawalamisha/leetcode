package medium.letterCombinationPhone;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public static List<String> letterCombinations(String digits) {
        String[] charMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<String>();

        if (digits.length() == 0) {
            return result;
        }

        result.add("");
        for (int i = 0; i < digits.length(); i++)
            result = combine(charMap[digits.charAt(i) - '0'], result);

        return result;
    }

    public static List<String> combine(String digit, List<String> l) {
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < digit.length(); i++)
            for (String x : l)
                result.add(x + digit.charAt(i));
        return result;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.letterCombinations("23"));
    }
}