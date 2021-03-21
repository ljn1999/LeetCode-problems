# 2020.03.21
# Problem Statement:
# https://leetcode.com/problems/reorder-list/
# My own solution exceeded the time limit, so I referred to the solution here:
# https://leetcode.com/problems/reorder-list/discuss/44988/A-python-solution-O(n)-time-O(1)-space

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:

        if not head.next: return head

        # split
        ptr_1, ptr_2 = head, head
        while ptr_2 and ptr_2.next:
            ptr_1 = ptr_1.next
            ptr_2 = ptr_2.next.next
        
        first_half = head        
        second_half = ptr_1.next
        ptr_1.next = None
        
        # reverse in O(n)
        left, right = None, second_half
        while right:
            next = right.next
            right.next = left
            left = right
            right = next        
        reversed_second_half = left
        
        # merge
        while reversed_second_half:
            temp1 = first_half.next
            first_half.next = reversed_second_half
            temp2 = reversed_second_half.next
            reversed_second_half.next = temp1
            first_half = temp1
            reversed_second_half = temp2
        
        return

    # exceed time limit solution        
    '''
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        head = self.reorderListHelper(head)
        
        return
        
        
    def reorderListHelper(self, head):
        before_end = head
        
        if not before_end.next: return head
        
        if not before_end.next.next:
            #temp = before_end.next
            #before_end.next.next = before_end            
            #before_end.next = None
            return before_end
        
        while before_end.next.next:
            before_end = before_end.next
        
        second = head.next
        head.next = before_end.next
        before_end.next = None
        head.next.next = self.reorderListHelper(second)
        
        
        return head
    '''
        
