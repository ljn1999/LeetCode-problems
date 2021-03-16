# 2020.03.14
# Problem Statement:
# https://leetcode.com/problems/single-number-ii/
# It's not a programming practice, it's an Olympic Math question :-(
# https://leetcode.com/problems/single-number-ii/discuss/43294/Challenge-me-thx

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # please refer to the link above with detailed explanation
        # I'm not able to fully understand how it works tbh
        ones, twos = 0, 0
        for i in range(0, len(nums)):
            ones = (ones ^ nums[i]) & (~twos)
            twos = (twos ^ nums[i]) & (~ones)
        return ones