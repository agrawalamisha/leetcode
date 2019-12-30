package easy.relativeSortArray;

import java.util.Arrays;

public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int [] markers = new int[1001];

        Arrays.fill(markers, 0);
        for (int i = 0; i < arr1.length; i++) {
            markers[arr1[i]]++;
        }

        int counter = 0;
        int[] arr3 = new int[arr1.length];

        for (int i = 0; i < arr2.length; i++) {
            while (markers[arr2[i]] > 0) {
                arr3[counter] = arr2[i];
                markers[arr2[i]]--;
                counter++;
            }
        }

        for (int i = 0; i < markers.length; i++) {
            while (markers[i] != 0) {
                arr3[counter] = i;
                markers[i]--;
                counter++;
            }
        }
        return arr3;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] arr3 = solution.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
}
