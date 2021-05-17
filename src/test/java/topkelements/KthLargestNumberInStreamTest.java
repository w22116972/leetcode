package topkelements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class KthLargestNumberInStreamTest {
    public static Object[][] testData() {
        return new Object[][] {
                {new KthLargestNumberInStream(new int[] {3, 1, 5, 12, 2, 11}, 4)}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void minHeapTest(KthLargestNumberInStream kthLargestNumberInStream) {
        Assertions.assertEquals(5, kthLargestNumberInStream.add(6));
        Assertions.assertEquals(6, kthLargestNumberInStream.add(13));
        Assertions.assertEquals(6, kthLargestNumberInStream.add(4));
    }
}
