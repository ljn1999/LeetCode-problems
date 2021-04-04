# 2021.04.04
# Problem Statement:
# https://leetcode.com/problems/min-stack/

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.min = inf
        self.stack = []
        # the hash table structure to store the current min before its join.
        # since the same element could join in the stack several times,
        # self.current_min_before_join[val] would be a list, 
        # storing the current min before its join each time in the order of joining time.
        self.current_min_before_join = {}
        
    def push(self, val: int) -> None:
        # push into stack
        self.stack.append(val)
        # update the dictionary
        if val not in self.current_min_before_join.keys():
            self.current_min_before_join[val] = [self.min]
        else:
            self.current_min_before_join[val].append(self.min)
        # update the min
        self.min = min(self.min, val)
        

    def pop(self) -> None:
        # update the self.min after a pop
        if self.min == self.stack[-1]:
            self.min = self.current_min_before_join[self.stack[-1]][-1]
        # remove the last element in self.current_min_before_join[self.stack[-1]]
        self.current_min_before_join[self.stack[-1]].pop()
        # do the pop in stack
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()