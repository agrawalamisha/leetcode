package easy.smallestRange;

public class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0]; // Collections.min(Arrays.asList(A));
        int max = A[0]; // Collections.max(Arrays.asList(A));
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }
        }
        return (max - min  - (2 * K)) >= 0 ? (max - min  - (2 * K)) : 0;
    }
}