package silidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import slidingwindow.SmallestSubarrayGivenSum;

public class SmallestSubarrayGivenSumTest {
    public static Object[][] testData() {
        return new Object[][] {
            {7, new int[]{2, 1, 5, 2, 3, 2}, 2},
            {7, new int[]{2, 1, 5, 2, 8}, 1},
            {8, new int[]{3, 4, 1, 1, 6}, 3}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testSol(int s, int[] arr, int answer) {
        Assertions.assertEquals(answer, SmallestSubarrayGivenSum.sol(s, arr));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testPractice(int s, int[] arr, int answer) {
        Assertions.assertEquals(answer, SmallestSubarrayGivenSum.practice(s, arr));
    }
}
