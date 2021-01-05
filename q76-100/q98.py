# 2020.01.05
# Problem Statement:
# https://leetcode.com/problems/validate-binary-search-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        # isValidBST(root) = left sub-tree valid and right sub-tree valid 
        # and max in left sub-tree < root < min in right sub-tree
        
        # base case
        if root.left is None and root.right is None:
            return True
        
        if root.left is None:
            # get the min in right sub-tree
            ptr = root.right
            while ptr.left is not None:
                ptr = ptr.left
            min_right = ptr.val
            return root.val < min_right and self.isValidBST(root.right)
        
        if root.right is None:
            # get the max in left sub-tree
            ptr = root.left
            while ptr.right is not None:
                ptr = ptr.right
            max_left = ptr.val
            return root.val > max_left and self.isValidBST(root.left)
        
        # get the min in right sub-tree and the max in left sub-tree
        ptr = root.right
        while ptr.left is not None:
            ptr = ptr.left
        min_right = ptr.val
        
        ptr = root.left
        while ptr.right is not None:
            ptr = ptr.right
        max_left = ptr.val
        
        return self.isValidBST(root.left) and self.isValidBST(root.right) \
               and max_left < root.val and min_right > root.val
        