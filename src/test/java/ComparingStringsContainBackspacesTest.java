import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ComparingStringsContainBackspacesTest {
    public static Object[][] testData() {
        return new Object[][] {
                {"xy#z", "xzz#", true},
                {"xy#z", "xyz#", false},
                {"xp#", "xyz##", true},
                {"xywrrmp", "xywrrmu#p", true}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void solTest(String s1, String s2, Boolean answer) {
        Assertions.assertEquals(answer, ComparingStringsContainBackspaces.sol(s1, s2));
    }
}
