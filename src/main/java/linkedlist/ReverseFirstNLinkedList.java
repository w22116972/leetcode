package linkedlist;

import datastructure.ListNode;

public class ReverseFirstNLinkedList {

    // 反轉後會指向的節點
    private ListNode nextNode = null;

    public ListNode recursivelyReverse(ListNode head, int n) {
        if (n == 1) {


        }
        // TODO
        return null;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        } else if (left == 1) {  // reverse first N nodes
            ListNode headOfReversedLinkedList = reverseBetween(head.next, 1, right-1);
            ListNode temp = head.next.next;
            head.next.next = head;
            head.next = temp;
            return headOfReversedLinkedList;
        } else {
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }
    }
}
