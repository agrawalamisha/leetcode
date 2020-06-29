package test;

public class BinSearch {

    public static void main(String[] args) {
        BinSearch b = new BinSearch();
        int[] w = {5, 8, 14, 21, 23, 26};
        int ansIndex = b.find(6, 0, w.length - 1, w);
        System.out.println(ansIndex);
    }

    public int find(int n, int start, int end, int[] cw) {
        // find index of smallest element larger than n
        int mid = (start + end) / 2;

        while (start < end) {
            if (n > cw[mid]) {
                start = mid;
                mid = (start + end) / 2;
            } else if (n < cw[mid]) {
                end = mid;
                mid = (start + end) / 2;
            } else {
                return mid;
            }
        }
        return mid;
    }
}
