package tree.preorder;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {

    public List<Integer> iterativePreorder(Node root) {
        final LinkedList<Integer> result = new LinkedList<>();
        final Stack<Node> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            // preorder: process node first
            final Node current = stack.pop();
            result.add(current.val);
            // push nodes into stack
            // to ensure elements will be popped out in left to right order
            // we need to push elements into stack in reversed order
            // e.g. [1,2,3] should be pushed in 3, 2, 1 order, so stack will pop in 1, 2, 3 order
            for (int i = current.children.size() - 1; i >= 0; i--) {
                stack.push(current.children.get(i));
            }
        }
        return result;
    }


    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        recur(root, result);
        return result;
    }

    public void recur(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for(Node node: root.children) {
            recur(node, result);
        }
    }

    static class Node {
        public int val;
        public List<Node> children;
    }
}
