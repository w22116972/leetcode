package cyclicsort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import slidingwindow.FruitsToBaskets;

public class CyclicSortTest {
    public static Object[][] testData() {
        return new Object[][] {
                {new int[]{3, 1, 5, 4, 2}, new int[]{1, 2, 3, 4, 5}},
                {new int[]{2, 6, 4, 3, 1, 5}, new int[]{1, 2, 3, 4, 5, 6}},
                {new int[]{1, 5, 6, 4, 3, 2}, new int[]{1, 2, 3, 4, 5, 6}}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void solTest(int[] arr, int[] answer) {
        Assertions.assertArrayEquals(answer, CyclicSort.sol(arr));
    }

}
