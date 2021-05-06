package topkelements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class TopKElementsTest {

    public static Object[][] testData() {
        return new Object[][] {
                {new int[]{3, 1, 5, 12, 2, 11}, 3, new ArrayList<Integer>(List.of(5, 12, 11))},
                {new int[]{5, 12, 11, -1, 12}, 3, new ArrayList<Integer>(List.of(12, 11, 12))}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void solTest(int[] testData, int testK, ArrayList<Integer> answer) {
        Assertions.assertTrue(answer.containsAll(TopKElements.minHeapSol(testData, testK)));
    }

}
