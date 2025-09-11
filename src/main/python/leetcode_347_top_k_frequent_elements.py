
"""
347. Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]
"""
from typing import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # use bucket sort to make it T = O(n)
        num_count = {}
        for n in nums:
            if n in num_count:
                num_count[n] += 1
            else:
                num_count[n] = 1

        count_to_num = [0] * (len(nums) + 1)
        for (k, v) in num_count:
            if len(count_to_num[v]) == 0:
                count_to_num[v] = [k]
            else:
                count_to_num[v].append(k)
        
        result = []
        for i in range(len(nums), -1, -1):
            if len(count_to_num[i]) != 0:
                for n in count_to_num[i]:
                    result.append(n)
                    if len(result) == k:
                        return result
        return result
        

        
