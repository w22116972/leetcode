package tree.inorder;

import datastructure.TreeNode;

import java.util.Optional;
import java.util.Stack;

public class ValidateBinarySearchTree {
    TreeNode prev;
    public boolean validateBstRecursively(TreeNode root) {
        return recur(root);
    }

    public boolean recur(TreeNode current) {
        if (current == null) {
            return true;
        }
        boolean isLeftValid = recur(current.left);
        // inorder
        if (prev != null && prev.val >= current.val) {
            return false;
        }
        prev = current;
        boolean isRightValid = recur(current.right);
        return isLeftValid && isRightValid;
    }

    public boolean validateBstIteratively(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode prev = null;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                // traverse left
                current = current.left;
            }

            // what each node should do
            current = stack.pop();
            if (prev != null && prev.val >= current.val) {
                return false;
            }
            prev = current;


            // traverse right
            current = current.right;
        }
        return true;
    }


    public boolean recursive2(TreeNode root) {
        return recur2(root, null, null);
    }

    public boolean recur2(TreeNode current, Integer min, Integer max) {
        if (current == null) {
            return true;
        }
        if ((min != null && min >= current.val) || (max != null && current.val <= max)) {
            return false;
        }
        final int currentVal = current.val;
        return recur2(current.left, min, currentVal) && recur2(current.right, currentVal, max);
    }
}
