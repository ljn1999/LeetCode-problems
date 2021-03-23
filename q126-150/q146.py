# 2020.03.23
# Problem Statement:
# https://leetcode.com/problems/lru-cache/
# Could not think of an O(n) solution...
# https://leetcode.com/problems/lru-cache/discuss/45926/Python-Dict-%2B-Double-LinkedList

# double linked list
class Node:
    def __init__(self, key=0, val=0, prev=None, next=None):
        self.key = key
        self.val = val
        self.prev = prev
        self.next = next
        
class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.dict = {} # value would be the entire corresponding node
        self.keys_head = Node()
        self.keys_tail = Node(prev=self.keys_head)
        self.keys_head.next = self.keys_tail

    # remove from current location  
    def remove(self, node):
        prev = node.prev
        next = node.next
        prev.next = next
        next.prev = prev
    
    # add to the tail
    def add(self, node):
        prev = self.keys_tail.prev
        prev.next = node
        node.prev = prev
        node.next = self.keys_tail
        self.keys_tail.prev = node
        
    def get(self, key: int) -> int:
        if key not in self.dict.keys(): return -1
        else:
            # remove from current location
            # add it before keys_tail
            node_to_change = self.dict[key]
            self.remove(node_to_change)            
            self.add(node_to_change)
            return self.dict[key].val
        

    def put(self, key: int, value: int) -> None:
        if key not in self.dict.keys():
            new_node = Node(key, value)
            self.add(new_node)
            self.dict[key] = new_node
            
            # remove the first element in the linked list
            if len(self.dict) > self.capacity:
                node_to_remove = self.keys_head.next
                self.remove(node_to_remove)
                del self.dict[node_to_remove.key]               
                
        else:
            # change the value
            self.dict[key].val = value
            # remove from current location
            # add it before keys_tail
            node_to_change = self.dict[key]
            self.remove(node_to_change)
            self.add(node_to_change)
            
# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)