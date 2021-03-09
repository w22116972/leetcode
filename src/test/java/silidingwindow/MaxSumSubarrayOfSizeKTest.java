package silidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import slidingwindow.MaxSumSubarrayOfSizeK;

public class MaxSumSubarrayOfSizeKTest {

    public static Object[][] testData() {
        return new Object[][] {
            {3, new int[]{2, 1, 5, 1, 3, 2}, 9},
            {2, new int[]{2, 3, 4, 1, 5}, 7}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void solTest(int k, int[] arr, int answer) {
        Assertions.assertEquals(answer, MaxSumSubarrayOfSizeK.findMaxSumSubArray(k, arr));
        Assertions.assertEquals(answer, MaxSumSubarrayOfSizeK.sol2(k, arr));
    }
}
