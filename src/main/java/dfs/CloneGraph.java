package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    private HashMap<Node, Node> visitedNodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    public Node dfs(Node node) {
        if (visitedNodes.containsKey(node)) {
            return visitedNodes.get(node);
        } else if (node == null) {
            return null;
        }
        Node clonedNode = new Node(node.val);
        this.visitedNodes.put(node, clonedNode);
        for (Node neighbor: node.neighbors) {
            clonedNode.neighbors.add(dfs(neighbor));
        }
        return clonedNode;
    }


    static class Node {
        Integer val;
        List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
