from type import List

class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        if len(intervals) == 1:
            return 0
        intervals.sort(key=lambda i: i[0])
        # current_head = intervals[0][0]
        current_tail = intervals[0][1]
        count = 0
        for i in range(1, len(intervals)):
            next_head = intervals[i][0]
            next_tail = intervals[i][1]
            # if overlapping
            if current_tail > next_head:
                count += 1
                current_tail = min(current_tail, next_tail)
            else:
                current_tail = next_tail
                # current_head = next_head
        return count