import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import topkelements.KClosestPointToOrigin;
import topkelements.Point;

import java.util.ArrayList;
import java.util.List;

public class KClosestPointToOriginTest {
    public static Object[][] testData() {
        return new Object[][] {
                {new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) }, 2, new ArrayList<>(List.of(new Point(1, 3), new Point(2, -1)))},
                {new Point[] { new Point(1, 2), new Point(1, 3)}, 1, new ArrayList<>(List.of(new Point(1, 2)))}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void solTest(Point[] points, int k, List<Point> answer) {
        Assertions.assertEquals(answer, KClosestPointToOrigin.sol(points, k));
    }
}
