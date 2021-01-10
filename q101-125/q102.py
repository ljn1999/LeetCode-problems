# 2020.01.10
# Problem Statement:
# https://leetcode.com/problems/binary-tree-level-order-traversal/
# Referred to a website here:
# https://www.geeksforgeeks.org/level-order-tree-traversal/
# Used Method 1 (Use function to print a given level) to do this question,
# don't really know how to use Method 2 (Using queue) to do it, don't know when to append a whole level

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root: return []
        
        self.answer = []
        
        for level in range(1, self.getHeight(root)+1):
            # initialize the list to store the values in this level
            self.level_answer = []
            self.levelOrderHelper(root, level)
            self.answer.append(self.level_answer)
        
        return self.answer
    
    # BFS
    def levelOrderHelper(self, root, level):
        if root is None:
            return
        if level == 1:
            self.level_answer.append(root.val)
        elif level > 1 :
            self.levelOrderHelper(root.left , level-1)
            self.levelOrderHelper(root.right , level-1)
    
    # get the height of tree recursively
    def getHeight(self, root):
        if not root: return 0
        left_height = self.getHeight(root.left)
        right_height = self.getHeight(root.right)
        
        if left_height >= right_height:
            return left_height + 1
        else:
            return right_height + 1
    
    
        