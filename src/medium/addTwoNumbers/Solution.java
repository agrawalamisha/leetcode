package medium.addTwoNumbers;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        if (this == null) {
            return "x";
        }
        String ans = this.val + " -> ";
        ListNode node = this;
        while (node.next != null) {
            node = node.next;
            ans += node.val + " -> ";
        }
        ans += " X";
        return  ans;
    }


}
public class Solution {
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, l3 = new ListNode(-1), p3 = l3;
        int sum = 0, carry = 0;

        while ((p1 != null && p2 != null) || carry != 0) {
            if ((p1 == null && p2 == null) && carry != 0) {
                sum = carry;
                p3.next = new ListNode(sum % 10);
                carry = sum / 10;
            } else if ((p1 == null && p2  != null) && carry != 0) {
                sum += p2.val;
                p3.next = new ListNode(sum % 10);
                carry = sum / 10;
                p2 = p2.next;
            } else if ((p1 == null && p2  != null) && carry != 0) {
                sum += p1.val;
                p3.next = new ListNode(sum % 10);
                carry = sum / 10;
                p1 = p1.next;
            } else if ((p1 != null && p2 != null) && carry == 0) {
                sum = p1.val + p2.val + carry;
                p3.next = new ListNode(sum % 10);
                carry = sum / 10;

                p1 = p1.next;
                p2 = p2.next;
                p3 = p3.next;
            } else {
                break;
            }

        }
        while (p1 != null || carry != 0) {
            if (p1 == null) {
                sum = carry;
                p3.next = new ListNode(sum % 10);
                carry = sum / 10;
            } else {
                sum = carry + p1.val;
                p3.next = new ListNode(sum % 10);
                carry = sum / 10;
                p3 = p3.next;
                p1 = p1.next;
            }

        }

        while (p2 != null || carry != 0) {
            if (p2 == null) {
                sum = carry;
                p3.next = new ListNode(sum % 10);
                carry = sum / 10;
            } else {
                sum = carry + p2.val;
                p3.next = new ListNode(sum % 10);
                carry = sum / 10;
                p3 = p3.next;
                p2 = p2.next;
            }
        }
        return l3;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1), p1 = l1, p2 = l2, p3 = l3;
        int sum = 0, carry = 0;

        if (p1 == null) {
            return l2;
        } else if (p2 == null) {
            return l1;
        }
        while (p1 != null || p2 != null || carry > 0) {
            sum = carry;
            if (p1 != null) {
                sum += p1.val;
            }
            if (p2 != null) {
                sum += p2.val;
            }
            carry = sum / 10;
            p3.next = new ListNode(sum % 10);

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        return l3.next;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(8);
//        l2.next.next = new ListNode(4);
        ListNode l3 = solution.addTwoNumbers(l1, l2);
        System.out.println(l3);//+ " " + l3.next + " " + l3.next.next);
    }
}
