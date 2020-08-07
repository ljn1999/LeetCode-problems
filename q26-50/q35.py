# 2020.08.07
# Problem Statement:
# https://leetcode.com/problems/search-insert-position/

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        # check empty list
        if len(nums) == 0: return 0

        # check out of range, early return
        if target < nums[0]: return 0
        elif target > nums[-1]: return len(nums)
        
        # initialize indexes for binary search and answer to return
        left, right = 0, len(nums)
        index = int((left+right)/2)

        # do binary search
        while True:
            if nums[index] == target:
                return index
            elif nums[index] > target:
                # find the index to insert
                if index > 0  and nums[index-1] < target:
                    return index
                else:
                    # search the left part
                    right = index
                    index = int((left+right)/2)
            else:
                # find the index to insert
                if index < len(nums)-1 and nums[index+1] > target:
                    return index+1
                else:
                    # search the right part
                    left = index
                    index = int((left+right)/2)