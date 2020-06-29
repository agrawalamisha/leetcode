package easy.reverseInteger;

public class Solution {
    public int reverse(int x) {
        int sol = 0, sign = 1, prev_num = 0;
        if (x < 0) {
            sign = -1;
            x = Math.abs(x);
        }
        // 1534236469
        while (x > 0) {
            sol = (sol * 10) + (x % 10);
            if ((sol - (x % 10))/10 != prev_num) {
                sol = 0;
                break;
            }
            x = x / 10;
            prev_num = sol;
        }
        return sol * sign;
    }
    public int reverse2(int x) {
        StringBuilder sb = new StringBuilder(Integer.toString(x));
        sb.reverse();
        int sol = 0;
        try {
            sol = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            sol = 0;
        }
        return sol;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.reverse(1534236469);
        System.out.println(ans);
    }
}