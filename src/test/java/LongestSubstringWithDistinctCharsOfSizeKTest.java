import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import slidingwindow.LongestSubstringWithDistinctCharsOfSizeK;

public class LongestSubstringWithDistinctCharsOfSizeKTest {
    public static Object[][] testData() {
        return new Object[][] {
            {"araaci", 2, 4},
            {"araaci", 1, 2},
            {"cbbebi", 3, 5}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testSol(String s, int k, int answer) {
//        Assertions.assertEquals(answer, LongestSubstringWithDistinctCharsOfSizeK.findLength(s, k));
        Assertions.assertEquals(answer, LongestSubstringWithDistinctCharsOfSizeK.sol1(s, k));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testPractice(String s, int k, int answer) {
        Assertions.assertEquals(answer, LongestSubstringWithDistinctCharsOfSizeK.practice(s, k));
    }
}
