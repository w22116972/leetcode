package leetcode;

import java.util.HashMap;

/**
 * 1. Two Sum
 * @link https://leetcode.com/problems/two-sum/
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * */
public class TwoSumByHashMap {
    /** Ask interviewer:
     * - Are `nums` are all integers?
     * - Are there any duplicates in `nums`?
     * - Are `nums` sorted?
     * - Do many answers exist?
     * - Can we modify the input array?
    * */

    /**
     * State the HashMap Approach:
     *  I see that I can use a HashMap to store the difference between the target and the current element.
     *  Then, I can check if the current element exists in the HashMap.
     */
    public int[] twoSum(int[] nums, int target) {
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
