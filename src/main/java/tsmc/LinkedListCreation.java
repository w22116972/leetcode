package tsmc;

public class LinkedListCreation {
    // Nested class for SinglyLinkedListNode
    public static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Main function to generate the new linked list
    public SinglyLinkedListNode generateNewList(SinglyLinkedListNode head) {
        SinglyLinkedListNode newHead = null, newTail = null;

        while (head != null) {
            SinglyLinkedListNode[] result = extractOddNodes(head);
            SinglyLinkedListNode oddNodes = result[0];
            head = result[1];

            if (newHead == null) {
                newHead = oddNodes;
                newTail = getTail(oddNodes);
            } else {
                newTail.next = oddNodes;
                newTail = getTail(oddNodes);
            }
        }

        return newHead;
    }

    // Function to extract nodes at odd positions
    private SinglyLinkedListNode[] extractOddNodes(SinglyLinkedListNode head) {
        SinglyLinkedListNode oddHead = null, oddTail = null;
        SinglyLinkedListNode current = head, prev = null;
        boolean isOdd = true;

        while (current != null) {
            if (isOdd) {
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }

                if (prev != null) {
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }

            current = current.next;
            isOdd = !isOdd;
        }

        if (oddTail != null) {
            oddTail.next = null;
        }

        return new SinglyLinkedListNode[]{oddHead, head};
    }

    // Helper function to get the tail of a linked list
    private SinglyLinkedListNode getTail(SinglyLinkedListNode head) {
        while (head != null && head.next != null) {
            head = head.next;
        }
        return head;
    }
}
