# 2020.07.30
# Problem Statement:
# https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # check empty list
        if not nums: return 0
        
        # initialize the index
        element_idx = 0
        while True:
            # if out of range, stop the loop
            if element_idx >= len(nums)-1: break
            # if duplicate, remove this element
            # no need to move to the next
            if nums[element_idx+1] == nums[element_idx]:
                nums.remove(nums[element_idx+1])
            # if not duplicate, move to the next and then do the compare
            else:
                element_idx = element_idx + 1
                
        return len(nums)