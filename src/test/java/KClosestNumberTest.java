import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import topkelements.KClosestNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KClosestNumberTest {

    public static Object[][] testData() {
        return new Object[][] {
                {new ArrayList<>(List.of(5, 6, 7, 8, 9)), 3, 7, new ArrayList<>(List.of(6, 7, 8))},
                {new ArrayList<>(List.of(2, 4, 5, 6, 9)), 3, 6, new ArrayList<>(List.of(4, 5, 6))},
                {new ArrayList<>(List.of(2, 4, 5, 6, 9)), 3, 10, new ArrayList<>(List.of(5, 6, 9))}
        };
    }

    public static Object[][] testData2() {
        return new Object[][] {
                {new int[]{5, 6, 7, 8, 9}, 3, 7, new ArrayList<>(List.of(6, 7, 8))},
                {new int[]{2, 4, 5, 6, 9}, 3, 6, new ArrayList<>(List.of(4, 5, 6))},
                {new int[]{2, 4, 5, 6, 9}, 3, 10, new ArrayList<>(List.of(5, 6, 9))}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void minHeapTest(List<Integer> arr, int k, int x, List<Integer> answer) {
        Assertions.assertEquals(answer, KClosestNumber.bruteForce(arr, k, x));
    }

    @ParameterizedTest
    @MethodSource("testData2")
    public void binarySearchTest(int[] arr, int k, int x, List<Integer> answer) {
        Assertions.assertEquals(answer, KClosestNumber.binarySearchSol(arr, k, x));
    }

    @ParameterizedTest
    @MethodSource("testData2")
    public void twoPointersTest(int[] arr, int k, int x, List<Integer> answer) {
        Assertions.assertEquals(answer, KClosestNumber.twoPointersSol(arr, k, x));
    }
}
