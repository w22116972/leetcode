package leetcode;

public class NextPermutationByTwoPointers {
    public void nextPermutation(int[] nums) {
        int pivot = nums.length - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }
        if (pivot == -1) {
            reverseIntArray(nums, 0, nums.length - 1);
        } else {
            int rightMostSuccessor = nums.length - 1;
            while (nums[rightMostSuccessor] <= nums[pivot]) {
                rightMostSuccessor--;
            }

            int temp = nums[pivot];
            nums[pivot] = nums[rightMostSuccessor];
            nums[rightMostSuccessor] = temp;

            reverseIntArray(nums, pivot + 1, nums.length - 1);
        }
    }

    public void reverseIntArray(int[] nums, int start, int end) {
        while (start < end) {
            // Swap elements
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            // Move pointers
            start++;
            end--;
        }
    }
}
