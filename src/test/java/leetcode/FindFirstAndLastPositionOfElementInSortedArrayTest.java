package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    @DisplayName("Normal case: Target exists in the middle")
    void testSearchRangeNormalCase() {
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
        assertArrayEquals(new int[]{3, 4}, solution.searchRange(new int[]{1, 2, 3, 4, 4, 5, 6}, 4),
            "Failed to find the correct range for target 4 in a normal case.");
    }

    @Test
    @DisplayName("Edge case: Target exists at the beginning")
    void testSearchRangeTargetAtBeginning() {
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
        assertArrayEquals(new int[]{0, 1}, solution.searchRange(new int[]{2, 2, 3, 4, 5}, 2),
            "Failed to find the correct range for target 2 at the beginning.");
    }

    @Test
    @DisplayName("Edge case: Target exists at the end")
    void testSearchRangeTargetAtEnd() {
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
        assertArrayEquals(new int[]{3, 4}, solution.searchRange(new int[]{1, 2, 3, 5, 5}, 5),
            "Failed to find the correct range for target 5 at the end.");
    }

    @Test
    @DisplayName("Edge case: Target does not exist")
    void testSearchRangeTargetNotExist() {
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[]{1, 2, 3, 4, 5}, 6),
            "Failed to return [-1, -1] for a non-existent target.");
    }

    @Test
    @DisplayName("Edge case: Empty array")
    void testSearchRangeEmptyArray() {
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[]{}, 1),
            "Failed to return [-1, -1] for an empty array.");
    }

    @Test
    @DisplayName("Single element case: Target exists")
    void testSearchRangeSingleElementExists() {
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
        assertArrayEquals(new int[]{0, 0}, solution.searchRange(new int[]{5}, 5),
            "Failed to find the correct range for target 5 in a single-element array.");
    }

    @Test
    @DisplayName("Single element case: Target does not exist")
    void testSearchRangeSingleElementNotExist() {
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[]{5}, 3),
            "Failed to return [-1, -1] for a non-existent target in a single-element array.");
    }

    @Test
    @DisplayName("Duplicate case: All elements are the target")
    void testSearchRangeAllElementsTarget() {
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
        assertArrayEquals(new int[]{0, 4}, solution.searchRange(new int[]{7, 7, 7, 7, 7}, 7),
            "Failed to find the correct range when all elements are the target.");
    }

    @Test
    @DisplayName("Duplicate case: Target is in the middle of duplicates")
    void testSearchRangeTargetInMiddleOfDuplicates() {
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
        assertArrayEquals(new int[]{2, 4}, solution.searchRange(new int[]{1, 2, 3, 3, 3, 4, 5}, 3),
            "Failed to find the correct range for target 3 in the middle of duplicates.");
    }
}
