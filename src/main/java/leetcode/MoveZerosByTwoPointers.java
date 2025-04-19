package leetcode;

public class MoveZerosByTwoPointers {
    public void moveZeroes(int[] nums) {
        int left = 0; // specify non-zero
        // `right` finds non-zero and swap to
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;

                left++;
            }
        }
    }
}
