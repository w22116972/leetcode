package solution;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        final int numsLength = nums.length;
        final int[] result = new int[numsLength];
        // If it doesn't exist, return -1 for this number.
        Arrays.fill(result, -1);

        // Build monotonic decreasing stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numsLength * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % numsLength])
                result[stack.pop()] = nums[i % numsLength];
            stack.push(i % numsLength);
        }
        return result;

    }
}
