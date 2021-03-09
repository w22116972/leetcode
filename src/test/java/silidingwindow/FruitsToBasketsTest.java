package silidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import slidingwindow.FruitsToBaskets;

public class FruitsToBasketsTest {

    public static Object[][] testData() {
        return new Object[][] {
            {new char[]{'A', 'B', 'C', 'A', 'C'}, 3},
            {new char[]{'A', 'B', 'C', 'B', 'B', 'C'}, 5}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void solTest(char[] arr, int answer) {
        Assertions.assertEquals(answer, FruitsToBaskets.sol1(arr));
    }
}
