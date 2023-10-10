import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class SquareSortedArrayTest {

    public static Object[][] testData() {
        return new Object[][] {
            {new int[]{-2, -1, 0, 2, 3}, new int[]{0, 1, 4, 4, 9}},
            {new int[]{-3, -1, 0, 1, 2}, new int[]{0, 1, 1, 4, 9,}}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void sol2(int[] arr, int[] answer) {
        Assertions.assertArrayEquals(answer, SquareSortedArray.squareArray(arr));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void sol(int[] arr, int[] answer) {
        Assertions.assertArrayEquals(answer, SquareSortedArray.sol(arr));
    }


    @ParameterizedTest
    @MethodSource("testData")
    public void practice(int[] arr, int[] answer) {
        Assertions.assertArrayEquals(answer, SquareSortedArray.practice(arr));
    }
}
