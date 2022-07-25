package tree;

import datastructure.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymRecur(root.left, root.right);
    }

    public boolean isSymRecur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return isSymRecur(left.left, right.right) && isSymRecur(left.right, right.left);
        }
    }
}
