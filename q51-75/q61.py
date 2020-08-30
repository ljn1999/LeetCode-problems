# 2020.08.29
# Problem Statement:
# https://leetcode.com/problems/rotate-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        # calculate the length first
        temp = head
        length = 0
        while temp is not None:
            temp = temp.next
            length = length + 1
        
        # do early return
        if length <= 1: return head
        
        # get exactly how much to rotate
        rotate = k % length
        if rotate == 0: return head
        
        # get the tail and the "stop" node: temp
        temp, tail = head, head
        count = 0

        while tail.next is not None:
            tail = tail.next
            
        while count <= length-rotate-2:
            temp = temp.next
            count = count + 1
        
        # reconnect
        new_head = temp.next
        temp.next = None        
        tail.next = head

        return new_head