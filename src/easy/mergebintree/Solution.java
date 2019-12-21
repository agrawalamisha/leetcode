package easy.mergebintree;

public class Solution {
    // Definition for a binary tree node.

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode t1 = new TreeNode(1);
        TreeNode temp = t1;
        temp.left = new TreeNode(3);
        temp.right = new TreeNode(2);
        temp.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        temp = t2;
        temp.left = new TreeNode(1);
        temp.right = new TreeNode(3);
        temp.left.right = new TreeNode(4);
        temp.right.right = new TreeNode(7);

        temp = solution.mergeTrees(t1, t2);
        temp.traverse(temp);
    }
}