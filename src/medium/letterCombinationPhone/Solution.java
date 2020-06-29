package medium.letterCombinationPhone;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] charMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> tempList = new ArrayList<>();
            for (String s : result) {
                for (int c = 0; c < charMap[digits.charAt(i) - '0'].length(); c++) {
                    result.add(s + charMap[digits.charAt(i) - '0'].charAt(c));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
}
