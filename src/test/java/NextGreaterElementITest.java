import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class NextGreaterElementITest {

    private final NextGreaterElementI nextGreaterElementI = new NextGreaterElementI();

    public static Object[][] testData() {
        return new Object[][] {
                {new int[]{4,1,2}, new int[]{1,3,4,2}, new int[]{-1,3,-1}},
                {new int[]{2,4}, new int[]{1,2,3,4}, new int[]{3,-1}}
        };
    }


    @ParameterizedTest
    @MethodSource("testData")
    public void testExample1(int[] nums1, int[] nums2, int[] answer) {

        int[] result = nextGreaterElementI.nextGreaterElement(nums1, nums2);
        Assertions.assertArrayEquals(answer, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testExample2(int[] nums1, int[] nums2, int[] answer) {
        int[] result = nextGreaterElementI.nextGreaterElement(nums1, nums2);
        Assertions.assertArrayEquals(answer, result);
    }


}
