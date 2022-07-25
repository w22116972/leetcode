from typing import List


class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        stack = []  # stores index which value in arr are increasing
        result = 0
        # all values are > 0, so use 0 to ensure there is boundary for any value
        arr = [0] + arr + [0]

        for index, value in enumerate(arr):
            # if current value is < top of stack
            while stack and arr[stack[-1]] > value:
                top_index = stack.pop()
                result += arr[top_index] * (top_index - stack[-1]) * (index - top_index)
            stack.append(index)
        return result % (10**9 + 7)
if __name__ == '__main__':
    s = []
    print(s[-1])
