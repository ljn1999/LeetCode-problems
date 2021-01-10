# 2020.01.09
# Problem Statement:
# https://leetcode.com/problems/same-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        # check empty trees
        if p is None: return q is None
        if q is None: return p is None
        
        self.answer = True
        return self.isSameTreeHelper(p, q)
    
    def isSameTreeHelper(self, p, q):
        # one of the tree is already went through
        if p is None: 
            self.answer = self.answer and (q is None)
            return self.answer
        if q is None:
            self.answer = self.answer and (p is None)
            return self.answer
        
        # in order traversal
        if p.left is not None: 
            self.isSameTreeHelper(p.left, q.left)
        else:
            # check if q has extra left subtree
            self.answer = self.answer and (q.left is None)
        
        # do the value comparison
        self.answer = self.answer and (p.val == q.val)
        
        if p.right is not None:
            self.isSameTreeHelper(p.right, q.right)
        else:
            # check if q has extra right subtree
            self.answer = self.answer and (q.right is None)
        
        return self.answer