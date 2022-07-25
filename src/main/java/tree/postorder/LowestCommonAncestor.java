package tree.postorder;

import datastructure.TreeNode;

import java.util.Objects;

public class LowestCommonAncestor {
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) {
            return null;
        } else if (root == p || root == q) {
            return root;
        }
        // postorder
        TreeNode lcaInLeftSubtree = lowestCommonAncestor(root.left, p, q);
        TreeNode lcaInRightSubtree = lowestCommonAncestor(root.right, p, q);

        // at lowest
        if (lcaInLeftSubtree != null && lcaInRightSubtree != null) {
            return root;
        } else
            if (lcaInLeftSubtree == null && lcaInRightSubtree == null) {
            return null;
        } else return Objects.requireNonNullElse(lcaInLeftSubtree, lcaInRightSubtree);
    }
}
