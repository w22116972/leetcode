package solution;

import java.util.Stack;

public class RangeSumOfBST {


    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum += recur(root, low, high);
        return sum;
    }

    private int recur(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val >= low && root.val <= high) {
            return root.val + recur(root.left, low, high) + recur(root.right, low, high);
        } else {
            return recur(root.left, low, high) + recur(root.right, low, high);
        }

    }


    public int rangeSumBSTIteratively(TreeNode root, int low, int high) {
        int sum = 0;
        // use stack to store nodes
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode.val >= low && currentNode.val <= high) {
                sum += currentNode.val;
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }

        return sum;
    }
}
