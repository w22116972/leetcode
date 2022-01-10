from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class HouseRobberIII:
    top_down_dp = {}

    def top_down(self, root: Optional[TreeNode]) -> int:
        # base case
        if root is None:
            return 0
        # utilize dp table
        if root in self.top_down_dp:
            return self.top_down_dp.get(root)

        # if rob this house
        rob_result = root.val + 0 if root.left is None else (self.top_down(root.left.left) + self.top_down(root.left.right)) + 0 if root.right is None else (self.top_down(root.right.left) + self.top_down(root.right.right))

        # if not rob this house
        no_rob_result = self.top_down(root.left) + self.top_down(root.right)

        better_rob = max(rob_result, no_rob_result)

        self.top_down_dp[root] = better_rob
        return better_rob
