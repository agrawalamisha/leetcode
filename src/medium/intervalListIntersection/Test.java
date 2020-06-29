package medium.intervalListIntersection;

import java.util.*;

class Test {
    public int[][] merge(int[][] intervals) {
        int[][] merged = new int[2][5];
        return merged;
    }

    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = PriorityQueue<>();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}, {2, 3}};
        System.out.println(Arrays.toString(intervals));
        Arrays.sort(intervals, new Comparator<int[]>() {
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
        System.out.println(Arrays.toString(intervals));
    }
}