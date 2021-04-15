# 2021.04.14
# Problem Statement:
# https://leetcode.com/problems/majority-element/

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # trivial question, no need to explain
        if len(nums) == 1: return nums[0]
        dict = {}
        for element in nums:
            if element not in dict.keys():
                dict[element] = 1
            else:
                dict[element] = dict[element] + 1
                if dict[element] >= (len(nums)//2 + 1):
                    return element