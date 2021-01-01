# 2021.01.01
# Problem Statement:
# https://leetcode.com/problems/reverse-linked-list-ii/
# Referred to the solution here:
# https://leetcode.com/problems/reverse-linked-list-ii/discuss/30666/Simple-Java-solution-with-clear-explanation

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        # check corner case and do early return
        if head.next is None: return head
        if m == n: return head
        
        # dummy is one node before the head of the answer
        dummy = ListNode()
        dummy.next = head
        
        # prev points to one node before the first node to be reversed
        prev = dummy
        for i in range(0, m-1):
            prev = prev.next
        
        # start points to the first node to be reversed, will not change
        # then points to the node to be put at the front in the next iteration
        
        # initialization
        start = prev.next
        then = start.next
        
        for i in range(0, n-m):
            # reconnection
            start.next = then.next
            then.next = prev.next
            prev.next = then
            then = start.next
        
        return dummy.next