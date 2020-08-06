# 2020.08.06
# Problem Statement:
# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # check empty list cases and out of range cases
        if len(nums) == 0: return [-1, -1]
        if target < nums[0] or target > nums[-1]: return [-1, -1]
        
        # initialize answer to return
        start, end = -1, -1

        # do binary search to find start and end
        left, right = 0, len(nums)
        index = int((left+right)/2)
        
        # binary search for start
        while True:
            if nums[index] == target:
                if index == 0:
                    start = 0
                    break
                # already the start
                elif nums[index-1] < target:
                    start = index
                    break
                else:
                    # search to the left
                    right = index
                    index = int((left+right)/2)
                    
            elif nums[index] < target:
                # target not found
                if nums[index+1] > target:
                    return [-1, -1]
                else:
                    # search to the right
                    left = index
                    index = int((left+right)/2)

            else:
                # target not found
                if nums[index-1] < target:
                    return [-1, -1]
                else:
                    # search to the left
                    right = index
                    index = int((left+right)/2)

        # binary search for end   
        # no need to check target not found again!     
        left, right = 0, len(nums)
        index = int((left+right)/2)
        while True:
            if nums[index] == target:
                if index == len(nums)-1:
                    end = len(nums)-1
                    break
                elif nums[index+1] > target:
                    end = index
                    break
                else:
                    # search to the right
                    left = index
                    index = int((left+right)/2)
                    
            elif nums[index] < target:
                # search to the right
                left = index
                index = int((left+right)/2)
                
            else:
                # search to the left
                right = index
                index = int((left+right)/2)                
                
        return [start, end]