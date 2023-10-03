from typing import List


class Solution:
    def search_iteratively(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = left + int((right - left) / 2)
            if nums[mid] == target:
                return mid
            # To find whether pivot is located at the left or right side
            if nums[left] <= nums[mid]:  # Pivot point is at right side
                if nums[left] <= target < nums[mid]:
                    # go to left side
                    right = mid - 1
                else:
                    left = mid + 1
            else:  # Pivot point is at left side
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1




