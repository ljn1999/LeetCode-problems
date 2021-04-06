# 2021.04.06
# Problem Statement:
# https://leetcode.com/problems/intersection-of-two-linked-lists/
# I clearly remember I came across this problem in my ECE244 final exam, which was in Dec, 2018.
# I felt so bad that I still didn't know how to solve it...
# https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # check empty linkedlist
        if not headA or not headB: return None
        
        # initialize pointers, each will travel at the same pace, 
        # and swtich to another list when the current list is done
        ptr_a, ptr_b = headA, headB
        
        # make sure it will not be set to headA or headB multiple times (only once) 
        loop_once = False
        
        while True:
            if ptr_a == ptr_b:
                return ptr_a
            else:
                # if not reaches the end                
                if ptr_a.next:
                    ptr_a = ptr_a.next
                # if reaches the end and hasn't looped once                              
                elif not ptr_a.next and not loop_once:
                    ptr_a = headB
                    # set the flag, cannot loop again
                    loop_once = True
                else:
                    # no intersection is found                    
                    return None
                
                # if not reaches the end
                if ptr_b.next:
                    ptr_b = ptr_b.next
                # if reaches the end (loop_once for ptr_a would take care of everything)
                else:
                    ptr_b = headA