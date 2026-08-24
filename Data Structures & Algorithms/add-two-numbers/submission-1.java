/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0, carry = 0;

        ListNode t1 = l1;
        ListNode t2 = l2;

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode res = new ListNode(0);
        ListNode tr = res;

        while (t1 != null && t2 != null) {
            sum = t1.val + t2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            tr.next = new ListNode(sum);
            tr = tr.next;
            t1 = t1.next;
            t2 = t2.next;
        }

        while (t1 != null) {
            sum = t1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            tr.next = new ListNode(sum);
            tr = tr.next;
            t1 = t1.next;
        }

        while (t2 != null) {
            sum = t2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            tr.next = new ListNode(sum);
            tr = tr.next;
            t2 = t2.next;
        }

        if (carry != 0) {
            tr.next = new ListNode(carry);
        }

        return res.next;
    }
}
