package medium.rotateList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode p1 = head;
        int counter = 0;

        while (p1.next != null) {
            p1 = p1.next;
            counter++;
            if (counter > k) {
                //
            }
        }
        p1.next = head;

        if (k > counter) {
            k = (k % counter) - 1;
        }

        p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        head = p1.next;
        p1.next = null;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = new ListNode(0);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        solution.rotateRight(l, 4);
    }
}
