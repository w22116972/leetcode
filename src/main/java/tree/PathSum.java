package tree;

import datastructure.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else if (root.val == targetSum) {
            return true;
        }
        return hasPathSumRecur(root.left, targetSum, root.val) || hasPathSumRecur(root.right, targetSum, root.val);
    }

    public boolean hasPathSumRecur(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return false;
        } else if (isLeaf(root)) {
            return currentSum + root.val == targetSum;
        } else {
            return hasPathSumRecur(root.left, targetSum, currentSum + root.val) || hasPathSumRecur(root.right, targetSum, currentSum + root.val);
        }
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
