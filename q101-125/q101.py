# 2020.01.09
# Problem Statement:
# https://leetcode.com/problems/symmetric-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        # left: pre-order traversal
        # right: post-order traversal
        # just check if left and right are "same" with different traverse orders
        # can use the same function as question 100
        
        if not root: return True
        if root.left is None: return root.right is None
        if root.right is None: return root.left is None
        
        left_root, right_root = root.left, root.right
        self.answer = True
        return self.isSymmetricHelper(left_root, right_root)
        
    def isSymmetricHelper(self, p, q):
        # one of the tree is already went through
        if p is None: 
            self.answer = self.answer and (q is None)
            return self.answer
        if q is None:
            self.answer = self.answer and (p is None)
            return self.answer
        
        # p in order traversal, q post order traversal
        # please note the opposition of left and right
        if p.left is not None: 
            self.isSymmetricHelper(p.left, q.right)
        else:
            # check if q has extra left subtree
            self.answer = self.answer and (q.right is None)
        
        # do the value comparison
        self.answer = self.answer and (p.val == q.val)
        
        if p.right is not None:
            self.isSymmetricHelper(p.right, q.left)
        else:
            # check if q has extra right subtree
            self.answer = self.answer and (q.left is None)
        
        return self.answer
        
        