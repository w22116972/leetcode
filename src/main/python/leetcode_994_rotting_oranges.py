from collections import deque
from typing import List
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        
        queue = deque()
        # visited = set()
        fresh = 0
        # find init rotten and fresh oranges
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 2:
                    queue.append((i, j))
                if grid[i][j] == 1:
                    fresh += 1
        
        num = 0
        
        while queue and fresh > 0:
            size = len(queue)
            for i in range(size):
                (x, y) = queue.popleft()
                # find next targets
                for dx, dy in directions:
                    nx = x + dx
                    ny = y + dy
                    if 0 <= nx < rows and 0 <= ny < cols and grid[nx][ny] == 1:
                        grid[nx][ny] = 2
                        fresh -= 1
                        queue.append((nx, ny))

            num += 1
        
        # check whether still has fresh orange
        if fresh > 0:
            return -1
        return num