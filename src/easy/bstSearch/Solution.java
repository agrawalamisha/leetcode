package easy.bstSearch;

public class Solution {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) {
            return root;
        } else if (val < root.val) {
            if (root.left == null) {
                return null;
            }
            return searchBST(root.left, val);
        } else if (val > root.val) {
            if (root.right == null) {
                return null;
            }
            return searchBST(root.right, val);
        }
        return null;
    }
}
