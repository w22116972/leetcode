import datastructure.ListNode;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import leetcode.LC_876_MiddleOfLinkedList;

public class LC876MiddleOfLinkedListTest {
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
        val sol = new LC_876_MiddleOfLinkedList();
        Assertions.assertEquals(answer, sol.middleNode(head));
    }


}
