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

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode t1 = list1;
        ListNode t2 = list2;

        ListNode head = new ListNode();
        ListNode t = head;

        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                t.next = new ListNode(t1.val);
                t1 = t1.next;
            } else {
                t.next = new ListNode(t2.val);
                t2 = t2.next;
            }
            t = t.next;
        }

        if (t1 != null) {
            t.next = t1;
        } else {
            t.next = t2;
        }

        return head.next;    
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        ListNode res = new ListNode();

        for(int i = 1; i < lists.length; i++) {
            lists[i] = mergeTwoLists(lists[i], lists[i - 1]);
        }

        return lists[lists.length - 1];

    }
}
