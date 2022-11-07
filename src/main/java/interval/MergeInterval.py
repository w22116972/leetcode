from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) < 2:
            return intervals
        # Ensure a.start <= b.start
        intervals.sort(key=lambda i: i[0])
        result = []
        current_head = intervals[0][0]
        current_tail = intervals[0][1]
        for i in range(1, len(intervals)):
            next_head = intervals[i][0]
            next_tail = intervals[i][1]
            # if new interval (a) and current interval (b) are overlapping (a.tail >= b.head)
            # new tail = max(new_tail, current_tail)
            if current_tail >= next_head:
                current_tail = max(current_tail, next_tail)
            else:  # if they are non-overlapping
                result.append([current_head, current_tail])
                current_head = next_head
                current_tail = next_tail
        result.append([current_head, current_tail])
        return result


if __name__ == '__main__':
    s = Solution()
    print(s.merge([[1, 3], [2, 6], [8, 10], [15, 18]]))
    print(s.merge([[1, 4], [4, 5]]))
