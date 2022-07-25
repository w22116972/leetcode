from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        sorted_nums = sorted(nums)
        # since x + y + z = 0 -> x + y = -z -> twoSum with target = -z
        for z_index in range(len(sorted_nums) - 2):
            # skip duplicate z
            if z_index > 0 and sorted_nums[z_index] == sorted_nums[z_index - 1]:
                continue
            self.two_sum(z_index + 1, len(nums) - 1, sorted_nums, -sorted_nums[z_index], result)
        return result

    def two_sum(self, x_index: int, y_index: int, nums: List[int], target: int, result: List[List[int]]):
        while x_index < y_index:
            if nums[x_index] + nums[y_index] == target:
                result.append([-target, nums[x_index], nums[y_index]])
                x_index += 1
                while x_index < y_index and nums[x_index] == nums[x_index - 1]:
                    x_index += 1
                # skip duplicate
                y_index -= 1
                while x_index < y_index and nums[y_index] == nums[y_index + 1]:
                    y_index -= 1
            elif nums[x_index] + nums[y_index] < target:
                x_index += 1
            elif nums[x_index] + nums[y_index] > target:
                y_index -= 1






if __name__ == '__main__':
    def test():
        return 1, 2

    result = []
    result.append([0, test()])
    print(result)