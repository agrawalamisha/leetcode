package easy.linkedListMid;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode pointer = head;
        int counter = 0;
        while (pointer.next != null) {
            counter++;
            pointer = pointer.next;
        }
        if (counter % 2 == 1) {
            counter = (counter + 1) / 2;
        } else {
            counter = counter / 2;
        }
        pointer = head;
        for (int i = 0; i < counter; i++) {
            pointer = pointer.next;
        }
        return pointer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        System.out.println(solution.middleNode(l).val);
    }
}
