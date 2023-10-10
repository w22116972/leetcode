import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import slidingwindow.AverageOfContiguousSubarrayOfSizeK;

public class AverageOfContiguousSubarrayOfSizeKTest {

    public static Object[][] testData() {
        return new Object[][] {
            {5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, new double[]{2.2, 2.8, 2.4, 3.6, 2.8}}
//            {}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void solTest(int k, int[] arr, double[] answer) {
        Assertions.assertArrayEquals(answer, AverageOfContiguousSubarrayOfSizeK.sol(k, arr));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void practiceTest(int k, int[] arr, double[] answer) {
        Assertions.assertArrayEquals(answer, AverageOfContiguousSubarrayOfSizeK.practice(k, arr));
    }

}
