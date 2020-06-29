package easy.mostCommonWord;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public String mostCommonWord2(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String ban : banned) {
            paragraph = paragraph.replaceAll(".*\\b" + ban + "\\b.*", "");
        }
        paragraph = paragraph.replaceAll("[!?',;.]", " ");
        Scanner scan = new Scanner(paragraph);

        while (scan.hasNext()) {
            String word = scan.next();
            if (word.matches("[A-Za-z]+")) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        int maxCount = Integer.MIN_VALUE;
        String word = "";
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (maxCount < entry.getValue()) {
                maxCount = entry.getValue();
                word = entry.getKey();
            }
        }
        return word;
    }
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String ban : banned) {
            paragraph = paragraph.replaceAll("\\b" + ban + "\\b", "");
        }
        // paragraph = paragraph.replaceAll("[!?',;.]", " ");

        String[] para = paragraph.split("[!?',;. ]+");
        for (String word : para) {
//            String word = scan.next();
            //if (word.matches("[A-Za-z]+")) {
            if (word.length() > 0) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        int maxCount = Integer.MIN_VALUE;
        String word = "";
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (maxCount < entry.getValue()) {
                maxCount = entry.getValue();
                word = entry.getKey();
            }
        }
        return word;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String [] ar = {"hit", "bob"};
        System.out.println(solution.mostCommonWord("Bob. hIt, baLl", ar));
    }
}
