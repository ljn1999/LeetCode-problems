# 2020.01.15
# Sorry, was not in good mood yesterday
# Problem Statement:
# https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
# Almost the same question as question 108, adding a convertion of linked list to array

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        if not head: return None
        nums = self.linkedList2Array(head)
        middle = int(len(nums)/2)
        
        self.root = TreeNode(nums[middle])
        
        self.sortedArrayToBSTHelper(nums, self.root)
        return self.root
    
    def linkedList2Array(self, head):
        array = []
        while head:
            array.append(head.val)
            head = head.next        
        return array
    
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
        