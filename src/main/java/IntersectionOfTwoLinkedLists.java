import datastructure.ListNode;

public class IntersectionOfTwoLinkedLists {
    public ListNode sol(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;

        while (node1 != node2) {
            if (node1 != null) {
                node1 = node1.next;
            } else {
                node1 = headB;
            }
            if (node2 != null) {
                node2 = node2.next;
            } else {
                node2 = headA;
            }
        }
        return node1; // return node1 or node2 are same
    }
}
