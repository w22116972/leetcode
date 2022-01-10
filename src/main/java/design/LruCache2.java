package design;

import java.util.HashMap;
import java.util.Map;

public class LruCache2 {
    private class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        Node() {
            this.key = 0;
            this.value = 0;
        }
    }
    private final int capacity;
    private final Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LruCache2(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    private void reInsert(Node n) {
        remove(n);
        add(n);
    }

    private void remove(Node n) {
        Node before = n.prev;
        Node after = n.next;
        before.next = after;
        after.prev = before;
    }

    private void add(Node n) {
        Node after = head.next;
        head.next = n;
        n.prev = head;
        n.next = after;
        after.prev = n;
    }

    public int get(int key) {
        Node n = cache.get(key);
        if (n == null) {
            return -1;
        }
        reInsert(n);
        return n.value;
    }

    public void set(int key, int value) {
        Node n = cache.get(key);
        if (n == null) {
            n = new Node(key, value);
            cache.put(key, n);
            add(n);
        } else {
            n.value = value;
            reInsert(n);
        }
        if (cache.size() > capacity) {
            Node t = tail.prev;
            remove(t);
            cache.remove(t.key);
        }
    }
}
