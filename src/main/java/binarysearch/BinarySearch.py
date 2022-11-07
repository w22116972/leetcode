from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        return self.recursively_search(nums, target, 0, len(nums) - 1)

    def recursively_search(self, nums, target, left, right):
        if left > right:
            return -1
        mid = int((left + right) / 2)
        if nums[mid] == target:
            return mid
        elif nums[mid] > target:
            return self.recursively_search(nums, target, left, mid - 1)
        else:
            return self.recursively_search(nums, target, mid + 1, right)

    def search_recursively(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = int((left + right) / 2)
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:  # search left
                right = mid - 1
            else:  # search right
                left = mid + 1
        return -1
