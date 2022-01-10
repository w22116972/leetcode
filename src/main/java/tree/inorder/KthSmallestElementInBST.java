package tree.inorder;

import datastructure.TreeNode;

import java.util.Stack;

public class KthSmallestElementInBST {
    int count = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        recur(root, k);
        return result;
    }

    public void recur(TreeNode current, int k) {
        if (current == null) {
            return;
        }
        // traverse left subtree
        recur(current.left, k);
        // inorder
        count++;
        if (count == k) {
            // 找到第 k 小的元素
            result = current.val;
            return;
        }
        // traverse right subtree
        recur(current.right, k);
    }

    public int kthSmallestRecursively(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        traverse(node.left, k);
        // inorder, what each node should do
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        traverse(node.right, k);
    }

    public int kthSmallestIteratively(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // put ALL left subtree into stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // inorder, what each node should do
            count++;
            current = stack.pop();
            if (count == k) {
                return current.val;
            }
            // put right subtree
            current = current.right;
        }
        return -1;
    }

    // TODO
    public int followUpSol(TreeNode current, int k) {
        return -1;
    }

    static class TreeNodeWithSize {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public int size; // number of nodes when this tree node as root
        public TreeNodeWithSize(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
