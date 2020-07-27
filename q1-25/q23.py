# 2020.07.26
# May not have time to do it on 27th, so...
# Problem Statement
# https://leetcode.com/problems/merge-k-sorted-lists/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# one by one compare
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        
        # get rid of empty linked lists
        lists = [i for i in lists if i]
        
        # check empty case
        if len(lists) == 0: return None

        # initialize pointers
        list_ptr = []
        for list_head in lists:
            list_ptr.append(list_head)            
        
        answer_ptr = ListNode()
        answer_head = ListNode()
        first_time = True

        # loop until finish going through all the nodes
        while len(list_ptr) != 0:
            
            # pick the smallest value and add
            smallest = inf
            smallest_idx = 0
            for i in range(0, len(list_ptr)):
                if list_ptr[i] is not None and list_ptr[i].val < smallest:
                    smallest = list_ptr[i].val
                    smallest_idx = i
            answer_ptr.val = smallest

            if first_time:
                answer_head = answer_ptr
                first_time = False
            
            # move the ptr which points to the smallest value to the next
            if list_ptr[smallest_idx].next is not None:
                list_ptr[smallest_idx] = list_ptr[smallest_idx].next
            # if has been traversed, remove from the list
            else:
                list_ptr.remove(list_ptr[smallest_idx])
                
            # if all have been traversed
            if len(list_ptr) == 0:
                return answer_head
            else:
                # should add other nodes
                answer_ptr.next = ListNode()
                answer_ptr = answer_ptr.next
                
                # only one list left, can do early return
                if len(list_ptr) == 1:
                    answer_ptr.val = list_ptr[0].val
                    answer_ptr.next = list_ptr[0].next
                    return answer_head
                        
        return answer_head