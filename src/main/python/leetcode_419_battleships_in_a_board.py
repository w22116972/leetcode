"""
419. Battleships in a Board
https://leetcode.com/problems/battleships-in-a-board/

Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.

Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).

Example 1:
Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
Output: 2

Example 2:
Input: board = [["."]]
Output: 0

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is either '.' or 'X'.

Follow up: Could you do it in one-pass, using only O(1) extra memory and without modifying the values board?
"""
from typing import List
class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        rows = len(board)
        cols = len(board[0])

        count = 0
        for i in range(rows):
            for j in range(cols):
                if 0 <= i < rows and 0 <= j < cols and board[i][j] == 'X' and self.is_no_left_ship(i, j, board) and self.is_no_up_ship(i, j, board):
                    count += 1

        return count

    def is_no_left_ship(self, x, y, board):
        return x - 1 < 0 or board[x - 1][y] == '.'

    def is_no_up_ship(self, x, y, board):
        return y - 1 < 0 or board[x][y - 1] == '.'
