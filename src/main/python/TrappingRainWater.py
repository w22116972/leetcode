from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        area = 0
        left_index = 0
        right_index = len(height) - 1
        left_max_height = 0
        right_max_height = 0

        while left_index < right_index:
            left_max_height = max(left_max_height, height[left_index])
            right_max_height = max(right_max_height, height[right_index])
            if left_max_height < right_max_height:
                area += left_max_height - height[left_index]
                left_index += 1
            else:
                area += right_max_height - height[right_index]
                right_index -= 1
        return area
