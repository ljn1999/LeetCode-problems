# 2020.01.13
# Problem Statement:
# https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
# Finally figured out when to push a new array to the list of arries
# Referred to the DFS solution here:
# https://leetcode.com/problems/binary-tree-level-order-traversal-ii/discuss/34970/Is-there-any-better-idea-than-doing-regular-level-order-traversal-and-reverse-the-result

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        if not root: return []
        
        self.answer = []
        
        self.levelOrderBottomDFS(root, 0)
        return self.answer
        
    def levelOrderBottomDFS(self, root, level):
        if not root: return
        
        # when there are no array for this level, insert a new empty array to the front
        if len(self.answer) == level:
            self.answer.insert(0, [])
        
        # fill in the values to its level accordingly
        self.answer[-level-1].append(root.val)
        
        # DFS, to the deeper levels in left and right sub-trees
        self.levelOrderBottomDFS(root.left, level+1)
        self.levelOrderBottomDFS(root.right, level+1)