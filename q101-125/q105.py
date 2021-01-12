# 2020.01.11
# Problem Statement:
# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
# Glad to come up with the solution on my own :-)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        # check empty cases
        if len(preorder) == 0: return None
        
        # overall logic:

        # the first node in preorder must be the root

        # if the index of the root in inorder list is x
        # from index 0 to index x-1 (inclusive) would be the nodes of the left sub-tree, update the inorder list for left sub-tree
        # from index x+1 to the last index (inclusive) would be the nodes of the right sub-tree, update the inorder list for right sub-tree

        # connection
        # connect the left of the root to the second node in preorder
        # connect the right of the root to the (1+number of nodes in left sub-tree+1)th node in preorder

        # update preorder list to be [the node after root :]
        # update preorder list to be [the node after (root + all left sub-tree nodes) :]
        
        root = TreeNode(preorder[0])
        self.buildTreeHelper(preorder, inorder, root)
        return root
    
    def buildTreeHelper(self, preorder, inorder, root):
        # base case
        if len(inorder)*len(preorder) == 0: return
        
        if inorder_idx != 0:
            left_inorder = inorder[:inorder_idx]
        else:
            left_inorder = []
        
        if inorder_idx != len(inorder)-1:
            right_inorder = inorder[inorder_idx+1:]
        else:
            right_inorder = []
        
        if len(left_inorder) != 0:
            root.left = TreeNode(preorder[1])
        
        if len(right_inorder) != 0:
            root.right = TreeNode(preorder[len(left_inorder)+1])
        
        self.buildTreeHelper(preorder[1:], left_inorder, root.left)
        self.buildTreeHelper(preorder[len(left_inorder)+1:], right_inorder, root.right)
