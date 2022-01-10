package tree.postorder;

import datastructure.TreeNode;

public class MaxPathSum {
    int globalMaxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        int leftMaxPathSum = Math.max(0, maxPathSum(root.left));
        int rightMaxPathSum = Math.max(0, maxPathSum(root.right));

        // post-order
//        int localMaxSum = Math.max()
        // TODO
        return -1;
    }
}
