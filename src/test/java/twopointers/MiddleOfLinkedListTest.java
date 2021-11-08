package twopointers;

import datastructure.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MiddleOfLinkedListTest {
    public static Object[][] testData() {
        final ListNode a = new ListNode(1);
        final ListNode b = new ListNode(2);
        final ListNode c = new ListNode(3);
        final ListNode d = new ListNode(4);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);

        final ListNode a2 = new ListNode(1);
        final ListNode b2 = new ListNode(2);
        final ListNode c2 = new ListNode(3);
        a2.setNext(b2);
        b2.setNext(c2);

        return new Object[][] {
                {a, c},
                {a2, b2}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void sol(ListNode head, ListNode answer) {
        Assertions.assertEquals(answer, MiddleOfLinkedList.sol(head));
    }


}
