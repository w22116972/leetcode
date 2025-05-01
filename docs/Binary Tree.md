# Binary Tree

### preorder traversal

- [144. Binary Tree Preorder Traversal](../src/main/java/leetcode/LC_0144_BinaryTreePreorderTraversal.java)
- [226. Invert Binary Tree](../src/main/java/leetcode/LC_0226_InvertBinaryTree.java)
  - swap left and right child then traverse the left and right child
- [105. Construct Binary Tree from Preorder and Inorder Traversal](../src/main/java/leetcode/LC_0105_ConstructBinaryTreeFromPreorderAndInorderTraversal.java)
  - use preorder to find the root node, use inorder to find the left and right subtree


### inorder traversal

- [94. Binary Tree Inorder Traversal](../src/main/java/leetcode/LC_0094_BinaryTreeInorderTraversal.java)

### postorder traversal

- [145. Binary Tree Postorder Traversal](../src/main/java/leetcode/LC_0145_BinaryTreePostorderTraversal.java)

### level order traversal

- [102. Binary Tree Level Order Traversal](../src/main/java/leetcode/LC_0102_BinaryTreeLevelOrderTraversal.java)
  - use queue to store nodes to be traversed
  - use size of queue to determine the number of nodes at each level, we just need to traverse the queue size times (newly added nodes will be added to the end of queue)
