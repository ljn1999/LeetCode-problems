# 2020.03.13
# Feeling a bit anxious recently, but I'm back :)
# Problem Statement:
# https://leetcode.com/problems/clone-graph/
# Referred to the DFS solution here:
# https://leetcode.com/problems/clone-graph/discuss/42309/Depth-First-Simple-Java-Solution

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node: return None
        self.hash_table = {}
        return self.connect(node)
        
    # the function will return the node with all its neighbors attached and all its neighbors' neighbors attached
    def connect(self, current_node_origin):
        # if visited, do return directly, otherwise would loop between permernantly
        if current_node_origin.val in self.hash_table.keys():
            return self.hash_table[current_node_origin.val]
        
        # if never visited, add into the dictionary
        current_node_copy = Node(current_node_origin.val, [])
        self.hash_table[current_node_copy.val] = current_node_copy
        
        # connect all its neighbors, and connect all its neighbors' neighbors
        for neighbor_node in current_node_origin.neighbors:
            current_node_copy.neighbors.append(self.connect(neighbor_node))
        return current_node_copy
        
        
            