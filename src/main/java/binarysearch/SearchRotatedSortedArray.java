package binarysearch;

public class SearchRotatedSortedArray {
    public int sol(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[mid] < target || target < nums[left]) {
                    left = mid + 1;  // go right
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] || nums[right] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
