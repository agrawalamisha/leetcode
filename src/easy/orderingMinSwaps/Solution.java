package easy.orderingMinSwaps;

import java.util.Arrays;

public class Solution {
    int numSwaps = 0;
    public int heightChecker(int[] heights) {
        int[] arr2 = null;
        System.arraycopy(heights, 0, arr2, 0, heights.length);
        return 0;
    }

    public void quicksort(int [] arr, int start, int end) {
        int pivot = partition(arr, start, end);
        if (start < pivot) {
            quicksort(arr, start, pivot - 1);
        }
        if (pivot < end) {
            quicksort(arr, pivot + 1, end);
        }
    }

    public int partition(int [] arr, int left, int right) {
        int pivotIndex = left;
        int pivot = arr[pivotIndex];
        while (left < right) {
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            while (left < right && arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                numSwaps++;
            }
        }
        if (arr[left] > pivot) {
            if (arr[left - 1] != pivot) {
                int temp = arr[left - 1];
                arr[left - 1] = arr[pivotIndex];
                arr[pivotIndex] = temp;
                numSwaps++;
            }
        } else if (arr[left] < pivot) {
            int temp = arr[left];
            arr[left] = arr[pivotIndex];
            arr[pivotIndex] = temp;
            numSwaps++;
        }
        return pivotIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] heights = {1, 1, 4, 2, 1, 3};
        int[] heights = {7,4,5,6,4,2,1,4,6,5,4,8,3,1,8,2,7,6,3,2};
        int [] arr2 = heights.clone();
        System.out.println("Before sort : " + Arrays.toString(heights));
        solution.quicksort(heights, 0, heights.length - 1);
        System.out.println("After sort : " + Arrays.toString(heights));

        int counter = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] != heights[i]) {
                counter++;
            }
        }
        System.out.println(Arrays.toString(arr2));
        System.out.println(counter);
        System.out.println(solution.numSwaps);
    }
}
