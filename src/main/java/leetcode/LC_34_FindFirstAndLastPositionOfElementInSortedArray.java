package leetcode;

/*
* Given sorted array and finding element in nlogn time complexity, my first thought was to use binary search.
* Use two binary searches to find the first and last position of the target element.
* When considering while loop condition, I used left <= right because I want to include the last element in the search.
* Time complexity is O(log n) for each binary search, so the overall time complexity is O(log n).
* Space complexity is O(1) because we are using only a few extra variables.
* */
public class LC_34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[] {findFirstTarget(nums, target), findLastTarget(nums, target)};
    }

    public int findFirstTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // while-loop exit condition is left <= right because we want to consider candidate when left == right (single element)
        while (left <= right) {
            // To avoid overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // Check if this is the first occurrence of the target
                // If the previous element is also the target, we need to search in the left half
                // why use right = mid - 1 instead of right = mid?
                if (mid > 0 && nums[mid - 1] == target) {
                    right = mid - 1;
                } else { // If the previous element is not the target, we found the first occurrence
                    return mid;
                }
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return -1;
    }

    public int findLastTarget(int[] nums, int target) {
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
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
