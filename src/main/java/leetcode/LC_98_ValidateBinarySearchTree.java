package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        toInorder(root, inorder);

        if (inorder.size() == 1) {
            return true;
        }
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void toInorder(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }
        toInorder(root.left, inorder);
        inorder.add(root.val);
        toInorder(root.right, inorder);
    }
}
