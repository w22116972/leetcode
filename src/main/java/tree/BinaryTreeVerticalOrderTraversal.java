package tree;

import datastructure.TreeNode;
import lombok.Getter;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        HashMap<Integer, List<Integer>> nodesByColumnIndex = new HashMap<>();
        Queue<ToBeVisitedNode> toBeVisitedNodeQueue = new LinkedList<>();
        int columnIndex = 0;
        toBeVisitedNodeQueue.offer(new ToBeVisitedNode(root, columnIndex));
        while (!toBeVisitedNodeQueue.isEmpty()) {
            final ToBeVisitedNode toBeVisitedNode = toBeVisitedNodeQueue.poll();
            final TreeNode currentNode = toBeVisitedNode.getTreeNode();
            final Integer currentColumnIndex = toBeVisitedNode.getColumnIndex();
            if (currentNode != null) {
                if (!nodesByColumnIndex.containsKey(currentColumnIndex)) {
                    nodesByColumnIndex.put(currentColumnIndex, new ArrayList<>());
                }
                nodesByColumnIndex.get(currentColumnIndex).add(currentNode.val);
                toBeVisitedNodeQueue.offer(new ToBeVisitedNode(currentNode.left, currentColumnIndex - 1));
                toBeVisitedNodeQueue.offer(new ToBeVisitedNode(currentNode.right, currentColumnIndex + 1));
            }
        }
        final ArrayList<Integer> sortedKeys = new ArrayList<>(nodesByColumnIndex.keySet());
        Collections.sort(sortedKeys);
        for (int i: sortedKeys) {
            result.add(nodesByColumnIndex.get(i));
        }
        return result;
    }

    static class ToBeVisitedNode {
        @Getter
        TreeNode treeNode;
        @Getter
        Integer columnIndex;

        public ToBeVisitedNode(TreeNode treeNode, Integer columnIndex) {
            this.treeNode = treeNode;
            this.columnIndex = columnIndex;
        }
    }
}
