package easy.fibonacci;

class Solution {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int num0 = 0;
        int num1 = 1;
        int ans = 0;
        for (int i = 2; i <= N; i++) {
            ans = num0 + num1;
            num0 = num1;
            num1 = ans;
        }
        return ans;
    }
}
