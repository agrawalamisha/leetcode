package easy.shortestDistChar;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] shortestToChar2(String S, char C) {
        char[] ar = S.toCharArray();
        int [] ans = new int[ar.length];
        Set<Integer> cPos = new HashSet<>();
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == C) {
                cPos.add(i);
            }
        }

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != C) {
                int minDist = Integer.MAX_VALUE;
                for (int cpos : cPos) {
                    minDist = Math.min(minDist, Math.abs(cpos - i));
                }
                ans[i] = minDist;
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }

    public int[] shortestToChar(String S, char C) {
        char[] ar = S.toCharArray();
        int[] dist = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == C) {
                dist[i] = 0;
            } else {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // forward pass
        for (int i = 0; i < dist.length - 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                // do nothing
            } else {
                dist[i + 1] = Math.min(dist[i] + 1, dist[i + 1]);
            }
        }

        // reverse pass
        for (int i = dist.length - 1; i >= 0; i--) {
            if (dist[i] == Integer.MAX_VALUE) {
                // do nothing
            } else {
                dist[i - 1] = Math.min(dist[i] + 1, dist[i - 1]);
            }
        }

        return dist;
    }
}
