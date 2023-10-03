from typing import List


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()  # in place sort
        return self.n_sum(nums, target, 4)

    def n_sum(self, nums: List[int], target: int, k: int) -> List[List[int]]:
        res = []
        if len(nums) == 0:
            return res

        if k == 2:
            return self.two_sum(nums, target)

        for i in range(len(nums)):
            if i == 0 or nums[i - 1] != nums[i]:
                for subset in self.n_sum(nums[i + 1:], target - nums[i], k - 1):
                    res.append([nums[i]] + subset)  # res.append([nums[i], elements in subset...]

        return res

    def two_sum(self, nums: List[int], target: int) -> List[List[int]]:
        result = []
        x_index, y_index = 0, len(nums) - 1

        while x_index < y_index:
            current_sum = nums[x_index] + nums[y_index]
            if current_sum < target or (x_index > 0 and nums[x_index] == nums[x_index - 1]):
                x_index += 1
            elif current_sum > target or (y_index < len(nums) - 1 and nums[y_index] == nums[y_index + 1]):
                y_index -= 1
            else:
                result.append([nums[x_index], nums[y_index]])
                x_index += 1
                y_index -= 1

        return result
