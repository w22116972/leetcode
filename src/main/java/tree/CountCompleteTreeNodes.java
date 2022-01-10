package tree;

import datastructure.TreeNode;

public class CountCompleteTreeNodes {
    // BUT! T = O(n)
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    //
    public int countNodesInNTime(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // calculate left subtree height
        int heightOfLeftSubtree = 0;
        TreeNode leftTraversingNode = root;
        while (leftTraversingNode != null) {
            leftTraversingNode = leftTraversingNode.left;
            heightOfLeftSubtree++;
        }

        // calculate right subtree height
        int heightOfRightSubtree = 0;
        TreeNode rightTraversingNode = root;
        while (rightTraversingNode != null) {
            rightTraversingNode = rightTraversingNode.right;
            heightOfRightSubtree++;
        }
        if (heightOfLeftSubtree == heightOfRightSubtree) { // there is full BT
            return (int)Math.pow(2, heightOfLeftSubtree) - 1;
        }
        return 1 + countNodesInNTime(root.left) + countNodesInNTime(root.right);
    }
}
