# 2020.01.17
# Problem Statement:
# https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        new_head, new_tail = self.flattenHelper(root)
        return
    
    def flattenHelper(self, root):
        # recursion
        # set the left sub-tree to linked list, set the right sub-tree to linked list, then connect them with the root

        # base cases
        if not root: return None, None
        if not root.left and not root.right: return root, root

        left_head, left_tail = self.flattenHelper(root.left)
        right_head, right_tail = self.flattenHelper(root.right)        
        
        # both left and right sub-tree exists
        if left_head and right_head:
            root.right = left_head
            root.left = None
            left_tail.right = right_head
            left_tail.left = None
            return root, right_tail
        # only right sub-tree exists
        elif not left_head:
            root.right = right_head
            root.left = None
            return root, right_tail
        # only left sub-tree exists
        elif not right_head:
            root.right = left_head
            root.left = None
            left_tail.left = None
            return root, left_tail
            
        
        
        