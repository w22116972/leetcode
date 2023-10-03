import datastructure.ListNode;

// Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
public class StartingNodeOfCycle {
    public static ListNode sol(ListNode head) {
        int cycleLength = LengthOfLinkedListCycle.sol(head);
        ListNode fast = head;
        ListNode slow = head;
        while (cycleLength > 0) {
            fast = fast.getNext();
            cycleLength--;
        }

        while (fast != slow) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return slow;
    }

    public static ListNode test(ListNode head) {
        // 1. use fast / slow to find meet node
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                meet = slow;
                break;
            }
        }
        // 2. use new pointer starting from head and another new pointer starting from meet node,
        // when they meet again, this position will be starting node of cycle
        ListNode start = head;
        while (meet != null && start != null && meet != start) {
            meet = meet.next;
            start = start.next;
        }
        return meet;
    }
}
