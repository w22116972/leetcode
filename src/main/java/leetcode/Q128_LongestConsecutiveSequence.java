package leetcode;

import java.util.HashSet;

/**
 *
 * T = O(n), because inner `while` loop only visit elements once
 * S = O(n), hash set
 * */
public class Q128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int longestConsecutiveNumber = 0;
        if (nums == null || nums.length == 0) {
            return longestConsecutiveNumber;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i: nums) {
            set.add(i);
        }

        for (int i: set) {
            // Make sure `i` is the starting sequence of consecutive number
            if (!set.contains(i - 1)) {
                int currentConsecutiveNumber = 1;
                int increment = 1;
                while (set.contains(i + increment)) {
                    currentConsecutiveNumber++;
                    increment++;
                }
                longestConsecutiveNumber = Math.max(currentConsecutiveNumber, longestConsecutiveNumber);
            }

        }
        return longestConsecutiveNumber;
    }
}
