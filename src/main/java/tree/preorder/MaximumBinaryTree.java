package tree.preorder;

import datastructure.TreeNode;

import java.util.Arrays;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        // find max and its index in nums
        int max = -1;
        int indexOfMax = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                indexOfMax = i;
            }
        }
        // construct root
        TreeNode root = new TreeNode(max);

        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, indexOfMax));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, indexOfMax + 1, nums.length));
        return root;
    }
}
