package easy.validParenthesis;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> charSets = new HashMap<>();
        charSets.put('}', '{');
        charSets.put(']', '[');
        charSets.put(')', '(');
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && (c == ')' || c == ']' || c == '}')) {
                if (stack.peek() == charSets.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}