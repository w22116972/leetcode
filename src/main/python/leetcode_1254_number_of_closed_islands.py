'''
1254. Number of Closed Islands

Given a 2D grid consists of 0s (land) and 1s (water). An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

Example 1:
Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).

Example 2:
Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1

Example 3:
Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2

Constraints:

1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1
'''
from typing import List

class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])

        num = 0

        visited = set()
        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        for i in range(rows):
            for j in range(cols):
                if self.is_land(i, j, grid) and (i, j) not in visited:
                    queue = deque()
                    queue.append((i, j))
                    visited.add((i, j))
                    is_closed = True
                    while queue:
                        (x, y) = queue.popleft()
                        if self.is_land(x, y, grid):
                            for (dx, dy) in directions:
                                nx = dx + x
                                ny = dy + y
                                if self.is_border(nx, ny, grid):
                                    is_closed = False
                                else:
                                    if self.is_land(nx, ny, grid) and (nx, ny) not in visited:
                                        queue.append((nx, ny))
                                        visited.add((nx, ny))             
                    if is_closed:
                        num += 1
        return num
    
    def is_land(self, x, y, grid):
        return grid[x][y] == 0
    # To be closed island, it requires that all neighbor must not be border
    def is_border(self, x, y, grid):
        return x < 0 or y < 0 or x >= len(grid) or y >= len(grid[0])
