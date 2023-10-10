import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class DutchNationalFlagTest {

    public static Object[][] testData() {
        return new Object[][] {
                {new int[]{1, 0, 2, 1, 0}, new int[]{0, 0, 1, 1, 2}},
                {new int[]{2, 2, 0, 1, 2, 0}, new int[]{0, 0, 1, 2, 2, 2}}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void sol(int[] arr, int[] answer) {
        Assertions.assertArrayEquals(answer, DutchNationalFlag.sol(arr));
    }
}
