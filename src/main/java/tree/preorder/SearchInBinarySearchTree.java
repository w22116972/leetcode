package tree.preorder;

import datastructure.TreeNode;

public class SearchInBinarySearchTree {
    public TreeNode searchBstRecursively(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBstRecursively(root.left, val);
        } else {  // root.val < val
            return searchBstRecursively(root.right, val);
        }
    }

    public TreeNode searchBstIteratively(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
