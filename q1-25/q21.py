# 2020.07.25
# Problem Statement
# https://leetcode.com/problems/merge-two-sorted-lists/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # check empty list conditions
        if l1 is None and l2 is None: return None
        elif l1 is None: return l2
        elif l2 is None: return l1
        
        # initialize pointers
        ptr_1, ptr_2 = l1, l2
        answer_ptr = ListNode()
        answer_head = ListNode()
        first_time = True
        
        # loop until finish going through all the nodes
        while ptr_1 is not None or ptr_2 is not None:
            
            # pick the smaller value and add
            if ptr_1.val <= ptr_2.val:
                answer_ptr.val = ptr_1.val
                if first_time:
                    answer_head = answer_ptr
                    first_time = False
                answer_ptr.next = ListNode()
                answer_ptr = answer_ptr.next
                if ptr_1.next is not None:
                    ptr_1 = ptr_1.next
                else:
                    # if l1 is finished, the no need to do the rest
                    answer_ptr.val = ptr_2.val
                    answer_ptr.next = ptr_2.next
                    return answer_head
            
            else:
                answer_ptr.val = ptr_2.val
                if first_time:
                    answer_head = answer_ptr
                    first_time = False
                answer_ptr.next = ListNode()
                answer_ptr = answer_ptr.next
                if ptr_2.next is not None:
                    ptr_2 = ptr_2.next
                else:
                    # if l2 is finished, the no need to do the rest
                    answer_ptr.val = ptr_1.val
                    answer_ptr.next = ptr_1.next
                    return answer_head
                
        return answer_head
            