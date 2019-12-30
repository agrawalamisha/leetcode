package easy.increasingSearchTree;

public class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }

   public String toString() {
       String formatted =  this.val + "(";
       if (left == null) {
           formatted += "null";
       } else {
           formatted += left.val;
       }
       formatted += ", ";
       if (right == null) {
           formatted += "null";
       } else {
           formatted += right.val;
       }
       formatted += ")";
       return formatted;
   }
}
