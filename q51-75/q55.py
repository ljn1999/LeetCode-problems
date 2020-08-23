# 2020.08.23
# Problem Statement:
# https://leetcode.com/problems/jump-game/

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # almost the same as question 45.
        
        # check corner cases
        if len(nums) == 1: return True
        
        steps = 1
        max_coverage = nums[0]
        pre_max = 0
        
        while True:
            # if already reach the end, return True
            if max_coverage >= len(nums) - 1:
                return True
            else:
                temp = max(i + nums[i] for i in range(pre_max, max_coverage+1))
                pre_max, max_coverage = max_coverage, temp
                # if after update, the max coverage is the same, cannot go further any more, return False
                if pre_max == max_coverage: return False
                steps = steps + 1