import datastructure.ListNode;

public class MiddleOfLinkedList {
    // if fast moves 2 and slow moves 1 steps, then fast will reach null and slow reach middle
    // 1, 2, 3, 4
    // if length = even -> (fast -> 3, slow -> 2) -> (fast -> 5, slow = 3) -> fast == null, slow = 3
    // if length = odd -> (fast -> 3, slow -> 2) -> fast.next == null, slow = 2
    public static ListNode sol(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }


}
