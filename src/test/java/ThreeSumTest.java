import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.stream.Stream;

public class ThreeSumTest {

    @ParameterizedTest(name = "{2}")
    @MethodSource("provideTestCases")
    @DisplayName("Test 3 sum")
    void testThreeSum(int[] nums, List<List<Integer>> expected, String description) {

    }


    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{}, List.of(), "Test empty input"),
                Arguments.of(new int[]{1}, List.of(), "Test less than 3 element input"),
                Arguments.of(new int[]{-1,0,1,2,-1,-4}, List.of(List.of(-1,-1,2), List.of(-1,0,1)), "Test base case"),
                Arguments.of(new int[]{0,1,1}, List.of(), "Test no solution"),
                Arguments.of(new int[]{0,0,0,0}, List.of(List.of(0,0,0)), "Test all zeros and expect one solution"),
                Arguments.of(new int[]{-1, -1, 0, 0, 0, 1, 1, -1}, List.of(List.of(-1,0,1)), "Test only one unique solution")

        );
    }
}
