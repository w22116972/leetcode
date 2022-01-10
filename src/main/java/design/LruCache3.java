package design;

import java.util.HashMap;

public class LruCache3 {
    class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleLinkedListCache {
        private Node head;
        private Node tail;
        private int size;

        public DoubleLinkedListCache() {
            this.head = new Node(0, 0); // as dummy node to point to head position
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addNodeToTail(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeHeadNode() {
            if (head.next == tail) {
                return null;
            } else {
                Node headNode = head.next;
                removeNode(headNode);
                return headNode;
            }
        }

        public int getSize() {
            return this.size;
        }
    }

    private HashMap<Integer, Node> hashCache;
    private DoubleLinkedListCache linkedListCache;
    private int capacity;

    public LruCache3(int capacity) {
        this.hashCache = new HashMap<>();
        this.linkedListCache = new DoubleLinkedListCache();
        this.capacity = capacity;
    }

    private void reInsertNode(int key) {
        final Node node = hashCache.get(key);
        linkedListCache.removeNode(node);
        linkedListCache.addNodeToTail(node);
    }

    private void addNode(int key, int value) {
        final Node node = new Node(key, value);
        linkedListCache.addNodeToTail(node);
        hashCache.put(key, node);
    }

    private void deleteNode(int key) {
        final Node node = hashCache.get(key);
        linkedListCache.removeNode(node);
        hashCache.remove(key);
    }

    private void removeLeastRecentlyUsedNode() {
        final Node lruNode = linkedListCache.removeHeadNode();
        hashCache.remove(lruNode.key);
    }

    public int get(int key) {
        if (!hashCache.containsKey(key)) {
            return -1;
        } else {
            reInsertNode(key);
            return hashCache.get(key).value;
        }
    }

    public void put(int key, int value) {
        if (hashCache.containsKey(key)) {
            deleteNode(key);
        } else {
            if (this.capacity == linkedListCache.size) {
                removeLeastRecentlyUsedNode();
            }
        }
        addNode(key, value);
    }

}
