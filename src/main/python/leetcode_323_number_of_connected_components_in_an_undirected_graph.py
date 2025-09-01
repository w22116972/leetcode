"""
323. Number of Connected Components in an Undirected Graph
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

[This is a premium LeetCode problem. The following is a general description based on the title.]

You are given an integer n and a list of edges. The integer n represents the number of nodes in a graph, labeled from 0 to n - 1. The list of edges represents the connections between these nodes. Each edge is a pair of nodes.

The task is to find the number of connected components in the undirected graph. A connected component is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.
"""
from typing import List
from collections import deque
class Solution:
    def countComponents(self, n: int, edges: list[list[int]]) -> int:
        # convert edges into adj list
        adj = [[] for _ in range(n)]

        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        count = 0
        visited = set()
        queue = deque()

        for i in range(n):
            if i not in visited:
                queue.append(i)
                visited.add(i)
                while queue:
                    node = queue.popleft()
                    visited.add(node)

                    for adj_node in adj[node]:
                        if adj_node not in visited:
                            queue.append(adj_node)
                            visited.add(adj_node)
                count += 1
        return count