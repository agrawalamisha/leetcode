package easy.pow3;

public class Solution {
    public boolean isPowerOfThree(int n) {
        /*if (n == 1) return true;
        if (n < 3) return false;
        while (n > 1) {
            if (n % 3 == 0) {
                n /= 3;
            } else {
                return false;
            }
        }
        return true;*/
        if (n < 1) return false;
        int pow = (int)(Math.log(Integer.MAX_VALUE)/Math.log(3));
        if ((Math.pow(3, pow)) % n == 0) return true;
        return false;
        /*String str = Integer.toString(n, 3);
        System.out.println(str);
        if (str.matches("1(0)*") || str.matches("(0)*"))
        return true;
        else return false;*/
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree(3));

    }
}