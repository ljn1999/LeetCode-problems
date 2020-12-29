# 2020.12.29
# Problem Statement:
# https://leetcode.com/problems/partition-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        
        # idea: iterate over the linked list and store into seperate linked lists
        #       then merge the two lists together

        # initialization
        # "dummy" are nodes before heads
        less_dummy, greater_dummy = ListNode(0, None), ListNode(0, None)
        less_ptr, greater_ptr = less_dummy, greater_dummy
        ptr = head

        # keep going until reach the end
        # do the insertion (appending) part
        while ptr != None:
            
            if ptr.val < x:
                less_ptr.next = ListNode(ptr.val, None)
                less_ptr = less_ptr.next
            else:
                greater_ptr.next = ListNode(ptr.val, None)
                greater_ptr = greater_ptr.next
                
            ptr = ptr.next
        
        # do the merge part
        if less_dummy.next != None:
            if greater_dummy.next != None:
                less_ptr.next = greater_dummy.next
            return less_dummy.next
        
        else:
            if greater_dummy.next != None:
                return greater_dummy.next
            else:
                return None
            
        