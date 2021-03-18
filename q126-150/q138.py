# 2020.03.17
# Problem Statement:
# https://leetcode.com/problems/copy-list-with-random-pointer/

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
# The basic idea is very similar to question 133
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head: return None
        self.hash_table = {}
        return self.connect(head)
    
    def connect(self, current_node_origin):
        # if input is None
        if not current_node_origin: 
            return None
        
        # if visited (already initialized)
        if current_node_origin.next in self.hash_table.keys():
            # return the already-built node
            return self.hash_table[current_node_origin.next]
        
        # if never visited
        # initialize with val, and next, random = None, None
        current_node_copy = Node(current_node_origin.val, None, None)
        # the next node should be the key, since it must be unique (val cannot be the key, it may duplicate)
        self.hash_table[current_node_origin.next] = current_node_copy
        # connect its next and random node
        current_node_copy.next = self.connect(current_node_origin.next)
        current_node_copy.random = self.connect(current_node_origin.random)

        return current_node_copy
        
        
        