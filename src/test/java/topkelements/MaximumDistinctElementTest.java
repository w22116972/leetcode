package topkelements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class MaximumDistinctElementTest {

    public static Object[][] testData() {
        return new Object[][] {
                {new int[]{7, 3, 5, 8, 5, 3, 3}, 2, 3},
                {new int[]{3, 5, 12, 11, 12}, 3, 2},
                {new int[]{1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5}, 2, 3}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void minHeapTest(List<Integer> arr, int k, int x, List<Integer> answer) {
        Assertions.assertEquals(answer, KClosestNumber.bruteForce(arr, k, x));
    }
}
