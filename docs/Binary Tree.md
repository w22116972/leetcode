# Binary Tree


## Traversal → Processing Order Analogy

| Traversal Type | Processing Order        | Usage Pattern                                                                          |
|----------------|-------------------------|----------------------------------------------------------------------------------------|
| Pre-order      | Node → Left → Right     | **Top-down**: useful when you pass data from parent to children                        |
| In-order       | Left → Node → Right     | Symmetric/Between-children processing, mostly for in-order access, especially in BSTs  |
| Post-order     | Left → Right → Node     | **Bottom-up**: useful when you need results from children first                        |

### preorder traversal

- [144. Binary Tree Preorder Traversal](../src/main/java/leetcode/LC_144_BinaryTreePreorderTraversal.java)
- [226. Invert Binary Tree](../src/main/java/leetcode/LC_226_InvertBinaryTree.java)
  - swap left and right child then traverse the left and right child
- [105. Construct Binary Tree from Preorder and Inorder Traversal](../src/main/java/leetcode/LC_105_ConstructBinaryTreeFromPreorderAndInorderTraversal.java)
  - use preorder to find the root node, use inorder to find the left and right subtree
  - use indices to track the range of the preorder and inorder array

### inorder traversal

- [94. Binary Tree Inorder Traversal](../src/main/java/leetcode/LC_94_BinaryTreeInorderTraversal.java)
- [98. Validate Binary Search Tree](../src/main/java/leetcode/LC_98_ValidateBinarySearchTree.java)
  - check the inorder of the BST is increasing

### postorder traversal

- [145. Binary Tree Postorder Traversal](../src/main/java/leetcode/LC_145_BinaryTreePostorderTraversal.java)
- [104. Maximum Depth of Binary Tree](../src/main/java/leetcode/LC_104_MaximumDepthOfBinaryTree.java)
  - use postorder to find the maximum depth of the left and right subtree, then return the maximum depth of the two subtrees + 1
- [111. Minimum Depth of Binary Tree](../src/main/java/leetcode/LC_111_MinimumDepthOfBinaryTree.java)
  - for minimum depth, we need to check if the left or right subtree is null because if one of them is null, we need to return the depth of the other subtree + 1 (maximum depth question doesn't need to care about this)
- [110. Balanced Binary Tree](../src/main/java/leetcode/LC_110_BalancedBinaryTree.java)
  - use postorder to find the maximum depth of the left and right subtree, then check if the difference between the two subtrees is less than or equal to 1


### level order traversal

- [102. Binary Tree Level Order Traversal](../src/main/java/leetcode/LC_102_BinaryTreeLevelOrderTraversal.java)
  - use queue to store nodes to be traversed
  - use size of queue to determine the number of nodes at each level, we just need to traverse the queue size times (newly added nodes will be added to the end of queue)
