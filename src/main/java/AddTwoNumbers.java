import datastructure.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int prog = 0;
        ListNode head = new ListNode();
        ListNode current = head;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + prog;
            if (num >= 10) {
                num -= 10;
                prog = 1;
            } else {
                prog = 0;
            }
            current.next = new ListNode(num);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int num = l1.val + prog;
            if (num >= 10) {
                num -= 10;
                prog = 1;
            } else {
                prog = 0;
            }
            current.next = new ListNode(num);
            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int num = l2.val + prog;
            if (num >= 10) {
                num -= 10;
                prog = 1;
            } else {
                prog = 0;
            }
            current.next = new ListNode(num);
            current = current.next;
            l2 = l2.next;
        }
        if (prog == 1) {
            current.next = new ListNode(prog);
        }
        return head.next;
    }
}
