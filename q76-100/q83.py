# 2020.09.21
# Problem Statement:
# https://leetcode.com/problems/remove-duplicates-from-sorted-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        # check corner cases
        if not head: return head
        if not head.next: return head
        
        # ptr is always moving one forward
        # dummy is always pointing to the rightest non-duplicate node
        ptr = head
        dummy = head
        
        while ptr.next is not None:
            # if exists duplication
            if ptr.val == ptr.next.val:
                # move one forward
                ptr = ptr.next
                # check if reaches the tail
                if ptr.next is None:
                    dummy.next = None
            # no duplication
            else:
                # do reconnection and move forward
                dummy.next = ptr.next
                dummy = ptr.next
                ptr = ptr.next
                
        return head
            
            