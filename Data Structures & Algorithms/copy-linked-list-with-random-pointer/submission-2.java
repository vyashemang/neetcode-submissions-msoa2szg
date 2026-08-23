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
        Node newHead = new Node(0);

        Node t1 = head;
        Node t2 = newHead;

        Map<Node, Node> m = new HashMap<>();

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
            t2.random = m.get(t1.random);
            t2 = t2.next;
            t1 = t1.next;
        }

        return newHead;
    }
}
