# 2020.02.15
# Problem Statement:
# https://leetcode.com/problems/sum-root-to-leaf-numbers/
# Feeling bad for being unable to come up with the solution on my own
# https://leetcode.com/problems/sum-root-to-leaf-numbers/discuss/41363/Short-Java-solution.-Recursion.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root: return 0
        return self.sumNumbersHelper(root, 0)
    
    def sumNumbersHelper(self, root, currentSum):
        if not root: return 0

        # include current node's value into currentSum
        currentSum = 10*currentSum + root.val
        
        # if reaches the leaf, this path is finished
        if not root.left and not root.right: return currentSum

        leftSum = self.sumNumbersHelper(root.left, currentSum)
        rightSum = self.sumNumbersHelper(root.right, currentSum)

        # add up left path and right path
        return leftSum + rightSum
        