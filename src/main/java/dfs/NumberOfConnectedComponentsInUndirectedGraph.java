package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NumberOfConnectedComponentsInUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        int[] visited = new int[n];

        List<Integer>[] adjacentList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjacentList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjacentList[edge[0]].add(edge[1]);
            adjacentList[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            // if not yet visited
            if (visited[i] == 0) {
                count++;
                dfs(adjacentList, visited, i);
            }
        }

        return count;
    }

    public void dfs(List<Integer>[] adjacentList, int[] visited, int startNode) {
        visited[startNode] = 1;
        for (int i = 0; i < adjacentList[startNode].size(); i++) {
            if (visited[adjacentList[startNode].get(i)] == 0) {
                dfs(adjacentList, visited, adjacentList[startNode].get(i));
            }
        }
    }





    public int countComponentsInUnionFind(int n, int[][] edges) {
        // Assume every node sees itself as parent node at first
        List<Integer> parentNodeOfEveryNodes = new LinkedList<>();
        List<Integer> nodeNumberOfEachTree = new LinkedList<>();
        // init
        for (int i = 0; i < n; i++) {
            parentNodeOfEveryNodes.add(i);
            nodeNumberOfEachTree.add(1);
        }



        return -1;
    }
}
