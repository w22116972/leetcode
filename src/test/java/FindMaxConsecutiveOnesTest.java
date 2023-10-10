import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


public class FindMaxConsecutiveOnesTest {

    private final FindMaxConsecutiveOnes findMaxConsecutiveOnes = new FindMaxConsecutiveOnes();

    public static Object[][] testData() {
        return new Object[][] {
                {new int[]{1,1,0,1,1,1}, 3},
                {new int[]{1,0,1,1,0,1}, 2}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void sol(int[] nums, int answer) {
        Assertions.assertEquals(answer, findMaxConsecutiveOnes.sol(nums));
    }
}
