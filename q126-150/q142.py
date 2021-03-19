# 2020.03.19
# Problem Statement:
# https://leetcode.com/problems/linked-list-cycle-ii/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        if not head: return None
        
        # similar to the last question
        # idea: runner must travel exactly one circle more than chaser
        # therefore, difference in count = size of circle
        runner, chaser = head.next, head
        runner_count = 1
        chaser_count = 0
        
        while True:
            # circle is found
            if runner == chaser:
                circle_size = runner_count - chaser_count
                break
            
            # circle is not found
            if not runner or not runner.next:
                return None
            
            # update runner, chaser and their counts
            runner = runner.next.next
            runner_count = runner_count + 2
            chaser = chaser.next
            chaser_count = chaser_count + 1

        # initialization
        circle_head, circle_tail = head, head
        
        # make circle_tail always (circle_size) nodes after circle_head
        for count in range(circle_size):
            circle_tail = circle_tail.next
        
        # check if the head itself is the node to return, important!
        if circle_tail == circle_head: return circle_head
        
        while True:
            # move circle_head and circle_tail together to see when their next nodes are the same node
            if circle_tail.next == circle_head.next:
                return circle_tail.next
            circle_head = circle_head.next
            circle_tail = circle_tail.next
            
        
        