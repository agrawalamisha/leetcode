package easy.happyNumber;

import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        int sum = 0, num = n;
        HashSet<Integer> seen = new HashSet<Integer>();
        seen.add(n);
        while (num != 1) {
            sum = 0;
            while (num > 0) {
                int digit = num % 10;
                sum += (digit * digit);
                num /= 10;
            }
            num = sum;
            if (seen.contains(num)) {
                return false;
            } else {
                seen.add(num);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
}