package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);

        // it's ok because nums1 are all unique
        HashMap<Integer, Integer> nums1ToIndex = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1ToIndex.put(nums1[i], i);
        }

        Stack<Integer> stack = new Stack<>(); // monotonic decreasing stack
        for (final int current : nums2) {
            while (!stack.isEmpty() && current > stack.peek()) {
                final int topIndex = nums1ToIndex.get(stack.pop());
                result[topIndex] = current;
            }
            if (nums1ToIndex.containsKey(current)) {
                stack.add(current);
            }
        }
        return result;
    }
}
