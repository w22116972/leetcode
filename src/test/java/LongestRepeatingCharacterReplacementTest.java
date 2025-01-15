import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import solution.LongestRepeatingCharacterReplacement;

import java.util.stream.Stream;


public class LongestRepeatingCharacterReplacementTest {

    @ParameterizedTest(name = "{3}")
    @MethodSource("provideTestCases")
    @DisplayName("Test Longest Repeating Character Replacement")
    void testLongestRepeatingCharacterReplacement(String s, int k, int expected, String description) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        Assertions.assertEquals(expected, solution.characterReplacement(s, k), description);
    }

    private static Stream<Arguments> provideTestCases() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            sb.append((char) ('A' + (i % 26))); // Repeats A-Z
        }
        String largeInputForWorstCase = sb.toString();

        return Stream.of(
                Arguments.of("", 2, 0, "Test empty string"),
                Arguments.of("A", 0, 1,"Test Single Character with No Replacements"),
                Arguments.of("AAAA", 2, 4, "Test all characters are the same"),
                Arguments.of("ABCD", 2, 3, "Test all characters are different"),
                Arguments.of("A", 2, 1, "Test the length of substring is less than k"),
                Arguments.of("AB", 1, 2, "Test the length of substring is equal to k"),
                Arguments.of("AB", 0, 1, "Test the length of substring is greater than k"),
                Arguments.of("ABABAB", 2, 5, "Test alternating characters"),
                Arguments.of("AABABBA", 1, 4, "Test single replacement for longest substring"),
                Arguments.of("ABC", 3, 3, "Test all characters require replacement"),
                Arguments.of(largeInputForWorstCase, 10_000, 13847 + 1, "Test performance with all unique characters and limited replacements")
        );
    }
}
