package medium.zigzagLevelOrderTraversal;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> solution = new ArrayList<>();

        if (root == null) {
            return solution;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currLevel = 0;
        while (!q.isEmpty()) {
            int queueSize = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = q.poll();

                if (currLevel % 2 == 0) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            currLevel++;
            solution.add(level);
        }
        return solution;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode root = n1;
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(66);
        TreeNode n7 = new TreeNode(77);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        n4.left = n6;
        n4.right = n7;

        Solution solution = new Solution();
        List<List<Integer>> sol = solution.zigzagLevelOrder(root);
        for (List<Integer> level : sol) {
            System.out.println(level);
        }
    }
}
