# 2020.01.16
# Problem Statement:
# https://leetcode.com/problems/path-sum/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        # DFS approach

        # check empty cases
        if not root: return False
        # set up global variable, pass in is also fine
        self.sum = sum
        return self.hasPathSumHelper(root, 0)
    
    def hasPathSumHelper(self, root, sum):
        # already to the leaf and not satisfied, return False
        if not root: return False
        
        # check if equals to the sum, also if it's leaf
        sum = sum + root.val
        if sum == self.sum and self.isLeaf(root):
            return True
        else:
            # check the next level
            left = self.hasPathSumHelper(root.left, sum)
            right = self.hasPathSumHelper(root.right, sum)
            return (left or right)
    
    def isLeaf(self, root):
        if not root.left and not root.right: return True
        return False