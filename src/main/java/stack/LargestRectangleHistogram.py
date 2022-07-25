from typing import List


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        max_area = 0
        stack = []  # (index, height), store non-decreasing heights
        for current_index, current_height in enumerate(heights):
            left_boundary_index = current_index
            while stack and stack[-1][1] > current_height:  #
                top_index, top_height = stack.pop()
                max_area = max(max_area, top_height * (current_index - top_index))
                left_boundary_index = top_index
            stack.append((left_boundary_index, current_height))

        # since maybe there are still some
        for i, h in stack:
            max_area = max(max_area, h * (len(heights) - i))
        return max_area
