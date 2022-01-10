package tree.preorder;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            // handle preorder
            final TreeNode currentNode = stack.pop();
            result.add(currentNode.val);
            // We need to push from right to left
            // so that stack will be popped out from left to right
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }

        }
        return result;
    }

    public List<Integer> recurSol(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        recur(root, result);
        return result;
    }

    public void recur(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        recur(root.left, result);
        recur(root.right, result);
    }

    public static void main(String[] args) {

    }
}
