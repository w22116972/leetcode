# Graph

## Not yet categorized

- [547. Number of Provinces](https://leetcode.com/problems/number-of-provinces/)
    - adjacency matrix + BFS/DFS + count the number of connected components
- [323. Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
    - convert edges to adjacent + [547.]
- [2685. Count the Number of Complete Components](https://leetcode.com/problems/count-the-number-of-complete-components/)
    - convert edges to adjacent + [323.] + check if the component is complete
- [1319. Number of Operations to Make Network Connected](https://leetcode.com/problems/number-of-operations-to-make-network-connected/)
    - convert edges to adjacent + [323.]
- [2101. Detonate the Maximum Bombs](https://leetcode.com/problems/detonate-the-maximum-bombs/)
    - build adjacent DS + directed graph + find maximum connected components
- [133. Clone Graph](https://leetcode.com/problems/clone-graph/)
    - DFS/BFS
- [1971. Find if Path Exists in Graph](https://leetcode.com/problems/find-if-path-exists-in-graph/)
    - convert edges to adjacent + DFS/BFS
- [200. Number of Islands](https://leetcode.com/problems/number-of-islands/)
    - 2-dimensional array + BFS/DFS + links are 4 directions on 2-dim array + check valid entry not outside grid + count the number of connected components
- [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/)
    - [200.] + find max number of entries in connected islands
- [2658. Maximum Number of Fish in a Grid](https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/)
    - [200.] + count values of entries in connected islands
- [463. Island Perimeter](https://leetcode.com/problems/island-perimeter/)
    - 2-dimensional array + BFS/DFS + links are 4 directions on 2-dim array + count if neighbor is water or boundary
- [419. Battleships in a Board](https://leetcode.com/problems/battleships-in-a-board/)
    - 2-dimensional array + BFS/DFS + links are 2 directions on 2-dim array + count the number of connected components
- [733. Flood Fill](https://leetcode.com/problems/flood-fill/)
    - 2-dimensional array + BFS/DFS + links are same value as input + change the value of the entry
- [130. Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)
    - 2-dimensional array + BFS/DFS + store current connected components + check if any neighbor is boundary
- [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)
    - 2-dimensional array + level-order traversal + count the number of fresh oranges
- [542. 01 Matrix](https://leetcode.com/problems/01-matrix/)
    - 2-dimensional array + level-order traversal + count the level


---

153	Find Minimum in Rotated Sorted Array
21	Merge Two Sorted Lists
3	Longest Substring Without Repeating Characters
20	Determine Valid Parentheses (Valid Parentheses)
18 (或 1, 15, 16)	Find N Numbers Adding up to Target (通常指 4Sum 或 3Sum 等)
200	Find Number of Islands
322	Find Fewest Number of Coins (Coin Change)
1293	Minimum Obstacle Removal to Reach Corner (Shortest Path in a Grid with Obstacles Elimination)
53	Find Subarray with the Largest Sum (Maximum Subarray)
252	Determine If a Person Could Attend All Meetings (Meeting Rooms)
1268	Build a Search Suggestions System (Search Suggestions System)
231	Build a Stock Price Alert System (通常指 Power of Two 或其他相關題目)


- Binary search
- BFS/DFS/Flood fill
- Tree traversals
- Hash tables
- Linked list, stacks, queues, two pointers/sliding window
- Binary heaps
- Dynamic programming
- Union find
- Ad hoc/string manipulations
- Other good to know topics: Trie, segment trees/fenwick trees, bitmasks
- graph

---


## 1. Connectivity Problems

### 1.1 Connected Components Counting

> Count the number of independent connected regions in the graph

- use DSF, BFS, or Union-Find to find connected components

#### 1.1.1 Number of Connected Components




#### 1.1.2 Grid Connected Components

With two-dimensional array
~~- [200. Number of Islands](https://leetcode.com/problems/number-of-islands/)~~
- [1254. Number of Closed Islands (封閉島嶼數量)]
- [1020. Number of Enclaves (飛地的數量)]
~~- 695. Max Area of Island (島嶼的最大面積)~~
- 1905. Count Sub Islands (統計子島嶼)
~~- 463. Island Perimeter (島嶼周長)~~

#### 1.1.3 Connected Components with Constraints
- 1559. Detect Cycles in 2D Grid (網格中的環)
- 959. Regions Cut By Slashes (斜槓分割區域)

### 1.2 連通性判定 (Connectivity Detection)

> 判斷兩點間或整圖的連通性
> Determine the connectivity between two points or the entire graph

#### 1.2.1 靜態連通性判定
- 261. Graph Valid Tree

#### 1.2.2 動態連通性維護

- 990. Satisfiability of Equality Equations
- 1697. Checking Existence of Edge Length Limited Paths

### 1.3 區域變換 (Region Transformation)

> 基於連通性對區域進行標記或變換
> Mark or transform regions based on connectivity

#### 1.3.1 邊界處理類
- 130. Surrounded Regions (被圍繞的區域)
- 417. Pacific Atlantic Water Flow (太平洋大西洋水流)

#### 1.3.2 填充變換類
~~- 733. Flood Fill (圖像渲染)~~
- 1034. Coloring A Border (邊界著色)

## 2. Path Problems

### 2.1 Path Existence
> 判斷兩點間是否存在路徑
> Determine if a path exists between two points

- DFS, BFS

#### 2.1.1 General Path Existence
- 797. All Paths From Source to Target
- 1059. All Paths from Source Lead to Destination
- 1462. Course Schedule IV

### 2.2 最短路徑 (Shortest Path)

#### 2.2.1 無權圖最短路徑

##### 狀態轉換類
- [127. Word Ladder](../src/main/python/leetcode_127_word_ladder.py)
    - use level-order BFS to find the shortest transformation sequence from `beginWord` to `endWord`
    - node is a word, edge exists if two words differ by one letter
- [433. Minimum Genetic Mutation](../src/main/python/leetcode_433_minimum_genetic_mutation.py)
    - same as [127. Word Ladder](../src/main/python/leetcode_127_word_ladder.py) , but it is asked to find the link number not node number like 127
- 752. Open the Lock (打開轉盤鎖)

##### 網格最短路徑
- 1091. Shortest Path in Binary Matrix
- 1926. Nearest Exit from Entrance in Maze
- 1730. Shortest Path to Get Food

##### 網格最短路徑 - 變化題
- 1293. Shortest Path in a Grid with Obstacles Elimination (+ DP)

##### 多源最短路徑
- 994. Rotting Oranges (腐爛的橘子) ⭐
- 542. 01 Matrix
- 1162. As Far from Land as Possible (地圖分析)
- 317. Shortest Distance from All Buildings
- 296. Best Meeting Point
- 1765. Map of Highest Peak

#### 2.2.2 加權圖最短路徑
**核心算法**: Dijkstra、Bellman-Ford

##### 單源最短路徑
- 743. Network Delay Time (網絡延遲時間) ⭐
- 1514. Path with Maximum Probability (最大概率路徑)

##### 單源最短路徑 - 變化題
- 1631. Path With Minimum Effort (最小體力消耗路徑) ⭐ (+ Binary Search)
- 1102. Path With Maximum Minimum Value (+ Binary Search)
- 778. Swim in Rising Water (+ Binary Search)

##### 帶約束最短路徑
- 787. Cheapest Flights Within K Stops (K站中轉內最便宜航班)
- 1928. Minimum Cost to Reach Destination in Time
- 2045. Second Minimum Time to Reach Destination

##### 帶約束最短路徑 - 變化題
- 1786. Number of Restricted Paths From First to Last Node (+ DP)

##### 全源最短路徑
- 1334. Find the City With the Smallest Number of Neighbors (Floyd-Warshall)
- 1617. Count Subtrees With Max Distance Between Cities

### 2.3 特殊路徑問題 (Special Path Problems)

#### 路徑計數
- 1976. Number of Ways to Arrive at Destination
- 62. Unique Paths
- 63. Unique Paths II

#### 路徑計數 - 變化題
- 1575. Count All Possible Routes (+ DP)
- 980. Unique Paths III (哈密頓路徑 + DP)

#### 特殊約束路徑
- 1129. Shortest Path with Alternating Colors (交替顏色最短路徑)
- 1368. Minimum Cost to Make at Least One Valid Path in a Grid

#### 訪問所有節點
- 847. Shortest Path Visiting All Nodes (狀態壓縮) ⭐

#### 訪問所有節點 - 變化題
- 943. Find the Shortest Superstring (+ DP)
- 1125. Smallest Sufficient Team (狀態壓縮 + DP)

---

## 三、圖結構分析 (Graph Structure Analysis)

### 3.1 環檢測 (Cycle Detection)
**目標**: 檢測圖中是否存在環

#### 有向圖環檢測
**核心算法**: DFS + 三色標記法
- 207. Course Schedule (課程表) ⭐
- 802. Find Eventual Safe States

#### 無向圖環檢測
**核心算法**: DFS、Union-Find
- 684. Redundant Connection (冗餘連接) ⭐
- 685. Redundant Connection II

### 3.2 拓撲排序 (Topological Sorting)
**前提**: 有向無環圖 (DAG)
**核心算法**: Kahn算法(BFS)、DFS

#### 課程安排類
- 207. Course Schedule
- 210. Course Schedule II ⭐
- 630. Course Schedule III
- 1462. Course Schedule IV

#### 依賴關係類
- 269. Alien Dictionary (外星詞典)
- 1136. Parallel Courses
- 2115. Find All Possible Recipes from Given Supplies

### 3.3 強連通分量 (Strongly Connected Components)
**核心算法**: Tarjan、Kosaraju
- 1192. Critical Connections in a Network (Tarjan求橋) ⭐

### 3.4 二分圖判定 (Bipartite Detection)
**核心算法**: BFS/DFS 染色法
- 785. Is Graph Bipartite? ⭐
- 886. Possible Bipartition
- 1042. Flower Planting With No Adjacent

---

## 四、圖優化問題 (Graph Optimization Problems)

### 4.1 最小生成樹 (Minimum Spanning Tree)
**核心算法**: Kruskal、Prim
- 1135. Connecting Cities With Minimum Cost
- 1584. Min Cost to Connect All Points ⭐
- 1489. Find Critical and Pseudo-Critical Edges in MST
- 1168. Optimize Water Distribution in a Village

#### 最小生成樹 - 變化題
- 1042. Flower Planting With No Adjacent (+ Greedy)

### 4.2 並查集應用 (Union-Find Applications)
**目標**: 動態維護集合的合併和查詢

#### 集合合併類
- 721. Accounts Merge (帳戶合併) ⭐
- 839. Similar String Groups
- 1202. Smallest String With Swaps

#### 等價關係類
- 990. Satisfiability of Equality Equations
- 952. Largest Component Size by Common Factor
- 1632. Rank Transform of a Matrix

#### 路徑查詢類
- 1697. Checking Existence of Edge Length Limited Paths
- 1724. Checking Existence of Edge Length Limited Paths

### 4.3 匹配問題 (Matching Problems)
- 1066. Campus Bikes II
- 1349. Maximum Students Taking Exam (二分圖最大匹配)

---

## 五、特殊圖結構 (Special Graph Structures)

### 5.1 樹結構 (Tree Structures)
**特點**: 無環連通圖

#### 樹的性質
- 310. Minimum Height Trees (最小高度樹)
- 1245. Tree Diameter

#### 樹上統計
- 834. Sum of Distances in Tree
- 1615. Maximal Network Rank

### 5.2 有向無環圖 (DAG)
**特點**: 有向且無環

#### DAG 路徑問題
- 329. Longest Increasing Path in a Matrix ⭐

#### DAG 路徑問題 - 變化題
- 1289. Minimum Falling Path Sum II (+ DP)

### 5.3 歐拉路徑與哈密頓路徑 (Eulerian & Hamiltonian Paths)

#### 歐拉路徑 (每條邊恰好經過一次)
**核心算法**: Hierholzer算法
- 753. Cracking the Safe
- 332. Reconstruct Itinerary ⭐

#### 哈密頓路徑 (每個節點恰好經過一次)
**核心算法**: 狀態壓縮DP、回溯
- 980. Unique Paths III
- 847. Shortest Path Visiting All Nodes

---

## 六、高級搜索技術 (Advanced Search Techniques)

### 6.1 狀態空間搜索 (State Space Search)

#### 狀態壓縮搜索
**技巧**: 用位運算壓縮狀態
- 847. Shortest Path Visiting All Nodes
- 943. Find the Shortest Superstring
- 1125. Smallest Sufficient Team

#### 雙向搜索
**適用**: 起點終點已知，搜索空間大
- 127. Word Ladder (優化解法)
- 752. Open the Lock
- 1298. Maximum Candies You Can Get from Boxes

### 6.2 記憶化搜索 (Memoized Search)
- 329. Longest Increasing Path in a Matrix

#### 記憶化搜索 - 變化題
- 1575. Count All Possible Routes (+ DP)

### 6.3 特殊搜索應用 (Special Search Applications)

#### 遊戲與謎題
- 752. Open the Lock
- 773. Sliding Puzzle
- 753. Cracking the Safe
- 289. Game of Life (生命遊戲)
- 1655. Distribute Repeating Integers

#### 圖重建與序列化

- 138. Copy List with Random Pointer
- 1153. String Transforms Into Another String
