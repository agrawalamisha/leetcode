package easy.revString;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Solution {
    public void reverseString(char[] s, String a) {
//        String a;
        System.out.println(a.length());
        if (s == null || s.length == 0) {
            return;
        }
        int start = 0, end = s.length - 1;
        char temp =  s[start];
        while (start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        // return s;
    }

    public static void main(String[] args) {
        char [] s = {'h', 'e', 'l', 'l', 'o'};
        Solution solution = new Solution();
        // solution.reverseString(s, "");
        // System.out.println(s);
        String s1 = "acb";
        String s2 = s1;
        String[] arr = {"1", "3", "5", "6", "7", "0"};
        ArrayList<String> ar = new ArrayList<>(Arrays.asList(arr));
        for (String ss : ar) {
            System.out.println(ss);
        }
        // Object;
        /*Iterator i = ar.iterator();
        while (i.hasNext()) {
            String a = i.next();
        }*/
        System.out.println("string comparison " + s1 == s2);
//        System.out.println(++x);
//        Timestamp
        System.out.println(null == null);
        int a = 0XF;
        if (a == 15) {
            System.out.println("0XF == 15");
        }
        /*if (a = 2) {
            System.out.println("here");
        }*/
    }
}