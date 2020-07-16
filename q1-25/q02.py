# 2020.07.06
# Problem Statement:
# https://leetcode.com/problems/add-two-numbers/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        
        # declare the head node
        head = ListNode()
        # declare a changing node, function as a 'pointer'
        ptr = head
        # initialize carrier = 0
        add_one = False

        # iterate until both lists are gone through
        while l1 is not None or l2 is not None:
            
            # check if already gone through
            if l1 is None:                
                add_1 = 0
            else:
                add_1 = l1.val
                l1 = l1.next # move to the next
            if l2 is None:
                add_2 = 0
            else:
                add_2 = l2.val
                l2 = l2.next # move to the next

            if not add_one:
                if add_1 + add_2 >= 10:
                    ptr.val = add_1 + add_2 - 10
                    add_one = True
                else:
                    ptr.val = add_1 + add_2
                    add_one = False
            else:
                if add_1 + add_2 + 1 >= 10:
                    ptr.val = add_1 + add_2 + 1 - 10
                    add_one = True
                else:
                    ptr.val = add_1 + add_2 + 1
                    add_one = False
            
            # if still have numbers not gone through
            if (l1 is not None) or (l2 is not None): 
                ptr.next = ListNode()
                ptr = ptr.next
            # have gone through both lists
            elif add_one:
                ptr.next = ListNode(val = 1, next = None)
            
        return head