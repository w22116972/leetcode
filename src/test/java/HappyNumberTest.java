import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class HappyNumberTest {
    public static Object[][] testData() {
        return new Object[][] {
                {23, true},
                {12, false}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void sol(int num, boolean answer) {
        Assertions.assertEquals(answer, HappyNumber.sol(num));
    }
}
