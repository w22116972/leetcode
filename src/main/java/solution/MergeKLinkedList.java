package solution;

import datastructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLinkedList {
    public ListNode sol(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1); // as dummy head
        ListNode current = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, Comparator.comparingInt(node -> node.val));
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            current.next = minNode;
            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
            current = current.next;
        }
        return dummy.next;
    }
}
