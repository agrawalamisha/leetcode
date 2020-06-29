package medium.compareVersions;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String ar1[] = (version1.split("\\."));
        String ar2[] = (version2.split("\\."));
        int l1 = ar1.length, l2 = ar2.length, l = Math.min(l1, l2);

        for (int i = 0; i < l; i++) {
            int n1 = Integer.parseInt(ar1[i]), n2 = Integer.parseInt(ar2[i]);
            if (n1 > n2) {
                return 1;
            } else if (n2 > n1) {
                return -1;
            }
        }
        if (l2 > l1) {
            return -1;
        } else if (l1 > l2) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compareVersion("0.1", "1.1"));
    }
}
