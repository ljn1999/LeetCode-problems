# 2020.01.10
# Problem Statement:
# https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # almost the same as question 102, adding a bool to decide reverse(append value at the front) or not
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root: return []
        
        self.answer = []
        self.reverse = False
        
        for level in range(1, self.getHeight(root)+1):
            if level % 2 == 0:
                self.reverse = True
            else:
                self.reverse = False
            # initialize the list to store the values in this level
            self.level_answer = []
            self.zigzagLevelOrderHelper(root, level, self.reverse)
            self.answer.append(self.level_answer)
        
        return self.answer
    
    # BFS
    def zigzagLevelOrderHelper(self, root, level, reverse):
        if not root: return
        if level == 1:
            if not reverse:
                self.level_answer.append(root.val)
            else:
                self.level_answer.insert(0, root.val)
            
        elif level > 1 :
            self.zigzagLevelOrderHelper(root.left , level-1, reverse)
            self.zigzagLevelOrderHelper(root.right , level-1, reverse)
    
    # get the height of tree recursively
    def getHeight(self, root):
        if not root: return 0
        left_height = self.getHeight(root.left)
        right_height = self.getHeight(root.right)
        
        if left_height >= right_height:
            return left_height + 1
        else:
            return right_height + 1