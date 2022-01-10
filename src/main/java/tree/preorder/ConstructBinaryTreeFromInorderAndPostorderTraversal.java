package tree.preorder;

import datastructure.TreeNode;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        // postorder: leftTree | rightTree | root
        // index =   0 ~ leftTreeSize-1 | leftTreeSize ~ postorder.length-2 | postorder.length-1
        // inorder:  leftTree | root | rightTree
        // index = 0 ~ leftTreeSize-1 | leftTreeSize | leftTreeSize+1 ~ inorder.length-1

        int rootVal = postorder[postorder.length - 1];
        final TreeNode root = new TreeNode(rootVal);

        // find size of left tree in inorder
        int leftTreeSize = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                leftTreeSize = i;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(inorder, 0, leftTreeSize), Arrays.copyOfRange(postorder, 0, leftTreeSize));
        root.right = buildTree(Arrays.copyOfRange(inorder, leftTreeSize+1, inorder.length), Arrays.copyOfRange(postorder, leftTreeSize, postorder.length-1));
        return root;
    }
}
