# 2020.07.04
# Problem Statement:
# https://leetcode.com/problems/two-sum/

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        # build a hash table
        dictionary = {}
        
        # method 1
        # build a hash structure, since the search in hash has an avg complexity of O(1)
        for i in range(0, len(nums)):          
            dictionary[nums[i]] = target - nums[i]
        
        # since the python dictionary I declared cannot store duplicate keys
        # should pay extra attention to (2 * element == target) cases, such as nums = [3, 3, 4], target = 6
        half_element = [] # to store indexes of half element
        
        for i in range(0, len(nums)):
            element = nums[i]
            if 2*element == target: # if the element is a half element
                 half_element.append(i)
                
            elif dictionary[element] in dictionary.keys(): # find the complement, done
                return [nums.index(element), nums.index(target - element)]
        
        # check if there are at least 2 half elements, avoid cases like nums = [3], target = 6
        if len(half_element) >= 2:
            return [half_element[0], half_element[1]] # return the first 2 indexes

        # method 2: copied from a youtube video: https://www.youtube.com/watch?v=OTtbG8lNNW8
        #for i in range (0, len(nums)):   
            #if (target - nums[i] not in dictionary):
                #dictionary[nums[i]] = i
            #else:
                #return [dictionary[target-nums[i]], i]
