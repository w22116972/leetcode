import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import topkelements.TopKFrequentNumber;

import java.util.List;

public class TopKFrequentNumberTest {
    public static Object[][] testData() {
        return new Object[][] {
                {new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2, List.of(11, 12)},
//                {new int[] { 5, 12, 11, 3, 11 }, 2}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void minHeapTest(int[] arr, int k, List<Integer> answer) {
        Assertions.assertTrue(answer.containsAll(TopKFrequentNumber.hashMapWithHeapSol(arr, k)));
    }
}
