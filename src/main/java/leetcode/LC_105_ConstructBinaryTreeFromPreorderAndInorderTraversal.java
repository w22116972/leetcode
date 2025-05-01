package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // find root in inorder, left part is the left subtree, right part is the right subtree
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // To store the index of each value in the inorder array,
        // so we can look them up in constant time. That avoids a linear scan every time
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    // To solve this problem recursively,
    // we need a helper function that takes additional parameters to track the current subrange of the preorder and inorder arrays we’re working with.
    // The main function only receives the full arrays,
    // so we create a separate recursive function with start and end indices to handle the subarrays efficiently without creating new arrays at each step
    /**
     * @param preorder the preorder traversal of the binary tree
     * @param preStart starting index of the current subtree in preorder
     * @param preEnd ending index of the current subtree in preorder
     * @param inStart starting index of the current subtree in inorder
     * @param inEnd ending index of the current subtree in inorder
     * **/

    private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        // If the subtree is empty, so we return null
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // The first node in preorder is the root node
        int rootVal = preorder[preStart];
        // preorder: [preStart(root), <left>, <right> preEnd]
        // inorder: [inStart<left>, root, <right> inEnd]
        int rootIndexInInorder = inorderIndexMap.get(rootVal);
        // inStart represents the beginning of the inorder subarray in the current recursion
        // It's used (together with rootIndexInInorder) to calculate the size and range of the left subtree
        int leftTreeSize = rootIndexInInorder - inStart;
        // preorder: [root, ..., root + leftTreeSize (last left), ...,

        TreeNode root = new TreeNode(rootVal);
        // We need to exclude the root from preorder and inorder subarrays
        // preorder: [preStart(root), <left>, <right>preEnd] -> [preStart + 1, preStart + leftTreeSize(last left), ..., preEnd]
        // - left subtree: [preStart + 1, preStart + leftTreeSize]
        // - right subtree: [preStart + leftTreeSize + 1, preEnd]

        // inorder: [inStart<left>, root, <right>inEnd] -> [inStart, rootIndexInInorder - 1(last left), inEnd]
        // - left subtree: [inStart, rootIndexInInorder - 1]
        // - right subtree: [rootIndexInInorder + 1, inEnd]
        root.left = build(preorder, preStart + 1, preStart + leftTreeSize, inStart, rootIndexInInorder - 1);
        root.right = build(preorder, preStart + leftTreeSize + 1, preEnd, rootIndexInInorder + 1, inEnd);

        return root;
    }
}
