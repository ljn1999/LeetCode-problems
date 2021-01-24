# 2020.01.23
# Sorry, was busy with work this week
# Problem Statement:
# https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

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
        # recursion
        if not root: return None
        self.isRoot = True
        
        self.connectHelper(root, None, True)
        return root
    
    def connectHelper(self, root, parent, isLeft):
        # if is the root, set the next to be None
        if self.isRoot:
            root.next = None
            self.isRoot = False
        else:
            if not root: return
            # the next of left sub-node should be the right node of its parent
            if isLeft:
                root.next = parent.right
            # the next of right sub-node should be the left node of its parent's next node
            else:
                if parent.next:
                    root.next = parent.next.left
                else:
                    root.next = None

        self.connectHelper(root.left, root, True)
        self.connectHelper(root.right, root, False)
        
        
   