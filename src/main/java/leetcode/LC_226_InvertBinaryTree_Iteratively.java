package leetcode;

import java.util.Stack;

// Time complexity: O(n)
// Space complexity: O(n), recursive stack
// Use preorder traversal
public class LC_226_InvertBinaryTree_Iteratively {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {

        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
