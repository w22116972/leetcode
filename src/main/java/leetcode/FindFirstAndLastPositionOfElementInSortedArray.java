package leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[] {findLeftTarget(nums, target), findRightTarget(nums, target)};
    }

    public int findLeftTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid > 0 && nums[mid - 1] == target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] < target) {
                left++;
            } else {
                right--;
            }
        }
        return -1;
    }

    public int findRightTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid < nums.length - 1 && nums[mid + 1] == target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] < target) {
                left++;
            } else {
                right--;
            }
        }
        return -1;
    }
}
