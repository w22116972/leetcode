# Sliding Window

### keywords

given condition (e.g. length) for contiguous subarray of sub linked-list

### solution

1. use two indices for window (one for first index, one for last index)
2. we move window by moving the last index
3. when we create a window that satisfies condition (size=k or sum=s), we calculate result
4. then move window by moving the first index