package tree;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// Use BFS
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1; // root itself

        while (!queue.isEmpty()) {
            // expand this level
            final int numberOfNodesInThisLevel = queue.size();
            for (int i = 0; i < numberOfNodesInThisLevel; i++) {
                final TreeNode currentNode = queue.poll();
                // check if it is destination
                if (isLeaf(currentNode)) {
                    return depth;
                }
                // add nodes of next level to queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            // go to next level
            depth++;
        }
        return depth;
    }

    public boolean isLeaf(TreeNode treeNode) {
        return treeNode.left == null && treeNode.right == null;
    }
}
