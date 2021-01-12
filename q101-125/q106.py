# 2020.01.12
# Problem Statement:
# https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
# very similar to question 105

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if len(inorder) == 0: return None
        
        # overall logic:

        # the last node in postorder must be the root

        # if the index of the root in inorder list is x
        # from index 0 to index x-1 (inclusive) would be the nodes of the left sub-tree, update the inorder list for left sub-tree
        # from index x+1 to the last index (inclusive) would be the nodes of the right sub-tree, update the inorder list for right sub-tree

        # connection
        # connect the right of the root to the second to last node in postorder
        # connect the left of the root to the (1+number of nodes in right sub-tree+1)th to last node in postorder
        
        # update right postorder list to be [: the second to last node+1]
        # update left postorder list to be [: the node before all right nodes+1+1]
        
        root = TreeNode(postorder[-1])
        self.buildTreeHelper(inorder, postorder, root)
        return root
    
    def buildTreeHelper(self, inorder, postorder, root):
        # base case
        if len(inorder)*len(postorder) == 0: return

        inorder_idx = inorder.index(postorder[-1])
        
        if inorder_idx != 0:
            left_inorder = inorder[:inorder_idx]
        else:
            left_inorder = []
        
        if inorder_idx != len(inorder)-1:
            right_inorder = inorder[inorder_idx+1:]
        else:
            right_inorder = []
        
        if len(left_inorder) != 0:
            root.left = TreeNode(postorder[-(len(right_inorder)+2)])
        
        if len(right_inorder) != 0:
            root.right = TreeNode(postorder[-2])

        
        self.buildTreeHelper(right_inorder, postorder[:-1], root.right)
        self.buildTreeHelper(left_inorder, postorder[:-(len(right_inorder)+1)], root.left)
