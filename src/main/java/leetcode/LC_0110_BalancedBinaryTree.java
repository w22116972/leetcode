package leetcode;

public class LC_0110_BalancedBinaryTree {

    /**
     * To determine whether the binary tree is height-balanced,
     * I use a bottom-up DFS approach.
     * That means I traverse down to the leaf nodes first and compute the height of each subtree as I return up the call stack.
     * At each node, I compare the heights of its left and right subtrees.
     * If the difference is more than one, I mark the subtree as unbalanced.
     * This bottom-up approach ensures that I only check each node once and avoid redundant calculations,
     * which makes the solution efficient — O(n) time.
     * */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    /**
     * Post-order traversal is used in this case because whether a node is balanced depends on the height of its left and right subtrees.
     * So I can’t evaluate the balance condition at a node until I’ve finished traversing both children.
     * That’s exactly what post-order ensures that both subtrees are fully processed before handling the current node.
     * Use -1 as a sentinel value to indicate an unbalanced subtree.
     * */
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        // The left subtree is not balanced
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(node.right);
        // The right subtree is not balanced
        if (rightHeight == -1) {
            return -1;
        }

        // Check whether the current node is unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
