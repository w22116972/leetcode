package tree.preorder;

class PopulatingNextRightPointersInEachNode {
    static class TreeNNodeWithNext {
        TreeNNodeWithNext right;
        TreeNNodeWithNext left;
        TreeNNodeWithNext next;
    }


    public TreeNNodeWithNext sol(TreeNNodeWithNext root) {
        // base case
        if (root == null) {
            return null;
        }
        connectNextToRight(root.left, root.right);
        return root;
    }

    public void connectNextToRight(TreeNNodeWithNext left, TreeNNodeWithNext right) {
        if (left == null || right == null) {
            return;
        }
        // connect next
        left.next = right;

        // connect next with  same parent
        connectNextToRight(left.left, left.right);
        connectNextToRight(right.left, right.right);

        // connect next across two parents
        connectNextToRight(left.right, right.left);
    }
}
