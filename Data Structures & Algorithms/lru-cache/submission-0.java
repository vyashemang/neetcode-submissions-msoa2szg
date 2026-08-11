class LRUCache {

    private Map<Integer, ListNode> cache;
    private int size;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
        size = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        ListNode newNode = new ListNode(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > size) {
            ListNode lru = this.head.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void remove(ListNode node) {
        ListNode prev = node.prev;
        ListNode nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    private void insert(ListNode node) {
        ListNode prev = this.tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.tail;
        this.tail.prev = node;
    }
}


public class ListNode {
    ListNode next;
    ListNode prev;
    int val;
    int key;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
