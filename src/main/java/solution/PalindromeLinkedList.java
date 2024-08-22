package solution;

import datastructure.ListNode;

public class PalindromeLinkedList {

    // 1. use fast/slow pointers to find the middle of the linked list
    // 2. reverse the last half of linked list from the middle node
    // 3.
    public static boolean sol(ListNode head) {
        ListNode middleOfLinkedList = findMiddleOfLinkedList(head);
        ListNode headOfReversedLinkedList = getHeadOfReversedLinkedList(middleOfLinkedList);
        return isTwoLinkedListEqual(middleOfLinkedList, headOfReversedLinkedList);
    }

    private static ListNode findMiddleOfLinkedList(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    private static ListNode getHeadOfReversedLinkedList(ListNode head) {
        ListNode prevNode = null;
        ListNode iterNode = head;
        while (iterNode != null) {
            ListNode nextNode = iterNode.next;
            iterNode.next = prevNode;

            prevNode = iterNode;
            iterNode = nextNode;
        }
        return prevNode;
    }

    private static boolean isTwoLinkedListEqual(ListNode head1, ListNode head2) {

        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
}
