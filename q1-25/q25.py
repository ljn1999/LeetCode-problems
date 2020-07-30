# 2020.07.29
# Problem Statement
# https://leetcode.com/problems/reverse-nodes-in-k-group/
# Looked up the following youtube video:
# https://www.youtube.com/watch?v=cFDvbKTNeCA

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    # do a partial reverse
    def reverse_k(k, first):
        new_tail = first
        prev = None
        for i in range(0 ,k):
            # reconnecting
            next_node = first.next
            first.next = prev
            prev = first
            first = next_node
        new_head = prev
        after = first
        return new_head, new_tail, after
    
    # determine if continue or not
    def has_k_nodes(first, k):
        count = 1
        while first is not None and first.next is not None:
            first = first.next
            count = count + 1
            if count >= k:
                return True
        return False
    
    # function to call
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        # check empty or only 1 node cases
        if head is None: return None
        
        # initialize pointers
        dummy = ListNode(None)
        dummy.next = head
        before = dummy
        first = head
        
        # when still have space to swap
        while Solution.has_k_nodes(first, k):
                
            new_head, new_tail, after = Solution.reverse_k(k, first)

            # reconnecting nodes
            before.next = new_head
            new_tail.next = after
            
            # move forward
            before = first
            first = after
        
        # connect the last (several) node(s)
        before.next = first
        
        return dummy.next