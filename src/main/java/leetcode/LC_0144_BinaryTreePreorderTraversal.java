package leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity = O(n), where n is the number of nodes in the tree
// Space Complexity = O(h), where h is the height of the tree
public class LC_0144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraverse(root, result);
        return result;
    }

    private void preorderTraverse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraverse(root.left, result);
        preorderTraverse(root.right, result);
    }
}
