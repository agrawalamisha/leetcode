package easy.mergebintree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public void traverse(TreeNode t) {
        if (t == null) {
            return;
        }
        System.out.println(t.val + ", ");
        traverse(t.left);
        traverse(t.right);
    }
}
