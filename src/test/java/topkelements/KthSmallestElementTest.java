package topkelements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import slidingwindow.AverageOfContiguousSubarrayOfSizeK;

public class KthSmallestElementTest {
    public static Object[][] testData() {
        return new Object[][] {
                {new int[] { 1, 5, 12, 2, 11, 5 }, 3, 5},
                {new int[] {1, 5, 12, 2, 11, 5}, 4, 5},
                {new int[] {5, 12, 11, -1, 12}, 3, 11}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void solTest(int[] arr, int k, int answer) {
        Assertions.assertEquals(answer, KthSmallestElement.minHeapSol(arr, k));
    }
}
