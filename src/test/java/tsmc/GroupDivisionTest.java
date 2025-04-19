package tsmc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GroupDivisionTest {

    @Test
    @DisplayName("Example test case with levels [1, 4, 7, 3, 4] and maxSpread 2")
    void testSol() {
        GroupDivision groupDivision = new GroupDivision();

        // Example test case
        int n = 5;
        int[] levels = {1, 4, 7, 3, 4};
        int maxSpread = 2;
        int expected = 3;
        assertEquals(expected, groupDivision.sol(n, levels, maxSpread), 
            "Failed on example test case with levels [1, 4, 7, 3, 4] and maxSpread 2");
    }

    @Test
    @DisplayName("Edge case: no students (empty levels array)")
    void testEmptyLevels() {
        GroupDivision groupDivision = new GroupDivision();

        // Edge case: no students
        int n = 0;
        int[] levels = {};
        int maxSpread = 2;
        int expected = 0;
        assertEquals(expected, groupDivision.sol(n, levels, maxSpread), 
            "Failed on edge case with no students (empty levels array)");
    }

    @Test
    @DisplayName("Edge case: single student with level 5")
    void testSingleStudent() {
        GroupDivision groupDivision = new GroupDivision();

        // Edge case: one student
        int n = 1;
        int[] levels = {5};
        int maxSpread = 2;
        int expected = 1;
        assertEquals(expected, groupDivision.sol(n, levels, maxSpread), 
            "Failed on edge case with a single student with level 5");
    }

    @Test
    @DisplayName("All students have the same skill level [3, 3, 3, 3]")
    void testAllSameLevels() {
        GroupDivision groupDivision = new GroupDivision();

        // All students have the same skill level
        int n = 4;
        int[] levels = {3, 3, 3, 3};
        int maxSpread = 2;
        int expected = 1;
        assertEquals(expected, groupDivision.sol(n, levels, maxSpread), 
            "Failed when all students have the same skill level [3, 3, 3, 3]");
    }

    @Test
    @DisplayName("MaxSpread is 0, requiring each student to be in their own group")
    void testMaxSpreadZero() {
        GroupDivision groupDivision = new GroupDivision();

        // maxSpread is zero, each student must be in their own group
        int n = 3;
        int[] levels = {1, 2, 3};
        int maxSpread = 0;
        int expected = 3;
        assertEquals(expected, groupDivision.sol(n, levels, maxSpread), 
            "Failed when maxSpread is 0, requiring each student to be in their own group");
    }

    @Test
    @DisplayName("MaxSpread is large enough to group all students together")
    void testLargeMaxSpread() {
        GroupDivision groupDivision = new GroupDivision();

        // maxSpread is large enough to group all students together
        int n = 5;
        int[] levels = {1, 10, 20, 30, 40};
        int maxSpread = 50;
        int expected = 1;
        assertEquals(expected, groupDivision.sol(n, levels, maxSpread), 
            "Failed when maxSpread is large enough to group all students together");
    }

    @Test
    @DisplayName("Unsorted input levels [10, 1, 5, 3, 8, 2] with maxSpread 3")
    void testUnsortedInput() {
        GroupDivision groupDivision = new GroupDivision();

        // Input is unsorted
        int n = 6;
        int[] levels = {10, 1, 5, 3, 8, 2};
        int maxSpread = 3;
        int expected = 3;
        assertEquals(expected, groupDivision.sol(n, levels, maxSpread), 
            "Failed on unsorted input levels [10, 1, 5, 3, 8, 2] with maxSpread 3");
    }
}
