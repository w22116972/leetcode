from typing import List, Set

'''
TLE version
'''


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = set()
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        number_of_islands = 0
        row_length = len(grid)
        col_length = len(grid[0])

        def bfs(row: int, col: int):
            visited.add((row, col))
            waiting = [(row, col)]
            while len(waiting) > 0:
                (x, y) = waiting.pop(0)
                for direction in directions:
                    explore_x = x + direction[0]
                    explore_y = y + direction[1]
                    if 0 <= explore_x < row_length and 0 <= explore_y < col_length and grid[explore_x][
                        explore_y] == "1" and (explore_x, explore_y) not in visited:
                        waiting.append((explore_x, explore_y))
                        visited.add((explore_x, explore_y))

        for row in range(row_length):
            for col in range(col_length):
                if grid[row][col] == "1" and (row, col) not in visited:
                    bfs(row, col)
                    number_of_islands += 1
        return number_of_islands


if __name__ == '__main__':
    test_data = [["1", "1", "1", "1", "0"], ["1", "1", "0", "1", "0"], ["1", "1", "0", "0", "0"],
                 ["0", "0", "0", "0", "0"]]
    sol = Solution()
    print(sol.numIslands(test_data))
