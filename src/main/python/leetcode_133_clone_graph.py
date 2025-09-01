"""
133. Clone Graph
https://leetcode.com/problems/clone-graph/

Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}

Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

Constraints:

The number of nodes in the graph is in the range [0, 100].
1 <= Node.val <= 100.
Node.val is unique for each node.
There are no repeated edges and no self-loops in the graph.
The Graph is connected and all nodes can be visited starting from the given node.
"""
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

from typing import List
from typing import Optional
class Solution:
    """
    This solution clones an undirected graph using DFS (Depth-First Search).
    It uses a dictionary to keep track of already cloned nodes to handle cycles and avoid redundant work.
    The main function cloneGraph initializes the visited_node dictionary and starts the DFS cloning process.

    Time Complexity: O(N + E), where N is the number of nodes and E is the number of edges in the graph. Each node and edge is visited once.
    Space Complexity: O(N), for the hash map storing cloned nodes and the recursion/stack/queue used in traversal.
    """
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return None
        visited_node = {}
        return self.dfs(node, visited_node)

    def dfs(self, node: Optional['Node'], visited_node) -> Optional['Node']:
        """
        Recursively clones the graph using DFS.
        If the node has already been cloned (exists in visited_node), returns the clone to avoid cycles and redundant work.
        Otherwise, creates a new clone, stores it in visited_node, and recursively clones all neighbors.
        """
        # If this node was already cloned, return the clone to prevent cycles and redundant work
        if node in visited_node:
            return visited_node[node]
        # Create a new node (clone) with the same value as the original node
        clone_node = Node(node.val)
        # Store the clone in the visited_node dictionary before processing neighbors
        # This is crucial to handle cycles and self-referencing nodes
        visited_node[node] = clone_node

        # Recursively clone all the neighbors and add them to the clone's neighbors list
        for neighbor in node.neighbors:
            clone_neighbor = self.dfs(neighbor, visited_node)  # Clone each neighbor
            clone_node.neighbors.append(clone_neighbor)        # Add the cloned neighbor to the clone's neighbors
        # Return the fully constructed clone node
        return clone_node

    def clone_graph_dfs(self, node: Optional['Node']) -> Optional['Node']:
        """
        Iteratively clones an undirected graph using DFS with a stack.
        Uses a dictionary to map original nodes to their clones to handle cycles and avoid redundant work.
        """
        if node is None:
            return None

        # Dictionary to save the mapping from original nodes to their clones
        visited_node = {}
        # Initialize the stack with the starting node
        stack = [node]
        # Clone the root node and put it in the visited_node dictionary
        visited_node[node] = Node(node.val)

        while stack:
            curr = stack.pop()
            # Iterate through all neighbors of the current node
            for neighbor in curr.neighbors:
                if neighbor not in visited_node:
                    # Clone the neighbor if it hasn't been cloned yet
                    visited_node[neighbor] = Node(neighbor.val)
                    # Add the neighbor to the stack for further traversal
                    stack.append(neighbor)
                # Add the cloned neighbor to the current node's clone neighbors list
                visited_node[curr].neighbors.append(visited_node[neighbor])
        # Return the clone of the starting node
        return visited_node[node]

    def clone_graph_bfs(self, node: Optional['Node']) -> Optional['Node']:
        """
        Iteratively clones an undirected graph using BFS with a queue.
        Uses a dictionary to map original nodes to their clones to handle cycles and avoid redundant work.
        """
        if node is None:
            return None

        from collections import deque
        # Dictionary to save the mapping from original nodes to their clones
        visited_node = {}
        # Initialize the queue with the starting node
        queue = deque([node])
        # Clone the root node and put it in the visited_node dictionary
        visited_node[node] = Node(node.val)

        while queue:
            curr = queue.popleft()
            # Iterate through all neighbors of the current node
            for neighbor in curr.neighbors:
                if neighbor not in visited_node:
                    # Clone the neighbor if it hasn't been cloned yet
                    visited_node[neighbor] = Node(neighbor.val)
                    # Add the neighbor to the queue for further traversal
                    queue.append(neighbor)
                # Add the cloned neighbor to the current node's clone neighbors list
                visited_node[curr].neighbors.append(visited_node[neighbor])
        # Return the clone of the starting node
        return visited_node[node]