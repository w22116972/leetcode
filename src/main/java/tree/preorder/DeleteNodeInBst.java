package tree.preorder;

import datastructure.TreeNode;

public class DeleteNodeInBst {
    // root of newly deleted tree
    public TreeNode deleteNode(TreeNode root, int key) {
        // base case
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            // if this node has no children
            if (root.left == null && root.right == null) {
                return null;
            }
            // if this node has one child
            else if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            // if this node has two children
            else { // if (root.right != null && root.left != null)
                TreeNode minNodeInRightSubtree = findMinNodeInBst(root.right);
                minNodeInRightSubtree.left = root.left;
                minNodeInRightSubtree.right = root.right;

            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    // min node is the left most
    public TreeNode findMinNodeInBst(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
