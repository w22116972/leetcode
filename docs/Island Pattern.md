#  Matrix Traverse for Island Pattern

Use BFS or DFS to traverse 2D array.

### Keyword

- 2D array

### Algorithm

1. Traverse the 2D array by rows and columns
2. For each cell, check if it has been visited or if it is valid.
   - If this cell is not visited, mark it as visited and do something

3 Ways to Mark Visited Islands
1. Use a hash set to store the coordinates of visited islands
   - S(O) = O(row * col)
   - Cons: Overhead of converting coordinates to strings and additional memory usage
```java
Set<String> visitedCells = new HashSet<>();
// mark visited cell by adding to hash set
visitedCells.add(currentRow + "," + currentCol);

private boolean isCellVisited(int row, int col) {
  return visitedCells.contains(row + "," + col);
}
```
2. Use a boolean array to store the visited islands
   - S(O) = O(row * col)
   - Cons: Additional memory usage
```java
boolean[][] visitedCells = new boolean[row][col];
// mark visited cell by setting the value to true
visitedCells[currentRow][currentCol] = true;

private boolean isCellVisited(int row, int col) {
  return visitedCells[row][col];
}
```

3. Modify the Original Grid to Mark Visited Cells
   - S(O) = O(1)
   - Cons: Change the original grid
```java
public static final char VISITED_CELL = '-';
// mark visited cell by dummy value
grid[currentRow][currentCol] = VISITED_CELL;

private boolean isCellVisited(int row, int col) {
  return grid[row][col] == VISITED_CELL;
}
```

---

### 200. Number of Islands

Use a `numberOfIslands` to store the number of islands. Then use DFS or BFS to mark the island as visited. If queue/stack is empty, increase the `numberOfIslands` by 1.

### 1254. Number of Closed Islands

Use a `numberOfClosedIslands` to store the number of closed islands. Then use DFS or BFS to mark the island as visited. Only if the island is surrounded by water, increase the `numberOfClosedIslands` by 1.

vs. [200. Number of Islands](200.%20Number%20of%20Islands.md) is surrounded by water or boundary

### 695. Max Area of Island

Use a `maxArea` to store the maximum area of islands. Then use DFS or BFS to mark the island as visited. If queue/stack is empty, update the `maxArea`.

### 733. Flood Fill

Use a `startingColor` to store the color of the starting pixel. The image to be traversed can be seen as the only one island to explore. For each pixel, if its color is equal to `startingColor`, change the color to `color`.

### 463. Island Perimeter

1. If the neighbor cell is water or boundary, increase `perimeter` by 1
2. If the neighbor cell is land and not visited, enqueue the neighbor

### 694. Number of Distinct Islands




### Questions

[200. Number of Islands](200.%20Number%20of%20Islands.md)

[695. Max Area of Island](695.%20Max%20Area%20of%20Island.md)

[733. Flood Fill](733.%20Flood%20Fill.md)

[1254. Number of Closed Islands](1254.%20Number%20of%20Closed%20Islands.md)

[463. Island Perimeter](463.%20Island%20Perimeter.md)

[694. Number of Distinct Islands](694.%20Number%20of%20Distinct%20Islands.md)
