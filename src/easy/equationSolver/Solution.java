package easy.equationSolver;

import java.util.ArrayList;
import java.util.List;

public class Solution {
     // This is the custom function interface.
     // You should not implement it, or speculate about its implementation
     class CustomFunction {
         // Returns f(x, y) for any given positive integers x and y.
         // Note that f(x, y) is increasing with respect to both x and y.
         // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
         public int f(int x, int y) {
             return 0;
         }
     };
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pair = null;
        for (int x = 1; x <= 1000; x++) {
            for (int y = 1; y <= 1000; y++) {
                int funcVal = customfunction.f(x, y);
                if (funcVal == z) {
                    pair = new ArrayList<>();
                    pair.add(x);
                    pair.add(y);
                    ans.add(pair);
                }
                if (funcVal > 128 ) {
                    break;
                }
            }
        }
        return ans;
    }
}
