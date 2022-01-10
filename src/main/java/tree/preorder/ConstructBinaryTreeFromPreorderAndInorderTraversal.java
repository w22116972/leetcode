package tree.preorder;

import datastructure.TreeNode;

import java.util.Arrays;

public class    ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // base case
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // first element in preorder is root
        int rootVal = preorder[0];
        // find index of rootVal in inorder
        int indexOfRootInInorder = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                indexOfRootInInorder = i;
            }
        }
        // Preorder: root | root.left | root.right
        //   index =  0   | 1 ~ leftTreeSize | leftTreeSize+1 ~ preorder.length-1

        // Inorder: root.left | root | root.right
        //  index = 0 ~ leftTreeSize-1 | leftTreeSize | leftTreeSize+1 ~ inorder.length-1

        // index of root in Inorder := size of root.left (left tree)
        // root.left -> Preorder(1, leftTreeSize+1) + Inorder(0,

        // note: Arrays.copyOfRange `to` is not inclusive, we need to plus one on index
        int leftTreeSize = indexOfRootInInorder;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, leftTreeSize + 1), Arrays.copyOfRange(inorder, 0, leftTreeSize));
        root.right = buildTree(Arrays.copyOfRange(preorder, leftTreeSize + 1, preorder.length), Arrays.copyOfRange(inorder, leftTreeSize+1, inorder.length));
        return root;
    }
}
