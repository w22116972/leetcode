package design;

import java.util.*;

// use doubly linked list and TreeMap
public class MaxStack {

    private final DoublyLinkedList doublyLinkedList;
    private final TreeMap<Integer, LinkedList<Node>> treeMap;

    public MaxStack() {

        doublyLinkedList = new DoublyLinkedList();
        treeMap = new TreeMap<>();
    }

    public void push(int x) {
        final Node addedNode = doublyLinkedList.add(x);
        if (!treeMap.containsKey(x)) {
            treeMap.put(x, new LinkedList<>());
        }
        treeMap.get(x).add(addedNode);
    }

    public int pop() {
        final int poppedValue = doublyLinkedList.pop();
        final LinkedList<Node> nodes = treeMap.get(poppedValue);
        nodes.removeLast();
        if (nodes.isEmpty()) {
            treeMap.remove(poppedValue);
        }
        return poppedValue;
    }

    public int top() {
        return doublyLinkedList.peek();
    }

    public int peekMax() {
        return treeMap.lastKey();
    }

    public int popMax() {
        int maxValue = peekMax();
        final LinkedList<Node> nodes = treeMap.get(maxValue);
        final Node lastNode = nodes.removeLast();
        doublyLinkedList.unlink(lastNode);
        if (nodes.isEmpty()) {
            treeMap.remove(maxValue);
        }
        return maxValue;
    }

    static class Node {
        int val;
        Node prev, next;
        public Node(int v) {val = v;}
    }

    static class DoublyLinkedList {
        Node head, tail;

        public DoublyLinkedList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        public Node add(int val) {
            Node x = new Node(val);
            x.next = tail;
            x.prev = tail.prev;
            tail.prev = tail.prev.next = x;
            return x;
        }

        // pop last element
        public int pop() {
            return unlink(tail.prev).val;
        }

        // check last element
        public int peek() {
            return tail.prev.val;
        }

        public Node unlink(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
    }
}
