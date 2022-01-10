package tree.inorder;

import datastructure.TreeNode;

import java.util.Stack;

public class ConvertBstToGreaterTree {
    int sum = 0;
    public TreeNode convertBSTRecursively(TreeNode root) {
        recur(root);
        return root;
    }

    private void recur(TreeNode current) {
        if (current == null) {
            return;
        }
        // To traverse desc order with inorder
        recur(current.right);
        // inorder
        sum += current.val;
        current.val = sum;
        recur(current.left);
    }

    public TreeNode convertBstIteratively(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }
            current = stack.pop();
            sum += current.val;
            current.val = sum;

            current = current.left;
        }
        return root;
    }
}
