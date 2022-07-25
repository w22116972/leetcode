from typing import List

'''
TLE version
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = set()
        island_count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1" and (i, j) not in visited:
                    # starting from island
                    island_count += 1
                    potential_island = [(i, j)]  # as queue
                    visited.add((i, j))
                    while len(potential_island) > 0:
                        island_index = potential_island.pop(0)
                        x = island_index[0]
                        y = island_index[1]
                        if not self.is_axis_valid(x, y, grid):
                            continue
                        visited.add((x, y))
                        if grid[x][y] == "0":
                            continue
                        # put 4 direction into potential_islands
                        self.add_possible_land(x - 1, y, grid, visited, potential_island)
                        self.add_possible_land(x + 1, y, grid, visited, potential_island)
                        self.add_possible_land(x, y - 1, grid, visited, potential_island)
                        self.add_possible_land(x, y + 1, grid, visited, potential_island)
        return island_count

    def is_axis_valid(self, i, j, grid):
        return 0 <= i < len(grid) and 0 <= j < len(grid[0])

    def add_possible_land(self, i, j, grid, visited, potential_island):
        if self.is_axis_valid(i, j, grid) and grid[i][j] != "0" and (i, j) not in visited:
            potential_island.append((i, j))


if __name__ == '__main__':
    test_data = [["1", "1", "1", "1", "0"], ["1", "1", "0", "1", "0"], ["1", "1", "0", "0", "0"],
                 ["0", "0", "0", "0", "0"]]
    sol = Solution()
    print(sol.numIslands(test_data))
