package cyclicsort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import slidingwindow.FruitsToBaskets;

public class FindAMissingNumberTest {


    public static Object[][] testData() {
        return new Object[][] {
                {new int[]{4, 0, 3, 1}, 2},
                {new int[]{8, 3, 5, 2, 4, 6, 0, 1}, 7}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void solTest(int[] arr, int answer) {
        Assertions.assertEquals(answer, FindAMissingNumber.mathSol(arr));
    }


    @ParameterizedTest
    @MethodSource("testData")
    public void testPractice(int[] arr, int answer) {
        Assertions.assertEquals(answer, FindAMissingNumber.cyclicSol(arr));
    }
}
