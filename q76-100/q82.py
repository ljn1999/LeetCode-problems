# 2020.09.20
# Problem Statement:
# https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        # check corner cases
        if head is None: return head
        if head.next is None: return head
        
        # a node to point to the node previous to the first duplicated one
        dummy = ListNode(-inf, head)
        
        # find the start node to return
        # there must be a way to combine it into the rest process, 
        # I tried and I failed and I didn't want to debug it.
        ptr = head
        if ptr.val != ptr.next.val:
            pass
        else:
            while ptr.next is not None:
                print(ptr.val)
                if ptr.val == ptr.next.val:
                    ptr = ptr.next
                else:
                    if ptr.next.next is None:
                        break
                    elif ptr.next.val != ptr.next.next.val:
                        break
                    else:
                        ptr = ptr.next        
            ptr = ptr.next

        # if all duplicate, return nothing    
        if not ptr: return None

        # should return real_head instead of head
        real_head = ptr
        # dup_val stores the duplicated value in current discovery
        dup_val = ptr.val
        first_time = True
        
        while ptr.next is not None:
            if ptr.val != ptr.next.val:
                if first_time:
                    dummy = ptr
                    ptr = ptr.next
                    first_time = False
                elif ptr.val != dup_val:
                    # safe, set the dummy and go to the next
                    dummy = ptr
                    ptr = ptr.next
                else:
                    # do reconnection
                    dummy.next = ptr.next
                    ptr = ptr.next
            else:
                # move to the next
                dup_val = ptr.val
                ptr = ptr.next
                # reach the end
                if ptr.next is None:
                    dummy.next = None
                
        return real_head
            
            
            