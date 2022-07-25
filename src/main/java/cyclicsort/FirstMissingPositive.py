from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        # index = 0, 1, 2, len(nums) - 1
        # value = 1, 2, 3, len(nums)
        # index == value - 1

        # Swap the current value to where it should be

        for i in range(len(nums)):
            current = nums[i]
            index = nums[i] - 1
            while 0 < current <= len(nums) and current != nums[index]:
                i, index = index, i


        for i in range(len(nums)):
            if i != nums[i] - 1:
                return i + 1
        return len(nums) + 1

