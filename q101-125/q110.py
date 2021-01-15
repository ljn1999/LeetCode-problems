# 2020.01.15
# Sorry, was not in good mood yesterday
# Problem Statement:
# https://leetcode.com/problems/balanced-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if not root: return True       

        # recursion
        # left sub-tree balanced && right sub-tree balanced && abs(left height - right height) <= 1
        # what the height is doesn't really matter
        self.answer = True
        height = self.isBalancedHelper(root)
        return self.answer
        
    def isBalancedHelper(self, root):
        if not root: return 0
        
        left_height = self.isBalancedHelper(root.left)
        right_height = self.isBalancedHelper(root.right)        
        
        # once there is a unbalanced sub-tree, can stop all operations, no need to return anything
        if self.answer:
            if abs(left_height - right_height) > 1:
                self.answer = False
            else:
                if left_height >= right_height:
                    return left_height + 1
                else:
                    return right_height + 1