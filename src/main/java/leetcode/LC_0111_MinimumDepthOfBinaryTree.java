package leetcode;

public class LC_0111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }

    // For minimum depth, we need to find the shortest path from root to any leaf node.
    // So we must not consider paths that end at null — because null means the path hasn’t reached a leaf.
    // If a node has only one child, say the left child is null and the right is not, we must continue down the right to reach a leaf.
    private int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return getMinDepth(root.right) + 1;
        }
        if (root.right == null) {
            return getMinDepth(root.left) + 1;
        }
        return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;
    }
}
