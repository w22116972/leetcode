package linkedlist;

import datastructure.ListNode;

import java.util.Queue;
import java.util.Set;

public class ReversedLinkedList {

    // iterative
    public static ListNode sol(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.setNext(prev);

            prev = head;
            head = next;
        }
        return prev;
    }

    // output reversed head
    public ListNode recursiveSol(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode reversedHead = recursiveSol(head.next);

        head.next.next = head;

        head.next = null;

        return reversedHead;
    }
}
