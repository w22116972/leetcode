package solution;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        } else if (nums.length == 1) {
            return List.of(String.valueOf(nums[0]));
        }

        final List<String> result = new LinkedList<>();
        int headOfRanges = nums[0];
        int prev = 0;
        int current = 0;
        for (int i = 1; i < nums.length; i++) {
            prev = nums[i - 1];
            current = nums[i];
            if (current != prev + 1 && prev == headOfRanges) {
                result.add(String.valueOf(headOfRanges));
                headOfRanges = current;
            } else if (current != prev + 1 && prev != headOfRanges) {
                result.add(headOfRanges + "->" + prev);
                headOfRanges = current;
            }
        }
        if (headOfRanges == current) {
            result.add(String.valueOf(headOfRanges));
        } else if (current == prev + 1) {
            result.add(headOfRanges + "->" + current);
        }
        return result;
    }

}
