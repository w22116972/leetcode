"""
1319. Number of Operations to Make Network Connected
https://leetcode.com/problems/number-of-operations-to-make-network-connected/

There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
"""
from typing import List
from collections import deque
class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        """

        To make sure all connected
        - check there are at least n - 1 edges
        - number of disconnected components requires num - 1 edges to connect them into a single connected component

        """
        # assume no repeated connections and no two components are connected by more than one edge
        if len(connections) < n - 1:
            return -1

        # convert input edges to adjacent list
        adj = [[] for _ in range(n)]
        for a, b in connections:
            adj[a].append(b)
            adj[b].append(a)

        # find number of disconnected components

        num = 0
        visited = set()

        for i in range(n):
            # Found a new component
            if i not in visited:
                num += 1
                visited.add(i)
                queue = deque([i])

                while queue:
                    node = queue.popleft()
                    for adj_node in adj[node]:
                        if adj_node not in visited:
                            queue.append(adj_node)
                            visited.add(adj_node)

        return num - 1