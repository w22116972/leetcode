package tree.postorder;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public List<Integer> iterativeTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        TreeNode visited = new TreeNode(-1); // set dummy value initially
        Stack<TreeNode> stack = new Stack<>();

        pushAllLeftSubtreesIntoStack(root, stack);
        while (!stack.isEmpty()) {
            // To check subtree whether is visited
            final TreeNode current = stack.peek();
            // if left subtree is already empty
            // or if left subtree is visited
            if ((current.left == null || current.left == visited) && current.right != visited) {
                // inorder traverse code here, after visited left and before pushed right subtree
                // traverse right subtree
                pushAllLeftSubtreesIntoStack(current.right, stack);
            }

            if (current.right == null || current.right == visited) {
                // postorder code here, after visited both subtrees
                result.add(current.val);
                // end of currentNode operation, update visited
                visited = stack.pop();
            }
        }
        return result;
    }

    private void pushAllLeftSubtreesIntoStack(TreeNode current, Stack<TreeNode> stack) {
        while (current != null) {
            // preorder code here, before pushed left subtree into stack
            stack.push(current);
            current = current.left;
        }
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
        recur(current.right, result);
        result.add(current.val);
    }
}
