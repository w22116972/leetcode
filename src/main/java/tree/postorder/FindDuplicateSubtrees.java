package tree.postorder;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        HashMap<String, Integer> paths = new HashMap<>();
        buildTreePath(root, paths, result);
        return result;
    }

    public String buildTreePath(TreeNode root, HashMap<String, Integer> paths, List<TreeNode> result) {
        if (root == null) {
            return "#"; // Arbitrary char to represent null
        }

        String leftTreePath = buildTreePath(root.left, paths, result);
        String rightTreePath = buildTreePath(root.right, paths, result);
        String rootTreePath = leftTreePath + "," + rightTreePath + "," + root.val;
        if (paths.containsKey(rootTreePath)) {
            paths.put(rootTreePath, paths.get(rootTreePath) + 1);
        } else {
            paths.put(rootTreePath, 1);
        }
        if (paths.get(rootTreePath) == 2) {
            result.add(root);
        }
        return rootTreePath;
    }
}
