package easy.dietPlanPerformance;

public class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int start = 0, end = 0, total = 0, points = 0;
        while (end < calories.length) {
            while (end - start < k) {
                points += calories[end];
                end++;
            }
            if (points < lower) {
                total++;
            } else if (points > upper) {
                total--;
            }
            points -= calories[start];
            start++;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] cal = {3, 2};
        int ans = solution.dietPlanPerformance(cal, 2, 0, 1);
        System.out.println(ans);
    }
}