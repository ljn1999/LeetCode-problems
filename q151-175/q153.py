# 2021.04.02
# Problem Statement:
# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution:
    def findMin(self, nums: List[int]) -> int:
        # early check for single-element or already sorted lists
        if len(nums) == 1 or nums[0] < nums[-1]: return nums[0]
        
        # binary search
        left = 0
        right = len(nums)
        
        while True:
            middle = int(1/2 * (left + right))
            # do not need to consider when the middle is 0, cause it's already checked in the beginning
            if middle == len(nums)-1 or (nums[middle]<nums[middle-1] and nums[middle]<nums[middle+1]):
                return nums[middle]
            else:
                if nums[middle]>nums[0]:
                    # search the right half
                    left = middle
                else:
                    # search the left half
                    right = middle
        
        
        
                
                