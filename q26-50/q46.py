# 2020.08.17
# Happy birthday! (not to me)
# Problem Statement:
# https://leetcode.com/problems/permutations/

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        # check corner cases and do early return
        if len(nums) == 0: return [[]]       
        if len(nums) == 1: return [[nums[0]]]

        # idea:
        # from just 2 element (2 permutation arrays), 
        # insert the 3rd elememnt to all possible positions and make it 6 arrays in total;
        # then insert the 4th element to the 6 arrays with 3 elements, 
        # do all the way until all number in nums are added.

        # initialize a data structure to hold the initial answer
        answer = [[nums[0], nums[1]], [nums[1], nums[0]]]
        
        # early return
        if len(nums) == 2: return answer

        # always do append in new_answer, and update answer to new_answer, and make new_answer empty again
        new_answer = []

        # add all the rest elements
        for num in nums[2:]:
            # add to each existing array
            for array in answer:  
                # iterate through all the possible positions the new number can insert into              
                for i in range(0, len(array)+1):           
                    new_answer.append(array[:i] + [num] + array[i:])  
            # have to do deep copy, instead of shallow copy
            answer = deepcopy(new_answer)
            # clear up new_answer
            new_answer = []
    
        return answer
