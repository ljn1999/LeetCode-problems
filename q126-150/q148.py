# 2020.03.25
# Problem Statement:
# https://leetcode.com/problems/sort-list/
# I hate linked list!
# https://leetcode.com/problems/sort-list/discuss/46714/Java-merge-sort-solution

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        # linked list implementation of merge sort

        # check base case
        if not head or not head.next: 
            return head
        
        # split
        second_half, ptr, prev = head, head, None
        while ptr and ptr.next:
            prev = second_half
            second_half = second_half.next
            ptr = ptr.next.next
        prev.next = None
        
        # sort
        left_half = self.sortList(head)
        right_half = self.sortList(second_half)

        # merge
        # right_half will have equal nodes or 1 more nodes than left_half (doesn't really matter here)
        return self.merge(left_half, right_half)
    
    def merge(self, list_1, list_2):
        # initialize pointers and dummy node
        ptr_1, ptr_2 = list_1, list_2
        dummy = ListNode(-inf, list_2)
        current = dummy
        while ptr_1 and ptr_2:
            # pick the node from list_1 as the next node
            if ptr_1.val <= ptr_2.val:
                current.next = ptr_1
                ptr_1 = ptr_1.next
            # pick the node from list_2 as the next node
            else:
                current.next = ptr_2
                ptr_2 = ptr_2.next
            current = current.next
        
        # connect the rest nodes
        if ptr_1:
            current.next = ptr_1
        elif ptr_2:
            current.next = ptr_2
        
        return dummy.next
