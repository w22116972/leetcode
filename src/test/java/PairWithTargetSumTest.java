import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class PairWithTargetSumTest {

    public static Object[][] testData() {
        return new Object[][] {
            {new int[]{1, 2, 3, 4, 6}, 6, new int[]{1, 3}},
            {new int[]{2, 5, 9, 11}, 11, new int[]{0, 2}}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void hashTableTest(int[] arr, int target, int[] answer) {
        Assertions.assertArrayEquals(answer, PairWithTargetSum.hashTable(arr, target));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void traverseOppositeDirectionsTest(int[] arr, int target, int[] answer) {
        Assertions.assertArrayEquals(answer, PairWithTargetSum.traverseOppositeDirections(arr, target));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void traverseSameDirectionsTest(int[] arr, int target, int[] answer) {
        Assertions.assertArrayEquals(answer, PairWithTargetSum.traverseSameDirection(arr, target));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void practiceTest(int[] arr, int target, int[] answer) {
        Assertions.assertArrayEquals(answer, PairWithTargetSum.practice(arr, target));
    }
}
