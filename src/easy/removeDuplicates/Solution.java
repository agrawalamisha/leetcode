package easy.removeDuplicates;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public String removeDuplicates2(String S) {
        for (int j = 0; j < S.length(); j++) {
            boolean dupFound = false;
            for (int i = 0; i < S.length() - 1; i++) {
                char curr = S.charAt(i);
                int startIndex = i, endIndex = i;
                while (i < S.length() - 1 && S.charAt(i + 1) == curr) {
                    dupFound = true;
                    i++;
                    endIndex = i;
                }
                if (endIndex > startIndex) {
                    S = S.substring(0, startIndex) + S.substring(endIndex + 1);
                }
            }
            if (!dupFound) {
                break;
            }
        }
        return S;
    }

    public String removeDuplicates3(String S) {
        while (true) {
            boolean dupFound = false;
            for (int i = 0; i < S.length() - 1; i++) {
                if (S.charAt(i + 1) == S.charAt(i)) {
                    dupFound = true;
                    S = S.substring(0, i) + S.substring(i + 2);
                    i++;
                }
            }
            if (!dupFound) {
                break;
            }
        }
        return S;
    }

    public String removeDuplicates4(String S) {
        Stack<Character> characterStack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (characterStack.isEmpty()) {
                characterStack.push(c);
            } else if (characterStack.peek() == c) {
                characterStack.pop();
            } else {
                characterStack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!characterStack.isEmpty())
            sb.append(characterStack.pop());
        return sb.reverse().toString();
    }

    public String removeDuplicates(String S) {
        Deque<Character> characterQueue = new LinkedList<>();
        for (char c : S.toCharArray()) {
            if (characterQueue.peek() == null) {
                characterQueue.add(c);
            } else if (characterQueue.peekLast() == c) {
                characterQueue.removeLast();
            } else {
                characterQueue.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : characterQueue) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
    }
}
