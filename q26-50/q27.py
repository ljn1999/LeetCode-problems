# 2020.07.30
# Problem Statement:
# https://leetcode.com/problems/remove-element/

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        # check empty input
        if not nums: return 0

        # initialize index
        element_index = 0
        # loop until out of range
        while element_index < len(nums):
            # remove the item
            if nums[element_index] == val:
                nums.remove(nums[element_index])
            # move to the next
            else:
                element_index = element_index + 1
                                
        return len(nums)