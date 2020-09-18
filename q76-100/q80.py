# 2020.09.18
# Problem Statement:
# https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # do early return
        if len(nums) <= 2: return len(nums)

        # count counts for the occurance of the current element
        count = 1        
        # set index as 1 initially
        index = 1

        while True:
            # already reached the bottom
            if index>len(nums)-1: break
            # same as previous element, increase count
            if nums[index] == nums[index-1]:
                count = count+1
            # different from previous element, set count back to 1
            else:
                count = 1
            # need to remove, also decrease count
            if count > 2:
                nums.remove(nums[index])
                count = count-1
            # move one element forward
            else:
                index = index + 1
                
        return len(nums)