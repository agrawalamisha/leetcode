package medium.intervalListIntersection;

import java.util.*;

public class Solution {
    public int[][] intervalIntersection1(int[][] A, int[][] B) {
        int ans[][] = new int[(A.length * 3) - 2][2];
        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            int start = Math.min(Math.max(A[i][0], B[i][0]), Math.max(A[i][1], B[i][1]));
            int end   = Math.max(Math.min(A[i][0], B[i][0]), Math.min(A[i][1], B[i][1]));
            if (start <= end) {
                ans[counter][0] = start;
                ans[counter][1] = end;
                counter++;
            }
            if (i != A.length - 1) {
                start = Math.max(A[i][1], B[i + 1][0]);
                end = Math.min(A[i][1], B[i + 1][0]);
                if (start <= end) {
                    ans[counter][0] = start;
                    ans[counter][1] = end;
                    counter++;
                }
                start = Math.max(B[i][1], A[i + 1][0]);
                end = Math.min(B[i][1], A[i + 1][0]);
                if (start <= end) {
                    ans[counter][0] = start;
                    ans[counter][1] = end;
                    counter++;
                }
            }
        }
        return ans;
    }

    public int[][] intervalIntersection2(int[][] A, int[][] B) {
        int[] pair = new int[2];
        List<int[]> ans= new ArrayList<>();
        if (!(A == null || B == null || A.length == 0 || B.length == 0)) {
            for (int i = 0; i < Math.min(A.length, B.length); i++) {
                int start = Math.min(Math.max(A[i][0], B[i][0]), Math.max(A[i][1], B[i][1]));
                int end   = Math.max(Math.min(A[i][0], B[i][0]), Math.min(A[i][1], B[i][1]));
                if (start <= end) {
                    pair[0] = start;
                    pair[1] = end;
                    ans.add(pair);
                    pair = new int[2];
                }
                if (i < B.length - 1) {
                    start = Math.max(A[i][1], B[i + 1][0]);
                    end = Math.min(A[i][1], B[i + 1][0]);
                    if (start <= end) {
                        pair[0] = start;
                        pair[1] = end;
                        ans.add(pair);
                        pair = new int[2];
                    }
                }
                if (i < A.length - 1) {
                    start = Math.max(B[i][1], A[i + 1][0]);
                    end = Math.min(B[i][1], A[i + 1][0]);
                    if (start <= end) {
                        pair[0] = start;
                        pair[1] = end;
                        ans.add(pair);
                        pair = new int[2];
                    }
                }
            }
        }
        int[][] ansArray = new int[ans.size()][2];
        for (int i = 0; i < ansArray.length; i++) {
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }

    public int[][] intervalIntersection3(int[][] A, int[][] B) {
        int [] pair = new int[2];
        List<int[]> listAns = new ArrayList<>();

        if (!(A == null || B == null || A.length == 0 || B.length == 0)) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            for (int i = 0; i < A.length; i++) {
                for (int j = A[i][0]; j <= A[i][1]; j++) {
                    set1.add(j);
                }
            }
            for (int i = 0; i < B.length; i++) {
                for (int j = B[i][0]; j <= B[i][1]; j++) {
                    set2.add(j);
                }
            }

            Set<Integer> intersection = new TreeSet<>();
            intersection.addAll(set1);
            intersection.retainAll(set2);

            Iterator<Integer> itr = intersection.iterator();
            int start = 0, end = 0;
            while (itr.hasNext()) {
                int num1 = itr.next();

                if (itr.hasNext()) {
                    int num2 = itr.next();
                    start = num1;
                    while (num2 - num1 == 1) {
                        if (itr.hasNext()) {
                            num1 = num2;
                            end = num2;
                            num2 = itr.next();
                        } else {
                            break;
                        }
                    }
                    pair[0] = start;
                    pair[1] = end;
                    listAns.add(pair);
                    pair = new int[2];
                }
            }
        }
        int [][] ans = new int[listAns.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = listAns.get(i);
        }
        return ans;

    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int[] pair = new int[2];
        List<int[]> ans= new ArrayList<>();
        if (!(A == null || B == null || A.length == 0 || B.length == 0)) {
            // for (int i = 0; i < Math.min(A.length, B.length); i++) {
            int p1 = 0, p2 = 0;
            while (true) {
                int start = Math.min(Math.max(A[p1][0], B[p2][0]), Math.max(A[p1][1], B[p2][1]));
                int end   = Math.max(Math.min(A[p1][0], B[p2][0]), Math.min(A[p1][1], B[p2][1]));
                if (start <= end) {
                    pair[0] = start;
                    pair[1] = end;
                    ans.add(pair);
                    pair = new int[2];
                } else {
                    // TODO :: ??
                }
                if (p2 < B.length - 1) {
                    start = Math.max(A[p1][1], B[p2][0]);
                    end = Math.min(A[p1][1], B[p2][0]);
                    if (start <= end) {
                        pair[0] = start;
                        pair[1] = end;
                        ans.add(pair);
                        pair = new int[2];
                    }
                }
                if (p1 < A.length - 1) {
                    start = Math.max(B[p1][1], A[p2 + 1][0]);
                    end = Math.min(B[p1][1], A[p2 + 1][0]);
                    if (start <= end) {
                        pair[0] = start;
                        pair[1] = end;
                        ans.add(pair);
                        pair = new int[2];
                    }
                }
            }
        }
        int[][] ansArray = new int[ans.size()][2];
        for (int i = 0; i < ansArray.length; i++) {
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }

    public static void main(String[] args) {
        // int [][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        // int [][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        int [][] A = {{8, 15}};
        int [][] B = {{2, 6} ,{8, 10}, {12, 20}};

        Solution solution = new Solution();
        int [][] ans = solution.intervalIntersection(A, B);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
        System.out.println(ans);
    }
}
