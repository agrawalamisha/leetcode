package medium.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        // sort the intervals
        sort(intervals);
        // int[][] merged = new int[2][];
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = new int[2];
            int lower = intervals[i][0];
            int upper = intervals[i][1];
            interval[0] = lower;

            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0]  >= lower &&
                        intervals[j][0] <= upper) {
                    upper = intervals[j][1];
                    i++;
                } else {
                    break;
                }
            }
            interval[1] = upper;
            list.add(interval);
        }
        int[][] merged = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            merged[i] = list.get(i);
        }
        return merged;
    }

    public void sort(int [][] ar) {
        Arrays.sort(ar, new Comparator<int[]>() {
            @Override
            public int compare(int[] ar1, int[] ar2) {
                if (ar1[0] > ar2[0]) {
                    return 1;
                } else if (ar1[0] < ar2[0]) {
                    return -1;
                } else {
                    if (ar1[1] > ar2[1]) {
                        return 1;
                    } else if (ar1[1] < ar2[1]) {
                        return -1;
                    } else return 0;
                }
            }
        });
    }
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}, {2, 3}};
        System.out.println(Arrays.toString(intervals));
        Solution solution = new Solution();
        solution.merge(intervals);
        System.out.println(Arrays.toString(intervals));
    }
}
