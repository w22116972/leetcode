"""
130. Surrounded Regions
https://leetcode.com/problems/surrounded-regions/

You are given an m x n matrix board containing letters 'X' and 'O'. The task is to capture regions that are surrounded.

Here's a breakdown of the terms:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: A region is formed by connecting adjacent 'O' cells.
Surround: A region is surrounded if it's enclosed by 'X' cells and none of its cells are on the edge of the board.
To capture a surrounded region, you need to replace all 'O's with 'X's in that region within the original board. You don't need to return anything.

Example 1:
Input:
board = [["X","X","X","X"],
         ["X","O","O","X"],
         ["X","X","O","X"],
         ["X","O","X","X"]]

Output:
[["X","X","X","X"],
 ["X","X","X","X"],
 ["X","X","X","X"],
 ["X","O","X","X"]]

Explanation:

In the example above, the 'O' in the bottom row is not captured because it's on the edge of the board and therefore cannot be surrounded.

Example 2:
Input:
board = [["X"]]

Output:
[["X"]]

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is either 'X' or 'O'.
"""
from collections import deque
from typing import List
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Check whether any elemnt has neighbor is boundary
        """
        rows = len(board)
        cols = len(board[0])
        #visited = set()
        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]

        for i in range(rows):
            for j in range(cols):
                if board[i][j] == "O":
                    regions = set()
                    queue = deque()
                    queue.append((i, j))
                    regions.add((i, j))
                    is_surrounded = True
                    while queue:
                        (x, y) = queue.popleft()
                        for dx, dy in directions:
                            nx = x + dx
                            ny = y + dy
                            if 0 <= nx < rows and 0 <= ny < cols and (nx, ny) not in regions and board[nx][ny] == "O":
                                queue.append((nx, ny))
                                regions.add((nx, ny))
                            if nx < 0 or nx >= rows or ny < 0 or ny >= cols:
                                is_surrounded = False
                    if is_surrounded:
                        for (x, y) in regions:
                            board[x][y] = "X"