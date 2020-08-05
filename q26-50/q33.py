# 2020.08.05
# Problem Statement:
# https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # check empty or single-element cases
        if len(nums) == 0: return -1
        if len(nums) == 1: return -1*(nums[0]!=target)
        
        # binary search to find the smallest number and index:
        left_bound = 0
        right_bound = len(nums)
        smallest_idx = int((left_bound+right_bound)/2)
        
        # maybe no rotation at all
        if nums[0] < nums[-1]:
            smallest_idx = 0
        else:
            while True:
                # smallest_idx is found
                if smallest_idx>=1 and nums[smallest_idx] < nums[smallest_idx-1]: 
                    break
                elif nums[smallest_idx]>nums[0]:
                    # search to the right
                    left_bound = smallest_idx                    
                    smallest_idx = int((left_bound+right_bound)/2)
                else:
                    # search to the left
                    right_bound = smallest_idx
                    smallest_idx = int((left_bound+right_bound)/2)
        # concatenate new list
        new_nums = nums[smallest_idx: ] + nums[0:smallest_idx]

        # early return, if out of range
        if target < new_nums[0] or target > new_nums[-1]: return -1

        # initialize answer to return
        left_bound = 0
        right_bound = len(nums)
        answer_idx = int((left_bound+right_bound)/2)

        # binary search in sorted list to find the answer
        while True:
            if new_nums[answer_idx] == target:
                answer_idx = answer_idx+smallest_idx
                # modify the index to match with the original array
                if answer_idx >= len(nums):
                    return answer_idx - len(nums)
                else:
                    return answer_idx
                
            elif new_nums[answer_idx] < target:
                # check can not be found cases
                if new_nums[answer_idx+1] > target:
                    return -1                
                else:
                    # search to the right
                    left_bound = answer_idx                    
                    answer_idx = int((left_bound+right_bound)/2)
            else:
                # check can not be found cases
                if new_nums[answer_idx-1] < target:
                    return -1
                else:
                    # search to the left
                    right_bound = answer_idx
                    answer_idx = int((left_bound+right_bound)/2)
                
        return -1