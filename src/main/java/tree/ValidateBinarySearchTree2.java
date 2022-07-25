package tree;

import datastructure.TreeNode;

public class ValidateBinarySearchTree2 {
    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) {
            return true;
        } else if (minNode != null && root.val <= minNode.val) {
            return false;
        } else if (maxNode != null && root.val >= maxNode.val) {
            return false;
        } else {
            return isValidBST(root.left, minNode, root) && isValidBST(root.right, root, maxNode);
        }
    }
}
