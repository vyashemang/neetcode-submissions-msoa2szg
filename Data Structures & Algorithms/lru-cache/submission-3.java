class LRUCache {

    Map<Integer, ListNode> cache;
    int capacity;
    ListNode head;
    ListNode tail;


    public LRUCache(int capacity) {
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            // remove the node from where ever it is present
            removeNode(node);
            
            // insert at last
            insertNodeAtLast(node);

            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {

        ListNode node;

        if (cache.containsKey(key)) {
            node = cache.get(key);
            node.val = value;
            removeNode (node);
        } else {
            node = new ListNode(key, value);
        }

        cache.put(key, node);

        // insert the node at last
        insertNodeAtLast(node);

        // if the size > capacity then remove the first node and delete entry from map 
        if (cache.size() > capacity) {
            ListNode lru = head.next;
            removeNode(lru);
            cache.remove(lru.key);
        }
    }

    private void removeNode (ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertNodeAtLast (ListNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    class ListNode {
        ListNode prev;
        ListNode next;
        int key;
        int val;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
}
