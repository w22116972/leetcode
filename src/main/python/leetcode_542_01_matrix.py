from typing import List

"""
542. 01 Matrix

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 10^4
1 <= m * n <= 10^4
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
"""

from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        # like rotting orange 
        # rotten is 0, it will update neighbor non-zero cell into rotten at each level
        visited = set()
        rows = len(mat)
        cols = len(mat[0])
        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]

        level = 1

        queue = deque()
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    queue.append((i, j))
                    visited.add((i, j))
        
        while queue:
            size = len(queue)
            for _ in range(size):
                (x, y) = queue.popleft()
                for (dx, dy) in directions:
                    nx = x + dx
                    ny = y + dy
                    if 0 <= nx < rows and 0 <= ny < cols and (nx, ny) not in visited:
                        if mat[nx][ny] == 1:
                            mat[nx][ny] = level
                        queue.append((nx, ny))
                        visited.add((nx, ny))
            level += 1

        return mat