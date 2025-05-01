package leetcode;

// Time complexity: O(n)
// Space complexity: O(n), recursive stack
// Use preorder traversal
public class LC_0226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
