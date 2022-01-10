from typing import List

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1] * len(nums)
        for i in range(len(nums) - 1, -1, -1):
            for choiceStartIndex in range(i + 1, len(nums)):
                if nums[i] < nums[choiceStartIndex]:
                    dp[i] = max(dp[i], 1 + dp[choiceStartIndex])
        return max(dp)
