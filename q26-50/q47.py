# 2020.08.17
# Happy birthday! (not to me)
# Problem Statement:
# https://leetcode.com/problems/permutations-ii/
# almost the same as question 46,
# might update to a better and more "clever" version later.

class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        
        if len(nums) == 0: return [[]]        
        if len(nums) == 1: return [[nums[0]]]
        
        # different from question 46!
        if nums[0] != nums[1]:
            answer = [[nums[0], nums[1]], [nums[1], nums[0]]]
        else:
            answer = [[nums[0], nums[1]]]
            
        if len(nums) == 2: return answer

        new_answer = []

        for num in nums[2:]:
            for array in answer:                
                for i in range(0, len(array)+1):  
                    # different from question 46!
                    # do a unique check before append
                    if (array[:i] + [num] + array[i:]) not in new_answer:
                        new_answer.append(array[:i] + [num] + array[i:])  
            answer = deepcopy(new_answer)
            new_answer = []
    
        return answer
            