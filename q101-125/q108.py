# 2020.01.13
# Problem Statement:
# https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        # idea:
        # the middle one in the list should be the root
        # the nodes smaller than middle should be the nodes of the left sub-tree
        # the nodes larger than middle should be the nodes of the right sub-tree
        # do it recursively
        
        if len(nums) == 0: return None
        
        middle = int(len(nums)/2)
        
        self.root = TreeNode(nums[middle])
        
        self.sortedArrayToBSTHelper(nums, self.root)
        return self.root
    
    def sortedArrayToBSTHelper(self, nums, root):
        if len(nums) == 0: return
        
        middle = int(len(nums)/2)
        
        # set the left and right sub-tree nodes lists
        left_nums = nums[:middle]
        if middle+1 <= len(nums)-1:
            right_nums = nums[middle+1:]
        else:
            right_nums = []
        
        # connection
        # should check for empty cases
        if len(left_nums) != 0:
            root.left = TreeNode(left_nums[int(len(left_nums)/2)])
        if len(right_nums) != 0:
            root.right = TreeNode(right_nums[int(len(right_nums)/2)])
        
        # recursively call
        self.sortedArrayToBSTHelper(left_nums, root.left)
        self.sortedArrayToBSTHelper(right_nums, root.right)
        
        

        