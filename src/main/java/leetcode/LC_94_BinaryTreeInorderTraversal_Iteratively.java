package leetcode;

import java.util.*;

// Time Complexity = O(n), where n is the number of nodes in the tree
// Space Complexity = O(h), where h is the height of the tree
public class LC_94_BinaryTreeInorderTraversal_Iteratively {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // DFS, use Stack
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
}
