package tree;

import datastructure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeAndDeserializeTree {
//    String separate


    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        appendRecur(root, builder);
        return builder.toString();
    }

    // use "-" to represent null node
    public void appendRecur(TreeNode current, StringBuilder builder) {
        if (current == null) {
            builder.append("-").append(",");
        } else {
            builder.append(current.val).append(",");
            appendRecur(current.left, builder);
            appendRecur(current.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        final LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeRecur(list);
    }

    public TreeNode deserializeRecur(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        // since it is preorder, so most left node is root
        String rootValue = nodes.removeFirst();
        if (rootValue.equals("-")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootValue));
        root.left = deserializeRecur(nodes);
        root.right = deserializeRecur(nodes);
        return root;
    }
}


