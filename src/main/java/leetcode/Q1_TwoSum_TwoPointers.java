package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 1. Two Sum
 * @link https://leetcode.com/problems/two-sum/
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * */
public class Q1_TwoSum_TwoPointers {
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

        // Store the number to index mapping, use a list to store the indices with the same number
        HashMap<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!indexMap.containsKey(nums[i])) {
                indexMap.put(nums[i], List.of(i));
            } else {
                List<Integer> indices = indexMap.get(nums[i]);
                indices.add(i);
                indexMap.put(nums[i], indices);
            }
        }

        while (left < right) {
            int sum = sortedNums[left] + sortedNums[right];
            if (sum == target) {
                // Get the indices of the two numbers
                int leftIndex = indexMap.get(sortedNums[left]).get(0);
                int rightIndex = indexMap.get(sortedNums[right]).get(0);
                // If the two numbers are the same, get the second index from the list
                if (sortedNums[left] == sortedNums[right]) {
                    rightIndex = indexMap.get(sortedNums[right]).get(1);
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
}
