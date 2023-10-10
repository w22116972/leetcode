import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import topkelements.FrequencySort;

import java.util.List;

public class FrequencySortTest {
    public static Object[][] testData() {
        return new Object[][] {
                {"Programming","rrggmmPiano"},
                {"abcbab", "bbbaac"}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void minHeapTest(String input, String answer) {
        Assertions.assertEquals(answer, FrequencySort.sol(input));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void grokkingTest(String input, String answer) {
        Assertions.assertEquals(answer, FrequencySort.grokkingSol(input));
    }
}
