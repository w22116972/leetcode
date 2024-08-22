package solution;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < nums.length - 1 && nums[left] <= nums[left + 1] ) {
            left++;
        }

        // is already sorted
        if (left == nums.length - 1) {
            return 0;
        }

        while (right >= 0 && nums[right - 1] <= nums[right]) {
            right--;
        }

        // But there might be a bigger or smaller value hidden in subarray which affect the total order outside the subarray
        // So we have to find out that possible candidates
        int maxValueInSubarray = Integer.MIN_VALUE;
        int minValueInSubarray = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            maxValueInSubarray = Math.max(maxValueInSubarray, nums[i]);
            minValueInSubarray = Math.min(minValueInSubarray, nums[i]);
        }
        while (left > 0 && minValueInSubarray < nums[left - 1]) {
            left--;
        }
        while (right < nums.length - 1 && maxValueInSubarray > nums[right + 1]) {
            right++;
        }

        return right - left + 1;
    }
}
