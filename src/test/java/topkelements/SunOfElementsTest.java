package topkelements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class SunOfElementsTest {
    public static Object[][] testData() {
        return new Object[][] {
                {new int[]{1, 3, 12, 5, 15, 11}, 3, 6, 23},
                {new int[]{3, 5, 8, 7}, 1, 4, 12}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void minHeapTest(int[] arr, int k1, int k2, int answer) {
        Assertions.assertEquals(answer, SumOfElements.sol(arr, k1, k2));
    }
}
