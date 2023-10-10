import datastructure.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class StartingNodeOfCycleTest {
    public static Object[][] testData() {
        final ListNode a = new ListNode(1);
        final ListNode b = new ListNode(2);
        final ListNode c = new ListNode(3);
        final ListNode d = new ListNode(4);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(b);
        return new Object[][] {
                {a, b}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void sol(ListNode head, ListNode answer) {
        Assertions.assertEquals(answer, StartingNodeOfCycle.sol(head));
    }
}
