package leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity = O(n), where n is the number of nodes in the tree
// Space Complexity = O(h), where h is the height of the tree
public class Q145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraverse(root, result);
        return result;
    }

    private void postorderTraverse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderTraverse(root.left, result);
        postorderTraverse(root.right, result);
        result.add(root.val);
    }
}
