package leetcode;

import java.util.HashMap;

// Use a hashmap and a doubly linked list to implement LRU cache
public class Q146_LRUCache {
    private HashMap<Integer, Node> cache;
    private int capacity;
    // Doubly linked list to maintain the order of usage
    // Assume tail is the most recently used and head is the least recently used
    private Node head;
    private Node tail;

    public Q146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0); // Dummy head
        this.tail = new Node(0, 0); // Dummy tail
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToTail(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);

            // update node
            node.value = value;

            // update linked list
            moveToTail(node);

        } else {
            if (this.cache.size() == this.capacity) {
                remove(head.next);
            }

            Node node = new Node(key, value);
            // update cache
            cache.put(key, node);
            addToTail(node);
        }
    }

    private void remove(Node node) {
        // remove from linked list
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // remove from cache
        cache.remove(node.key);

        // avoid dangling pointers
        node.prev = null;
        node.next = null;
    }

    private void moveToTail(Node node) {
        remove(node);
        cache.put(node.key, node);
        addToTail(node);
    }

    private void addToTail(Node node) {
        // connect tail node with new node
        this.tail.prev.next = node;
        node.prev = this.tail.prev;
        // connect new tail node with dummy tail node
        node.next = this.tail;
        this.tail.prev = node;
    }

    static class Node {
        int value;
        int key;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
