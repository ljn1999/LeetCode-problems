# 2020.08.21
# Problem Statement:
# https://leetcode.com/problems/maximum-subarray/

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # idea:
        # when partial sum < 0, do not hesitate to remove that part, 
        # ie: start a new discovery.

        # check empty case
        if len(nums) == 0: return 0

        # initialize answer as the max element in nums
        answer = max(nums)
        
        # initialize left bound and right bound of sum
        left, right = 0, 0
        current_sum = nums[0]

        # when not reach the end yet
        while right <= len(nums)-1:
            # have reached the end of list, return the max between current result and previous max
            if right == len(nums)-1: return max(answer, current_sum)
            # remove that part and start new
            elif current_sum < 0:
                left, right = right + 1, right + 1
                current_sum = nums[left]
            # include the next element
            else:
                right = right + 1
                current_sum = current_sum + nums[right]
                if nums[right] > 0:
                    answer = max(answer, current_sum)
                    