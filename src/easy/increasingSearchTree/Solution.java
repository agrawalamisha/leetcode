package easy.increasingSearchTree;

public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newTree = new TreeNode(0), newTreeRoot;
        newTreeRoot = newTree;
        inOrder(root, newTree);
        traverse(newTreeRoot);
        return newTreeRoot;

    }

    public void inOrder(TreeNode node, TreeNode newTreeNode) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrder(node.left, newTreeNode);
        }
        newTreeNode.val = node.val;
        newTreeNode.right = new TreeNode(0);
        newTreeNode = newTreeNode.right;
        // System.out.println(node.val, );
        if (node.right != null) {
            inOrder(node.right, newTreeNode);
        }
    }

    public void traverse(TreeNode t) {
        if (t == null) {
            return;
        }
        if (t.left != null) {
            traverse(t.left);
        }
        System.out.print(t.val + " ");
        if (t.right != null) {
            traverse(t.right);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(3);
        t.right = new TreeNode(6);
        t.left.left = new TreeNode(2);
        t.left.right = new TreeNode(4);
        t.left.left.left = new TreeNode(1);
        t.right.right = new TreeNode(8);
        t.right.right.right = new TreeNode(9);
        t.right.right.left = new TreeNode(7);
        solution.traverse(t);
        System.out.println("-----------");
        TreeNode t2 = solution.increasingBST(t);
        solution.traverse(t2);
    }
}
