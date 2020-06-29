package medium.permutationSequence;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> alphabet = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            alphabet.add(i + 1);
        }
        StringBuilder ans = new StringBuilder();
        int n1f = fact(n);

        while (n > 0) {
            k = k % n1f;
            n1f = n1f / n;
            int nn = getNth(alphabet, ((k - 1) / n1f));
            ans.append(nn);
            n--;
        }

        return ans.toString();
    }

        public String getPermutation2(int n, int k) {
        int [] nums = new int[n];
        List<Integer> alphabet = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
            alphabet.add(nums[i]);
        }
        StringBuilder ans = new StringBuilder();

        int nf = fact(n);
        int n1f = nf / n;

        nums[0] = getNth(alphabet, ((k - 1) / n1f));
        ans.append(nums[0]);

        n--;
        k = k % (n1f);
        n1f = n1f / n;
        nums[1] = getNth(alphabet, ((k - 1) / n1f));
        ans.append(nums[1]);

        n--;
        k = k % (n1f);
        n1f = n1f / n;
        nums[2] = getNth(alphabet, ((k - 1) / n1f));
        ans.append(nums[2]);

        n--;
        k = k % (n1f);
        n1f = n1f / n;
        if (n == 1) {
            nums[3] = alphabet.get(0);
        } else {
            nums[3] = getNth(alphabet, ((k - 1) / n1f));
        }
        ans.append(nums[3]);
        return ans.toString();

    }

    public int fact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public int getNth(List<Integer> list, int n) {
        if (n < list.size()) {
            n = 0;
        }
        int num = list.remove(n);
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 2));
    }
}