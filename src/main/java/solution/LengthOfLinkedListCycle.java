package solution;

import datastructure.ListNode;

public class LengthOfLinkedListCycle {
    // if slow pointer stay at the index which meets faster pointer again,
    // then we calculate the length when next time slow pointer walk here (since slow pointer take 1 step every time)
    public static Integer sol(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return getLengthOfCycle(slow);
            }
        }
        return 0;
    }

    public static int getLengthOfCycle(ListNode node) {
        ListNode nodeAtStart = node;
        int cycleLength = 0;
        do {
            node = node.getNext();
            cycleLength++;
        } while (nodeAtStart != node);
        return cycleLength;
    }
}
