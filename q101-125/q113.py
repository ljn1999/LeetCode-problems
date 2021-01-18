# 2020.01.16
# Problem Statement:
# https://leetcode.com/problems/path-sum-ii/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if not root: return []
        self.sum = sum
        self.answer_list = []
        self.pathSumHelper(root, 0, [])
        return self.answer_list
    
    def pathSumHelper(self, root, sum, one_answer):        
        if not root: return
        sum = sum + root.val
        if sum == self.sum and self.isLeaf(root):
            self.answer_list.append(one_answer+[root.val])
            return
        else:
            # one_answer has to be passed in with operations inside function call, otherwise the value could be changed
            self.pathSumHelper(root.left, sum, one_answer+[root.val])
            self.pathSumHelper(root.right, sum, one_answer+[root.val])
    
    def isLeaf(self, root):
        if not root.left and not root.right: return True
        return False