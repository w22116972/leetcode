import datastructure.ListNode;

public class RemoveNthNodeFromEndOfLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // create dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // we need prev node of Nth node from end -> so we need to find N+1-th from end
        // N+1-th -> Nth -> N+1-th.next.next
        // prev.next = prev.next.next
        ListNode nPlus1thNodeFromEnd = findNthNodeFromEnd(dummy, n + 1);
        nPlus1thNodeFromEnd.next = nPlus1thNodeFromEnd.next.next;
        return dummy.next;
    }

    public ListNode findNthNodeFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 walks k steps
        while (k-- > 0) {
            p1 = p1.next;
        }
        // p2 and p1 walks n-k steps
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        final RemoveNthNodeFromEndOfLinkedList sol = new RemoveNthNodeFromEndOfLinkedList();
        final ListNode n1 = new ListNode(1);
        final ListNode n2 = new ListNode(2);
        n1.next = n2;
        final ListNode n3 = new ListNode(3);
        n2.next = n3;
        final ListNode n4 = new ListNode(4);
        n3.next = n4;

        ListNode dummy = new ListNode(-1);
        dummy.next = n1;

        System.out.println("findNthNodeFromEnd(n1, 1).val = " + sol.findNthNodeFromEnd(dummy, 1).val);
    }
}
