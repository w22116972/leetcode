package twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class TripletSumToZeroTest {

    public static Object[][] testData() {
        return new Object[][] {
            {new int[] {-3, 0, 1, 2, -1, 1, -2}, List.of(List.of(-3, 1, 2),  List.of(-2, 0, 2), List.of(-2, 1, 1), List.of(-1, 0, 1))},
            {new int[]{-5, 2, -1, -2, 3}, List.of(List.of(-5, 2, 3), List.of(-2, -1, 3))}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void sol(int[] arr, List<List<Integer>> answer) {
        Assertions.assertIterableEquals(answer, TripletSumToZero.sol(arr));
    }
}
