package easy.reverseWordsString;

public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder revStr = new StringBuilder();
        for (String word : words) {
            StringBuilder revWord = new StringBuilder(word);
            revWord.reverse();
            revStr.append(revWord);
            revStr.append(" ");
        }
        return revStr.toString().trim();
    }
}
