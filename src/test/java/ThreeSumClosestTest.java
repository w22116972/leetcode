import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
//Given an array of unsorted numbers and a target number,
// find a triplet sum in the array whose sum is as close to the target number as possible
public class ThreeSumClosestTest {
    public static Object[][] testData() {
        return new Object[][] {
            {new int[]{-2, 0, 1, 2}, 2, 1},
            {new int[]{-3, -1, 1, 2}, 1, 0},
            {new int[]{1, 0, 1, 1}, 100, 3}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void sol(int[] arr, int target, int answer) {
        Assertions.assertEquals(answer, ThreeSumClosest.sol(arr, target));
    }
}
