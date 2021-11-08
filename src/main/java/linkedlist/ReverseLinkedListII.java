package linkedlist;

import datastructure.ListNode;

public class ReverseLinkedListII {
    // left and right are 1-based instead of 0-based
    // e.g. left = 1 == first node
    public static ListNode sol(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        // use current for iterating, and use head for returning linked list
        ListNode current = head;
        // use prev for storing left part without reversing
        ListNode prev = null;
        // move current to left - 1
        // current -> left -> ...
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.getNext();
        }


        return head;
    }




}
