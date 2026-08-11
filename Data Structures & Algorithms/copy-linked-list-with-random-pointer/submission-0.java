/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node newHead = new Node(0);

        Map<Node, Node> m = new HashMap<>();

        Node t1 = head;
        Node t2 = newHead;
        while (t1 != null) {
            t2.next = new Node(t1.val);
            t2 = t2.next;
            m.put(t1, t2);
            t1 = t1.next;
        }

        newHead = newHead.next;

        t1 = head;
        t2 = newHead;

        while (t1 != null) {
            t2.random = t1.random != null ? m.get(t1.random) : null;
            t1 = t1.next;
            t2 = t2.next;
        }

        return newHead;
    }
}
