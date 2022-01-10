package tree.inorder;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public List<Integer> iterativeTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // put left subtree into stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // inorder, handle node
            current = stack.pop();
            result.add(current.val); // handle node

            // traverse right
            current = current.right;
        }
        return result;
    }

    public List<Integer> recursiveTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        recur(root, result);
        return result;
    }

    public void recur(TreeNode current, List<Integer> result) {
        if (current == null) {
            return;
        }
        recur(current.left, result);
        result.add(current.val);
        recur(current.right, result);
    }
}
