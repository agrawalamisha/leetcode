package easy.wordsAndCharacters;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int countCharacters2(String[] words, String chars) {
        /*char[] alphabet = chars.toCharArray();
        List<char> list = Arrays.asList(alphabet);
        int ans = 0;
        for (String word : words) {
            boolean wordOk = true;
            for (int i = 0; i < word.length(); i++) {
                if (alphabet.contains(word.charAt(i))) {
                    // do nothing
                } else {
                    wordOk = false;
                    break;
                }
            }
            if (wordOk) {
                ans += word.length();
            }
        }
        return ans;
        */
        return 0;
    }

    public int countCharacters(String[] words, String chars) {
        int ans = 0;

        int [] alphabetOrig = new int[26];
        int charsLen = chars.length();
        for (int i = 0; i < charsLen; i++) {
            alphabetOrig[(int)(chars.charAt(i)) - 97]++;
        }

        for (String word : words) {
            int [] alphabet = alphabetOrig.clone();
            if(word.length() > charsLen) {
                continue;
            }
            boolean wordOk = true;
            for (int i = 0; i < word.length(); i++) {
                if (alphabet[word.charAt(i) - 97] > 0) {
                    alphabet[word.charAt(i) - 97]--;
                } else {
                    wordOk = false;
                    break;
                }
            }
            if (wordOk) {
                ans += word.length();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String [] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        System.out.print(solution.countCharacters(words, chars));
    }
}
