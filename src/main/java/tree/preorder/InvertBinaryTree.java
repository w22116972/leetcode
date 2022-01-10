package tree.preorder;

import datastructure.TreeNode;

public class InvertBinaryTree {
    public TreeNode sol(TreeNode root) {
        // base case
        if (root == null) {
            return null;
        }

        // swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        sol(root.left);
        sol(root.right);
        return root;
    }
}
