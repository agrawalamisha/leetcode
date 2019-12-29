package easy.treeDepth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int maxDepth(Node root) {
        if (root.children == null) {
            return 1;
        }
        List<Integer> height = new ArrayList<>();
        for (Node node : root.children) {
            height.add(maxDepth(node));
        }
        return 1 + maxChildDepth(height);
    }

    public int maxChildDepth(List<Integer> height) {
        Collections.sort(height);
        return height.get(height.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node root = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        List<Node> list = new ArrayList<>();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        root.children = list;

        Node n4 = new Node(5);
        Node n5 = new Node(6);
        List<Node> l2 = new ArrayList<>();
        l2.add(n4);
        l2.add(n5);
        n2.children = l2;

        Node n6 = new Node(6);
        List<Node> l3 = new ArrayList<>();
        l3.add(n6);
        n5.children = l3;

        System.out.println(solution.maxDepth(root));
    }
}
