# 2020.07.23
# Problem Statement:
# https://leetcode.com/problems/remove-nth-node-from-end-of-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        # kepp ptr_2 to the next of ptr_1 by n nodes
        ptr_1 = head
        ptr_2 = head
        
        for i in range(0, n):
            if ptr_2.next is not None:
                ptr_2 = ptr_2.next
            else:
                # if head is to be deleted
                return head.next

        # move ptr_1 and ptr_2 to the next
        while ptr_2.next is not None:
            ptr_1 = ptr_1.next
            ptr_2 = ptr_2.next
        
        # skip the one to be deleted
        ptr_1.next = ptr_1.next.next
        return head