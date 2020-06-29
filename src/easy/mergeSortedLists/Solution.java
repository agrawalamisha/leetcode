package easy.mergeSortedLists;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3, l3 = new ListNode(1);
        p3 = l3;
        while (p1 != null || p2 != null) {
            if (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    p3.next = new ListNode(p1.val);
                    p1 = p1.next;
                } else {
                    p3.next = new ListNode(p2.val);
                    p2 = p2.next;
                }
            } else if (p1 != null && p2 == null) {
                p3.next = new ListNode(p1.val);
                p1 = p1.next;
            } else if (p1 == null && p2 != null) {
                p3.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        return l3;
    }
}
