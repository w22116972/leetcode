package dp;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    // TLE
    public int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int robResult = root.val
                + (root.left == null? 0:recursion(root.left.left) + recursion(root.left.right))
                + (root.right == null? 0:recursion(root.right.left) + recursion(root.right.right));
        int notRobResult = recursion(root.left) + recursion(root.right);
        return Math.max(robResult, notRobResult);
    }

    Map<TreeNode, Integer> memo = new HashMap<>();
    public int topDown(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int robResult = root.val
                + (root.left == null? 0:topDown(root.left.left) + topDown(root.left.right))
                + (root.right == null? 0:topDown(root.right.left) + topDown(root.right.right));
        int notRobResult = topDown(root.left) + topDown(root.right);

        int betterChoice = Math.max(robResult, notRobResult);
        memo.put(root, betterChoice);
        return betterChoice;
    }

    // use array with 2 element to represent result of robbing or not
    // S = O(1)
    // arr[0]: maximal money with robbing
    // arr[1]: maximal money without robbing
    public int optimize(TreeNode root) {
        int[] result = optimizeRecur(root);
        return Math.max(result[0], result[1]);
    }

    public int[] optimizeRecur(TreeNode current) {
        if (current == null) {
            return new int[]{0, 0};
        }
        final int[] left = optimizeRecur(current.left);
        final int[] right = optimizeRecur(current.right);

        // if we rob, then next subtree can't rob, so choose index=1
        int robResult = current.val + left[1] + right[1];
        // next subtree can be robbed or not
        int notRobResult = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{robResult, notRobResult};
    }
}
