# Unit Test

## How to effectively manage test cases

Assume we have 2 leetcode for the same question, called `SolByA`, `SolByB`

```java
public class ProblemXXXTest {
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("", 2, 0, "Test empty case"),
                Arguments.of("AAAA", 2, 4, "Test edge case 1"),
                Arguments.of("ABCD", 2, 3, "Test edge case 2")
                // ...
        );
    }
    
    @ParameterizedTest(name = "{3}") // Dynamically sets the test name to the description provided in the Arguments.
    @MethodSource("provideTestCases")
    @DisplayName("Test Problem Solution Implemented by A")
    void testSolutionByA(String s, int k, int expected, String description) {
        SolByA solByA = new SolByA();
        Assertions.assertEquals(expected, solByA.sol(s, k), description);
    }

    @ParameterizedTest(name = "{3}") 
    @MethodSource("provideTestCases")
    @DisplayName("Test Problem Solution Implemented by B")
    void testSolutionByB(String s, int k, int expected, String description) {
        SolByB solByB = new SolByB();
        Assertions.assertEquals(expected, solByB.sol(s, k), description);
    }
}
```
