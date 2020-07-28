# 2020.07.28
# Problem Statement
# https://leetcode.com/problems/swap-nodes-in-pairs/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        # check empty or only 1 node cases
        if head is None: return None
        elif head.next is None: return head
        else: answer_head = head.next
        
        first_time = True
        
        # initialize pointers
        # ptr_first will point at the first node of the 2 nodes to be swapped
        # answer_ptr will point at a node before the 2 nodes to be swapped
        ptr_first = head
        answer_ptr = head

        # loop until only 1-2 nodes left
        while ptr_first.next is not None and ptr_first.next.next is not None:
            # do reconnection
            temp = ptr_first.next
            ptr_first.next = ptr_first.next.next
            temp.next = ptr_first
            
            # check if first time
            if first_time:
                answer_head = temp
                first_time = False
            else:
                # connect with the left part
                answer_ptr.next = temp
                answer_ptr = answer_ptr.next.next

            # move a node forward
            ptr_first = ptr_first.next

        # if only 1 node left, no need to swap    
        if ptr_first.next is None:
            return answer_head
        # if 2 nodes left
        elif ptr_first.next.next is None:
            # do reconnection
            temp = ptr_first.next
            answer_ptr.next = temp
            temp.next = ptr_first
            ptr_first.next = None
            return answer_head
        
        