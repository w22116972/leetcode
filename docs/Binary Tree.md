# Binary Tree

#### preorder/inorder/postorder traversal

- [144. Binary Tree Preorder Traversal](../src/main/java/leetcode/LC_0144_BinaryTreePreorderTraversal.java)
- [94. Binary Tree Inorder Traversal](../src/main/java/leetcode/LC_0094_BinaryTreeInorderTraversal.java)
- [145. Binary Tree Postorder Traversal](../src/main/java/leetcode/LC_0145_BinaryTreePostorderTraversal.java)
- [102. Binary Tree Level Order Traversal](../src/main/java/leetcode/LC_0102_BinaryTreeLevelOrderTraversal.java)
  - use queue to store nodes to be traversed
  - use size of queue to determine the number of nodes at each level, we just need to traverse the queue size times (newly added nodes will be added to the end of queue)
