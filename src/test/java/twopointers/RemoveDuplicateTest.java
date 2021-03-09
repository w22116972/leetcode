package twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class RemoveDuplicateTest {

    public static Object[][] testData() {
        return new Object[][] {
            {new int[]{2, 3, 3, 3, 6, 9, 9}, 4},
            {new int[]{2, 2, 2, 11}, 2}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void sol(int[] arr, int answer) {
        Assertions.assertEquals(answer, RemoveDuplicate.sol(arr));
    }

}
