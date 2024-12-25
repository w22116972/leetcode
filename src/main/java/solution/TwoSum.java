package solution;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. Two Sum
 * @link https://leetcode.com/problems/two-sum/
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * */
public class TwoSum {
    /** Ask interviewer:
     * - Are `nums` are all integers?
     * - Are there any duplicates in `nums`?
     * - Are `nums` sorted?
     * - Do many answers exist?
     * - Can we modify the input array?
     * State the Two Pointers Approach:
     *  I see that this problem might be simplified if the array is sorted.
     *  Once sorted, I can use a two-pointer technique: one pointer at the start (left) and one at the end (right).
     *  Then, I’ll adjust the pointers inward based on whether the sum is too large or too small.
     * Explain why we need sorting:
     *  Sorting the array allows us to leverage the fact that the sum of a smaller element plus a larger element either increases or decreases in a predictable way as we move the pointers.
     *  That way, we can find a matching pair in a single pass
    * */
    public int[] twoSum(int[] nums, int target) {
        // To avoid modifying the input array
        int[] sortedNums = nums.clone();
        // First, we need to sort the array
        Arrays.sort(sortedNums);
        // Declare two pointers
        int left = 0;
        int right = sortedNums.length - 1;
        while (left < right) {
            int sum = sortedNums[left] + sortedNums[right];
            if (sum == target) {
                // Find the indices of the two numbers
                int leftIndex = -1;
                int rightIndex = -1;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == sortedNums[left] && leftIndex == -1) {
                        leftIndex = i;
                    } else if (nums[i] == sortedNums[right] && rightIndex == -1) {
                        rightIndex = i;
                    }
                }
                return new int[]{leftIndex, rightIndex};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }

        }
        return new int[0];
    }

    /**
     * State the HashMap Approach:
     *  I see that I can use a HashMap to store the difference between the target and the current element.
     *  Then, I can check if the current element exists in the HashMap.
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // Check if the current element exists in the HashMap
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            // Store the difference between the target and the current element
            map.put(target - nums[i], i);
        }
        return new int[0];
    }


}
