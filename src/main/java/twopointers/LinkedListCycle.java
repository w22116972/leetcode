package twopointers;

import datastructure.ListNode;

public class LinkedListCycle {
    // if pointer reaches null then it doesn't have cycle
    // if 2 pointers meet again, then it has cycle
    public static boolean sol(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
