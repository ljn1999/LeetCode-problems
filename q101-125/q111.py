# 2020.01.16
# Problem Statement:
# https://leetcode.com/problems/minimum-depth-of-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: TreeNode) -> int:
        # check empty cases
        if not root: return 0
        # reach the leaf
        if not root.left and not root.right:
            return 1
        # only has left sub-tree, then should set the depth of right sub-tree to inf, instead of 0
        elif not root.left:
            left_height = inf
            right_height = self.minDepth(root.right)
        # only has right sub-tree, then should set the depth of left sub-tree to inf, instead of 0
        elif not root.right:
            left_height = self.minDepth(root.left)
            right_height = inf
        else:
            left_height = self.minDepth(root.left)
            right_height = self.minDepth(root.right)
        
        # only get the min of depth + 1
        if left_height <= right_height:
            return left_height + 1
        else:
            return right_height + 1

        
        
            