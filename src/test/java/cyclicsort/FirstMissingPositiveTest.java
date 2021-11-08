package cyclicsort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class FirstMissingPositiveTest {
    public static Object[][] testData() {
        return new Object[][] {
                {new int[]{1, 2, 0}, 3},
                {new int[]{3, 4, -1, 1}, 2},
                {new int[]{7, 8, 9}, 1},
                {new int[]{-5}, 1}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void solTest(int[] arr, int answer) {
        Assertions.assertEquals(answer, FirstMissingPositive.sol(arr));
    }
}
