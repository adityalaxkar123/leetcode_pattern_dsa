class Node {
    int key, val;
    Node prev, next;

    Node(int key, int val) {
        this.val = val;
        this.key = key;
        prev = null;
        next = null;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> mp2 = new HashMap<>();
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!mp2.containsKey(key))
            return -1;
        Node p = mp2.get(key);
        if (p == tail)
            return tail.val;
        else if (p == head) {
            head = p.next;
            head.prev = null;
        } else {
            p.prev.next = p.next;
            p.next.prev = p.prev;
        }
        tail.next = p;
        p.prev = tail;
        p.next = null;
        tail = tail.next;

        return mp2.get(key).val;
    }

    public void put(int key, int value) {
        if (mp2.containsKey(key)) {
            Node p = mp2.get(key);
            p.val = value;
            mp2.put(key, p);
            if (p == tail)
                return;
            if (p == head) {
                head = p.next;
                head.prev = null;
                p.next = null;
                tail.next = p;
                p.prev = tail;
                tail = tail.next;
            } else {
                p.prev.next = p.next;
                p.next.prev = p.prev;
                tail.next = p;
                p.prev = tail;
                p.next = null;
                tail = tail.next;
            }

        } else if (mp2.size() < capacity) {
            Node p = new Node(key, value);
            mp2.put(key, p);
            if (head == null && tail == null)
                head = tail = p;
            else {
                tail.next = p;
                p.prev = tail;
                tail = tail.next;
            }
        } else {
            mp2.remove(head.key);
            if (head.next == null && head.prev == null) {
                head = tail = null;
            } else {
                Node temp = head.next;
                head.next = null;
                head = temp;
                head.prev = null;
            }
            Node n = new Node(key, value);
            mp2.put(key, n);
            if (head == null && tail == null)
                head = tail = n;
            else {
                tail.next = n;
                n.prev = tail;
                tail = tail.next;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */