# 2020.08.12
# Problem Statement:
# https://leetcode.com/problems/first-missing-positive/

class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        # do early return
        if nums == []: return 1
        if 1 not in nums: return 1

        # neighbours would store every positive number and there neighbours
        # if one of their neighbours does not exist in the list,
        # their neighbour is missing, and we need to find the smallest missing number
        neighbours = {}        
        for element in nums:
            if element > 0:
                neighbours[element] = (element-1, element+1)
                    
        smallest = inf            
        for key in neighbours.keys():
            # 0 is not positive and should not be checked
            if (neighbours[key][0] != 0 and neighbours[key][0] not in neighbours.keys()) \
                or neighbours[key][1] not in neighbours.keys():
                    if key < smallest:
                        smallest = key
                    
        return smallest+1