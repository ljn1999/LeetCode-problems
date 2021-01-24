# 2020.01.24
# Problem Statement:
# https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root: return None
        
        # initialize global variable
        # self.prev would always point to the previous node which should have the current node as its next node
        # self.isFirst represents if the current node is the first (most left) node in its level
        self.prev = None
        self.isFirst = True

        for level in range(1, self.getHeight(root)+1):            
            self.connectHelper(root, level)
            self.isFirst = True
            # set the next node of the last node to None
            self.prev.next = None
        
        return root
        
    
    def connectHelper(self, root, level):
        if root is None:
            return        
        
        if level == 1:
            if not self.isFirst:
                # do connection and update
                self.prev.next = root
                self.prev = root
            else:
                # do not do connection yet
                self.prev = root
                self.isFirst = False
        
        # recursively call, until the next node in the same level is reached
        elif level > 1 :
            self.connectHelper(root.left , level-1)
            self.connectHelper(root.right , level-1)   
    
    def getHeight(self, root):
        if not root: return 0
        left_height = self.getHeight(root.left)
        right_height = self.getHeight(root.right)
        
        if left_height >= right_height:
            return left_height + 1
        else:
            return right_height + 1