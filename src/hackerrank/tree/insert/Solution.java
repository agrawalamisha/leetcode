package hackerrank.tree.insert;

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
}

class Solution {

    public static void preOrder( Node root ) {

        if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

    public static Node insert(Node root,int data) {
        Node newNode = new Node(data);
        if (root == null) {
            return newNode;
        }
        Node node = root;
        while (true) {
            if (data > node.data) {
                if (node.right == null) {
                    node.right = newNode;
                    break;
                } else {
                    node = node.right;
                }
            } else {
                if (node.left == null) {
                    node.left = newNode;
                    break;
                } else {
                    node = node.left;
                }
            }
        }
        return root;
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
        preOrder(root);
    }
}