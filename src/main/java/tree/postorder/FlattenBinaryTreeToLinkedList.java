package tree.postorder;

import datastructure.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // let left subtree been flattened cursively
        flatten(root.left);
        // let right subtree been flattened cursively
        flatten(root.right);

        // Post-order traversal
        // now we can assume left and right are flattened already
        TreeNode leftSubtree = root.left;
        TreeNode rightSubtree = root.right;
        // 1. put left subtree at the root right place
        root.left = null;
        root.right = leftSubtree;
        // 2. traverse to the most right and place right subtree here
        // find most right place with n
        TreeNode n = root;
        while (n.right != null) {
            n = n.right;
        }
        n.right = rightSubtree;
    }
}
