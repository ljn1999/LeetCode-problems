# 2020.01.02
# Problem Statement:
# https://leetcode.com/problems/binary-tree-inorder-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversalHelper(self, root):
        # left, this, right
        if root.left is not None:
            self.inorderTraversalHelper(root.left)

        self.answer.append(root.val)

        if root.right is not None:
            self.inorderTraversalHelper(root.right)
            
        return
    
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        # check empty tree
        if root is None: return  
        
        # initializa answer to return
        self.answer = []
        
        # do traverse
        self.inorderTraversalHelper(root)
            
        return self.answer