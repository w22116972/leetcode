import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import topkelements.ConnectRopes;

import java.util.ArrayList;
import java.util.List;

public class ConnectRopesTest {

    public static Object[][] testData() {
        return new Object[][] {
                {new int[] { 1, 3, 11, 5 }, 33},
                {new int[] { 3, 4, 5, 6 }, 36},
                {new int[] { 1, 3, 11, 5, 2 }, 42}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void minHeapTest(int[] arr, int answer) {
        Assertions.assertEquals(answer, ConnectRopes.minHeapSol(arr));
    }
}
