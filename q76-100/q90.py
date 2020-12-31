# 2020.12.31
# Happy new year!
# Problem Statement:
# https://leetcode.com/problems/subsets-ii/

class Solution:
    def subsetsWithDupHelper(self, nums_dict):
        # idea: recursively add up the first element to the answer of the rest elements combined
        
        # initialize local answer
        answer = []

        # base case
        if len(nums_dict) == 1:
            # add 0~count times of the element
            for i in range(0, list(nums_dict.values())[0]+1):                
                answer.append([list(nums_dict.keys())[0]] * i)
            return answer
        
        # get all the keys in a list for convenience
        keys = list(nums_dict.keys())

        # get the dictionary without the first item
        last_nums_dict = deepcopy(nums_dict)
        last_nums_dict.pop(keys[0])
        last_answer = self.subsetsWithDupHelper(last_nums_dict)
        
        # add up the first element to the answer of the rest elements combined
        for i in range(0, list(nums_dict.values())[0]+1):            
            for element in last_answer:
                answer.append(element + [keys[0]] * i)
        
        return answer
            
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        # sort to make duplicated terms next to each other, for easier operation
        nums.sort()

        # nums_dict would get all unique integers as keys and their times of occurance as values
        nums_dict = {}
        count = 1
        for i in range(0, len(nums)):
            if i == len(nums)-1:
                nums_dict[nums[i]] = count
            else:
                if nums[i+1] != nums[i]:
                    nums_dict[nums[i]] = count
                    count = 1
                else:
                    count = count + 1        
         
        return self.subsetsWithDupHelper(nums_dict)
