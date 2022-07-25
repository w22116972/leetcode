package interval;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0) {

        }

        final LinkedList<String> result = new LinkedList<>();
        int head = lower;
        int tail = lower;
        for (int i: nums) {
            if (i < head) {
                continue;
            }


        }

        return result;
    }
}
