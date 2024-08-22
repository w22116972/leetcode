package solution;

import datastructure.ListNode;

public class LinkedListCycle {
    // if pointer reaches null then it doesn't have cycle
    // if 2 pointers meet again, then it has cycle
    public static boolean sol(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
