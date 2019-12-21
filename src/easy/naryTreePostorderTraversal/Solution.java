package easy.naryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List <Integer> ans = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root.children != null) {
            for (Node val : root.children) {
                return postorder(val);
            }
        }
        ans.add(root.val);
        return ans;
    }

    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(6);

        ArrayList<Node> list1 = new ArrayList<>();
        list1.add(n1);
        list1.add(n2);

        Node n3 = new Node(3, list1);
        Node n4 = new Node(2);
        Node n5 = new Node(4);

        ArrayList<Node> list2 = new ArrayList<>();
        list2.add(n3);
        list2.add(n4);
        list2.add(n5);
        Node n6 = new Node(1, list2);

        Solution solution = new Solution();
        System.out.println(solution.postorder(n6));
    }
}
