# 2021.04.14
# Problem Statement:
# https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        answer_1, answer_2 = 0, len(numbers)-1
        
        # idea: move answer_1 and answer_2 closer to each other, until the final result is find
        while answer_1 < answer_2:
            # answer is found
            if numbers[answer_1] + numbers[answer_2] == target:
                return [answer_1+1, answer_2+1]
            
            # current sum is too large, should decrease answer_2
            elif numbers[answer_1] + numbers[answer_2] > target:
                answer_2 = answer_2 - 1
            
            # current sum is too small, should increase answer_1
            else:
                answer_1 = answer_1 + 1
        
        
        
        
        
        