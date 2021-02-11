# 2020.02.11
# Happy Chinese New Year!
# Problem Statement:
# https://leetcode.com/problems/binary-tree-maximum-path-sum/
# Couldn't come up with such a brilliant solution, so looked up the discussion here:
# https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        # idea:
        # a path always have a highest node, the highest means level instead of value
        # self.maxPathSumHelper(root) would always calculate the max path sum with the root as the highest value,
        # and will return the max possible partial path sum which could be merged into other nodes above
        self.maxSum = -inf
        temp = self.maxPathSumHelper(root)
        return self.maxSum
        
    def maxPathSumHelper(self, root):
        if not root:
            return 0
        
        # the max sum for left and right sub-tree
        leftSum = self.maxPathSumHelper(root.left)
        rightSum = self.maxPathSumHelper(root.right)

        # 1. connect with the left max path, 2. connect with the right max path, 3. connect with both max path, 4. only take the root
        self.maxSum = max(self.maxSum, leftSum+root.val, rightSum+root.val, leftSum+rightSum+root.val, root.val)

        # return the max possible partial sum it could provide
        return root.val+max(leftSum, rightSum, 0)