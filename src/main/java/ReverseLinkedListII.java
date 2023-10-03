import datastructure.ListNode;

public class ReverseLinkedListII {
    // left and right are 1-based instead of 0-based
    // e.g. left = 1 == first node
    public static ListNode sol(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        // use current for iterating, and use head for returning linked list
        ListNode currentNode = head;
        // prev: last node of left non-reversing part (current_node will be reversed)
        ListNode prevNode = null;
        // move current to left - 1
        // current -> left -> ...
        for (int i = 0; currentNode != null && i < left - 1; i++) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        // now current_node is at starting node for reversing
        // now prev_node is last node of left non-reversing part
        ListNode lastNodeOfLeftNonReverse = prevNode;
        // Start reverse
        ListNode nextNode = null;
        for (int i = 0; currentNode != null && i < right - left + 1; i++) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;

            prevNode = currentNode;
            currentNode = nextNode;
        }
        return head;
    }

    public static ListNode reverseBetweenRecursively(ListNode head, int left, int right) {
        // No need to reverse if left == right
        if (left == right) {
            return head;
        } else if (left == 1) {  // if only need to reverse FIRST n (=|right|) nodes
            ListNode reveredListHead = reverseBetweenRecursively(head.next, 1, right - 1);
            ListNode nodeAtRightPlusOne = head.next.next;
            head.next.next = head;
            head.next = nodeAtRightPlusOne;
            return reveredListHead;
        } else {  // head itself doesn't need to be reversed
            head.next = reverseBetweenRecursively(head.next, left - 1, right - 1);
            return head;
        }
//        return null;
    }
}
