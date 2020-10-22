class LRUCache {
    
    class DoublyLinkedNode {
        int key;
        int value;
        DoublyLinkedNode previous;
        DoublyLinkedNode next;
    }
    
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;
    private Map<Integer, DoublyLinkedNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    
    private void remove(DoublyLinkedNode node) {
        DoublyLinkedNode before = node.previous;
        DoublyLinkedNode after = node.next;

        before.next = after;
        after.previous = before;
    }

    private void add(DoublyLinkedNode node) {
        node.previous = head;
        node.next = head.next;
        
        head.next.previous = node;
        head.next = node;
    }

    private void makeHead(DoublyLinkedNode node) {
        remove(node);
        add(node);
    }
    
    private DoublyLinkedNode removeTail() {
        DoublyLinkedNode node = tail.previous;
        remove(node);
        return node;
    }
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        
        head = new DoublyLinkedNode();
        tail = new DoublyLinkedNode();
        head.previous = null;
        tail.next = null;
        head.next = tail;
        tail.previous = head;
    }
    
    public int get(int key) {
        DoublyLinkedNode node = cache.get(key);
        
        if (node == null) {
            return -1;
        }
        
        // move to head because most recently accessed
        makeHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DoublyLinkedNode node = cache.get(key);
        
        if (node == null) {
            DoublyLinkedNode newNode = new DoublyLinkedNode();
            newNode.key = key;
            newNode.value = value;
            
            cache.put(key, newNode);
            add(newNode);
            count++;
            
            if (count > capacity) {
                DoublyLinkedNode removed = removeTail();
                cache.remove(removed.key);
                count--;
            }
        }
        else {
            // already exists
            node.value = value;
            this.makeHead(node);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */