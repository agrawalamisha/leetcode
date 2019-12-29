<<<<<<< HEAD
package easy.sortArrayByParity;

import java.util.Arrays;

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int evenPointer = 0, oddPointer = 1;

        while (evenPointer < A.length && oddPointer < A.length) {
            while (evenPointer < A.length && A[evenPointer] % 2 == 0) {
                evenPointer += 2;
            }
            while (oddPointer < A.length &&  A[oddPointer] % 2 != 0) {
                oddPointer += 2;
            }
            if (evenPointer < A.length && oddPointer < A.length ) {
                int temp = A[evenPointer];
                A[evenPointer] = A[oddPointer];
                A[oddPointer] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] arr = {4, 2, 5, 7};
        System.out.println(Arrays.toString(arr));
        solution.sortArrayByParityII(arr);
        System.out.println(Arrays.toString(arr));
    }
}
=======
package easy.sortArrayByParity;

import java.util.Arrays;

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int evenPointer = 0, oddPointer = 1;

        while (evenPointer < A.length && oddPointer < A.length) {
            while (evenPointer < A.length && A[evenPointer] % 2 == 0) {
                evenPointer += 2;
            }
            while (oddPointer < A.length &&  A[oddPointer] % 2 != 0) {
                oddPointer += 2;
            }
            if (evenPointer < A.length && oddPointer < A.length ) {
                int temp = A[evenPointer];
                A[evenPointer] = A[oddPointer];
                A[oddPointer] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] arr = {4, 2, 5, 7};
        System.out.println(Arrays.toString(arr));
        solution.sortArrayByParityII(arr);
        System.out.println(Arrays.toString(arr));
    }
}
>>>>>>> 4727ba8ea448ec78dcd8f94f152c10bbe3064b05
