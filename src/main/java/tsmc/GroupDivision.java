package tsmc;

import java.util.Arrays;

/**
 * A university has admitted a group of n students with varying skill levels.
 * To better accommodate the students, the university has decided to create
 * classes tailored to these skill levels. A placement examination returns a
 * skill level for each student, represented by an array levels[], where
 * levels[i] denotes the skill level of student i.
 *
 * All students within a group must have skill levels that are within a
 * specified range, maxSpread, of one another. The goal is to determine the
 * minimum number of groups that must be formed to ensure that no group
 * contains students whose skill levels differ by more than maxSpread.
 *
 * Example:
 * Input:
 * n = 5 (number of students)
 * levels = [1, 4, 7, 3, 4] (skill levels of the students)
 * maxSpread = 2 (the maximum allowed skill level difference within a group)
 * Output:
 * 3 (minimum number of groups)
 */
public class GroupDivision {

    public int sol(int n, int[] levels, int maxSpread) {
        if (levels.length == 0) {
            return 0;
        }

        // Sort the skill levels
        Arrays.sort(levels);

        int minNumberOfGroups = 1; // Start with one group
        int groupStart = levels[0]; // Start of the current group

        for (int i = 1; i < n; i++) {
            // If the current level exceeds the maxSpread from the group start, form a new group
            if (levels[i] - groupStart > maxSpread) {
                minNumberOfGroups++;
                groupStart = levels[i]; // Update the start of the new group
            }
        }

        return minNumberOfGroups;
    }
}
