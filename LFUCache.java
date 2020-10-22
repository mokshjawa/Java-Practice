class LFUCache {
    
    class DoublyLinkedNode {
        int key;
        int value;
        int frequency = 1;
        DoublyLinkedNode previous;
        DoublyLinkedNode next;
    }
    
    class DoublyLinkedList {
        DoublyLinkedNode head;
        DoublyLinkedNode tail;
        int size;
        
        public DoublyLinkedList() {
            size = 0;
            head = new DoublyLinkedNode();
            tail = new DoublyLinkedNode();
            head.previous = null;
            tail.next = null;
            head.next = tail;
            tail.previous = head;
        }
        
        public void remove(DoublyLinkedNode node) {
            DoublyLinkedNode before = node.previous;
            DoublyLinkedNode after = node.next;

            before.next = after;
            after.previous = before;
            size--;
        }
        
        public void add(DoublyLinkedNode node) {
            node.previous = head;
            node.next = head.next;

            head.next.previous = node;
            head.next = node;
            size++;
        }

        public void makeHead(DoublyLinkedNode node) {
            remove(node);
            add(node);
        }

        public DoublyLinkedNode removeTail() {
            DoublyLinkedNode node = tail.previous;
            remove(node);
            return node;
        }
    }
    
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;
    private Map<Integer, DoublyLinkedNode> cache = new HashMap<>();
    private Map<Integer, DoublyLinkedList> frequencyMap = new HashMap<>();
    private int count;
    private int capacity;
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        minFreq = 0;
        
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

        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        
        DoublyLinkedNode node = cache.get(key);
        
        if (node == null) {
            count++;
            
            if (count > capacity) {
                DoublyLinkedList minFreqNodes = frequencyMap.get(minFreq);
                DoublyLinkedNode removed = minFreqNodes.removeTail();
                cache.remove(removed.key);
                count--;
            }
            
            minFreq = 1;
            DoublyLinkedNode newNode = new DoublyLinkedNode();
            newNode.key = key;
            newNode.value = value;
            
            DoublyLinkedList newNodes = frequencyMap.getOrDefault(minFreq, new DoublyLinkedList());
            newNodes.add(newNode);
            frequencyMap.put(1, newNodes);
            cache.put(key, newNode);
        }
        else {
            // already exists
            node.value = value;
            // this.makeHead(node);
            update(node);
        }
    }
    
    public void update(DoublyLinkedNode node) {
        int freq = node.frequency;
        DoublyLinkedList nodes = frequencyMap.get(freq);
        nodes.remove(node);
        
        if (freq == minFreq && nodes.size == 0) {
            minFreq++;
        }
        
        node.frequency++;
        DoublyLinkedList newNodes = frequencyMap.getOrDefault(node.frequency, new DoublyLinkedList());
        newNodes.add(node);
        frequencyMap.put(node.frequency, newNodes);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */