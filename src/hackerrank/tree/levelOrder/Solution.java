package hackerrank.tree.levelOrder;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        String str = "";
        if (left == null) {
            str = "X";
        } else {
            str = Integer.toString(left.data);
        }
        str += "<-" + data + "->";
        if (right == null) {
            str += "X";
        } else {
            str += Integer.toString(right.data);
        }
        return str;
    }
}

class Solution {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        Node node = root;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                node = q.poll();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            System.out.println();
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}