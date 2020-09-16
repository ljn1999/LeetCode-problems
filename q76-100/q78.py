# 2020.09.15
# Problem Statement:
# https://leetcode.com/problems/subsets/

class Solution:
    # the same (almost) function in q77
    def combine(self, n, k, answer, nums):
        stack = []
        x = 1
        while True:
            if len(stack) == k:
                answer.append(list(stack))
            if len(stack) == k or x > n:
                if not stack:
                    break
                # was: x = stack.pop() + 1
                # but want to use the index of the first element in stack instead
                # should add 2, since index = stack.pop()-1 in previous question
                x = nums.index(stack.pop()) + 2
            else:
                stack.append(nums[x-1])
                x += 1
                
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.answer = []
        
        for i in range(1, len(nums)+1):
            self.combine(len(nums), i, self.answer, nums)

        # take care of the empty subset    
        self.answer.append([])
        return self.answer