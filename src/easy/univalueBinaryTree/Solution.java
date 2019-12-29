package easy.univalueBinaryTree;

public class Solution {
    int rootVal;
    boolean uniValFlag = true;
    public boolean isUnivalTree(TreeNode root) {
        rootVal = root.val;
        traverse(root);
        return uniValFlag;
    }

    public void traverse(TreeNode node) {
        if (!uniValFlag) {
            return;// return false;
        }
        if (node == null) {
            return; // return uniValFlag;
        }
        if (node.val != rootVal) {
            uniValFlag = false;
            // return false;
        }
        if (node.left != null) {
            traverse(node.left);
        }
        if (node.right != null) {
            traverse(node.right);
        }
        // return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(2);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        System.out.println(solution.isUnivalTree(root));
    }
}
