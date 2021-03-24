# 2020.03.23
# Problem Statement:
# https://leetcode.com/problems/insertion-sort-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertionSortList(self, head: ListNode) -> ListNode:
        if not head.next: return head
        
        # order_head and order_tail would be the head and tail of the ordered part
        order_head, order_tail = head, head
        # start insertion from the second node
        current = head.next
        dummy = ListNode(0, head)
        
        while current:
            # store the next item after current
            temp = current.next           
            
            # find where to place current
            compare = dummy
            while compare.next and current.val > compare.next.val:
                compare = compare.next
            
            # insert current after compare
            # if current is larger than order_tail's value, no need for reconnection         
            if compare == order_tail:
                order_tail = current # update the order_tail
                current = temp
            # if current is not larger than order_tail's value, need to do reconnection  
            else:    
                # reconnection          
                order_tail.next = temp                
                next = compare.next
                compare.next = current
                current.next = next
                # if current is smaller or equal to the order_head's value, update order_head              
                if compare == dummy:
                    order_head = current
                current = temp
                 
        return order_head
            