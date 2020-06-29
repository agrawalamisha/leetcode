package medium.atoi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int myAtoi2(String str) {
        // int ans = 0,
        int sign = 1;
        long ans = 0;
        boolean numFound = false;

        char[] ar = str.toCharArray();
        for (int i = 0; i < ar.length; i++) {
            if (!numFound && ar[i] == ' ') {
                continue;
            } else if (!numFound && (Character.isDigit(ar[i]) || ar[i] == '+' || ar[i] == '-')) {
                numFound = true;
                if (Character.isDigit(ar[i])) {
                    ans = ar[i] - '0';
                } else if (ar[i] == '-') {
                    sign = -1;
                }
            } else if (!numFound && !Character.isDigit(ar[i])) {
                return 0;
            } else if (numFound && Character.isDigit(ar[i])) {
                ans = (ans * 10) + (ar[i] - '0');
                if (ans * sign> Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (ans * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                /*
                int prev = ans;
                ans = (ans * 10) + (ar[i] - '0');
                if ((ans - (ar[i] - '0')) / 10 != prev) {
                    if (sign == -1) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }*/
                /*
                try {
                    ans = Math.addExact((ans * 10), (ar[i] - '0'));
                } catch (ArithmeticException ae) {
                    if (sign == -1) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }*/

            } else {
                break;
            }
        }
        return (int) ans * sign;

    }

    public int myAtoi(String str) {
        int sign = 1;
        long ans = 0;

        char[] ar = str.toCharArray();
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == ' ') {
                continue;
            } else if (ar[i] == '+' || ar[i] == '-') {
                if (ar[i] == '-') {
                    sign = -1;
                }
            } else if (Character.isDigit(ar[i])) {
                ans = (ans * 10) + (ar[i] - '0');
                if (ans * sign> Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (ans * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        return (int) ans * sign;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//         System.out.println(solution.myAtoi("2147483648"));
        // System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("4193 with woords"));
    }
}
