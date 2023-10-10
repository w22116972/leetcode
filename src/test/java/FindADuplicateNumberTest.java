import cyclicsort.FindADuplicateNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import slidingwindow.FruitsToBaskets;

public class FindADuplicateNumberTest {

    public static Object[][] testData() {
        return new Object[][] {
                {new int[]{1, 4, 4, 3, 2}, 4},
                {new int[]{2, 1, 3, 3, 5, 4}, 3},
                {new int[]{2, 4, 1, 4, 4}, 4}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void solTest(int[] arr, int answer) {
        Assertions.assertEquals(answer, FindADuplicateNumber.cyclicSol(arr));
    }


    @ParameterizedTest
    @MethodSource("testData")
    public void testPractice(int[] arr, int answer) {
        Assertions.assertEquals(answer, FindADuplicateNumber.flipNegativeSol(arr));
    }
}
