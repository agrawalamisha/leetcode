package medium.longSubstrNoRepeat;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring2(String s) {
        int startPointer = 0, currPointer = 0, length = 0, maxLen = 0;
        char[] ar = s.toCharArray();
        Set<Character> charset = new HashSet();;
        while (startPointer < ar.length) {
            charset = new HashSet();
            length = 0;
            currPointer = startPointer;
            while (currPointer < ar.length) {
                if (charset.contains(ar[currPointer])) {
                    charset.remove(ar[startPointer]);
                    break;
                } else {
                    charset.add(ar[currPointer]);
                    length++;
                    currPointer++;
                }
            }
            if (length > maxLen) {
                maxLen = length;
            }
            startPointer++;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        char[] ar = s.toCharArray();
        int len = 0, maxLen = 0, i = 0 , j = 0;
        HashSet<Character> charset = new HashSet<>();
        while (i < ar.length && j < ar.length) {
            if (charset.contains(ar[j])) {
                charset.remove(ar[i]);
                i++;
            } else {
                charset.add(ar[j]);
                j++;
                maxLen = Math.max(charset.size(), maxLen);
            }
        }
        return maxLen;
    }


}
