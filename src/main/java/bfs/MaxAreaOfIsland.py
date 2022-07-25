from typing import List


class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        max_area = 0
        row_length = len(grid)
        col_length = len(grid[0])
        visited = set()
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        def bfs(row: int, col: int, local_area: int):
            queue = [(row, col)]
            while len(queue) > 0:
                (x, y) = queue.pop(0)
                for direction in directions:
                    explore_x = x + direction[0]
                    explore_y = y + direction[1]
                    if 0 <= explore_x < row_length and 0 <= explore_y < col_length and grid[explore_x][
                        explore_y] == 1 and (explore_x, explore_y) not in visited:
                        local_area += 1
                        queue.append((explore_x, explore_y))
                        visited.add((explore_x, explore_y))
            return local_area

        for row in range(row_length):
            for col in range(col_length):
                if grid[row][col] == 1 and (row, col) not in visited:
                    local_area = 1
                    visited.add((row, col))
                    local_area = bfs(row, col, local_area)
                    max_area = max(max_area, local_area)
        return max_area