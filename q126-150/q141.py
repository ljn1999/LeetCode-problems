# 2020.03.19
# Problem Statement:
# https://leetcode.com/problems/linked-list-cycle/
# Approach 2 referred to the post below:
# https://leetcode.com/problems/linked-list-cycle/discuss/44489/O(1)-Space-Solution

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # Approach 1, faster than 27%, a stupid and hard-coding approach
    def hasCycle(self, head: ListNode) -> bool:
        if not head: return False
        
        count = 0
        # take advantage of the number of nodes range [0, 10^4]
        while count<=10000:
            # if once hits a None
            if not head:
                return False
            else:
                head = head.next
                count = count + 1
        
        # if never gets to the end
        return True

    # Approach 2, faster than 42%, so brilliant!
    def hasCycle(self, head: ListNode) -> bool:
        if not head: return False
        
        # runner goes 2 steps each time, chaser goes 1 step each time
        runner, chaser = head.next, head
        while True:
            # if there's a circle, runner and chaser will definitely meet
            if runner == chaser:
                return True
            # if a None is hitten by runner (since runner is faster than chaser)
            if not runner or not runner.next:
                return False
            # update runner and chaser
            runner = runner.next.next
            chaser = chaser.next