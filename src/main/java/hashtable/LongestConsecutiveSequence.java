package hashtable;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i: nums) {
            set.add(i);
        }

        int longestCount = 0;
        for (int i: nums) {
            if (!set.contains(i - 1)) {
                int count = 1;
                int j = i;
                while (set.contains(j + 1)) {
                    count++;
                    j++;
                }
                longestCount = Math.max(longestCount, count);
            }
        }
        return longestCount;
    }
}
