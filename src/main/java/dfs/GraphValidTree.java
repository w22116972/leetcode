package dfs;

import java.util.*;

public class GraphValidTree {

    HashMap<Integer, List<Integer>> adjacentList;
    Set<Integer> visited;

    public boolean validTreeNeetcode(int n, int[][] edges) {
        if (n == 0) {
            return true;
        }

        adjacentList = new HashMap<>();
        for (int[] edge: edges) {
            if (!adjacentList.containsKey(edge[0])) {
                adjacentList.put(edge[0], List.of(edge[1]));
            } else {
                adjacentList.get(edge[0]).add(edge[1]);
            }
            if (!adjacentList.containsKey(edge[1])) {
                adjacentList.put(edge[1], List.of(edge[0]));
            } else {
                adjacentList.get(edge[1]).add(edge[0]);
            }
        }
        visited = new HashSet<>();
        return dfs(0, -1) && n == visited.size();
    }

    private boolean dfs(int i, int prev) {
        // detect cycle
        if (visited.contains(i)) {
            return false;
        }
        visited.add(i);
        for (int adj: adjacentList.get(i)) {
            // 相鄰的prev指向i，所以跳過
            if (adj == prev) {
                continue;
            }
            if (!dfs(adj, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        // Create a new list of lists.
        List<List<Integer>> adjacencyList = new ArrayList<>();
        // Initialise an empty list for each node.
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        // Go through the edge list, populating the adjacency list.
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }


        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbour : adjacencyList.get(node)) {
                if (parent.get(node) == neighbour) {
                    continue;
                }
                if (parent.containsKey(neighbour)) {
                    return false;
                }
                stack.push(neighbour);
                parent.put(neighbour, node);
            }
        }

        return parent.size() == n;
    }
}
