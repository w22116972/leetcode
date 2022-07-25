package tree.preorder;

import datastructure.TreeNode;

public class InsertIntoBst {
    // return root of newly inserted tree
    public TreeNode insertIntoBstRecursively(TreeNode root, int val) {
        // base case if only root in bst, then create new node for it
        if (root == null) {
            return new TreeNode(val);
        }
        // go left
        if (root.val > val) {
            // assume root of left subtree will be return of root of newly inserted tree given root of left subtree
            root.left = insertIntoBstRecursively(root.left, val);
        }
        // go right
        else if (root.val < val) {
            // assume root of right subtree will be return of root of newly inserted tree given root of right subtree
            root.right = insertIntoBstRecursively(root.right, val);
        }
        // after recursion, we need to return root
        return root;
    }

    public TreeNode insertIntoBstIteratively(TreeNode root, int val) {
        TreeNode current = root;
        while (current != null) {
            // go right
            if (current.val < val) {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    return root;
                }
                current = current.right;
            }

            if (current.val > val) {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    return root;
                }
                current = current.left;
            }
        }
        return new TreeNode(val);
    }
}
