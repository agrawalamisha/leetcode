package easy.reorderLogFiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        Map<String, String> letterLogs = new TreeMap<>();
        ArrayList<String> numberLogs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int indexSpace = logs[i].indexOf(' ');
            String id = logs[i].substring(0, indexSpace);
            String logData = logs[i].substring(indexSpace + 1) + "~" + id;
            if (Character.isDigit(logData.charAt(0))) {
                numberLogs.add(logs[i]);
            } else {
                letterLogs.put(logData, id);
            }
        }
        String[] sol = new String[logs.length];
        int counter = 0;
        for (Map.Entry<String, String> entry : letterLogs.entrySet()) {
            String key = entry.getKey();
            sol[counter++] = entry.getValue() + " " + key.substring(0, key.indexOf("~"));
        }
        for (String s : numberLogs) {
            sol[counter++] = s;
        }
        return sol;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] log = {"dig1 8 1 5 1", "let1 art can","dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] res = solution.reorderLogFiles(log);
        System.out.println(Arrays.toString(res));
    }
}


