package stack;

import java.util.Stack;

public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        final int n = nums.length;
        // store index
        Stack<Integer> stack = new Stack<>();

        // find sum of all min in subarray
        int sumOfAllMin = 0;
        for (int i = 0; i < n; i++) {

            stack.add(i);
        }

        // find sum of all max in subarray
        int sumOfAllMax = 0;
        for (int i = 0; i < n; i++) {
            // Assume nums[i] is maximal in subarray,
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int mid = stack.pop();

            }
            stack.add(i);
        }
        // After iterating all array, if no other value greater than top in stack,
        // stack is not empty,
        while (!stack.isEmpty()) {

        }

        return sumOfAllMax - sumOfAllMin;
    }
}
