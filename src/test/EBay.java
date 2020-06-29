package test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EBay {
    int compare(char c1, char c2, Map<Character, Integer> counts) {
        if (counts.get(c1) != counts.get((char)(c2 - 32))) {
            return counts.get(c1) - ((char)(c2 - 32));
        } else {
            return c1 - c2;
        }
    }

    String mergeStrings(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return s2;
        }
        if (s2 == null || s2.length() == 0) {
            return s1;
        }

        Map<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            counts.put(s1.charAt(i), counts.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            counts.put((char)(s2.charAt(i) - 32), counts.getOrDefault((char)(s2.charAt(i) - 32), 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        int p1 = 0, p2 = 0;
        while (p1 < s1.length() && p2 < s2.length()) {
            if (compare(s1.charAt(p1), s2.charAt(p2), counts) < 1) {
                result.append(s1.charAt(p1));
                p1++;
            } else {
                result.append(s2.charAt(p2));
                p2++;
            }
        }
        while (p1 < s1.length()) {
            result.append(s1.charAt(p1));
            p1++;
        }
        while (p2 < s2.length()) {
            result.append(s2.charAt(p2));
            p2++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        EBay e = new EBay();
        System.out.println(e.mergeStrings("enbvszyppzyiydnc", "ousswsbeljamma"));
        System.out.println("eounbvszsswsbeljammayppzyiydnc".equals(e.mergeStrings("enbvszyppzyiydnc", "ousswsbeljamma")));
    }
}
