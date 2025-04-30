package leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity = O(n), where n is the number of nodes in the tree
// Space Complexity = O(h), where h is the height of the tree
public class LC_0094_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseInorder(root, result);
        return result;
    }

    private void traverseInorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        traverseInorder(root.left, result);
        result.add(root.val);
        traverseInorder(root.right, result);
    }
}
