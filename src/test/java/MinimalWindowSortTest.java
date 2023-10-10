import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MinimalWindowSortTest {
    public static Object[][] testData() {
        return new Object[][] {
                {new int[]{1, 2, 5, 3, 7, 10, 9, 12}, 5},
                {new int[]{1, 3, 2, 0, -1, 7, 10}, 5},
                {new int[]{1, 2, 3}, 0},
                {new int[]{3, 2, 1}, 3}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void sol(int[] arr, int answer) {
        Assertions.assertEquals(answer, MinimalWindowSort.sol(arr));
    }
}
