# 2021.04.10
# Problem Statement:
# https://leetcode.com/problems/maximum-gap/
# Referred to the solution here:
# https://leetcode.com/problems/maximum-gap/discuss/50643/bucket-sort-JAVA-solution-with-explanation-O(N)-time-and-space
import numpy as np

class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        # check corner cases
        if len(nums)<2: return 0
        if len(nums)==2: return abs(nums[0]-nums[1])
        
        # idea: bucket sort
        # the max gap must >= ceiling[(max - min ) / (len(nums) - 1)],
        # therefore, divide the list into (len(nums)-1) buckets,
        # the max gap will only show between buckets (the max of a smaller bucket and the min of a larger bucket)
        
        # set the division gap, to divide the list into buckets
        division_gap = (max(nums)-min(nums)) // (len(nums)-1)
        if division_gap != (max(nums)-min(nums)) / (len(nums)-1):
            division_gap = division_gap + 1
        
        # bucket[i][0] would store the min of bucket number i
        # bucket[i][1] would store the max of bucket number i
        bucket = np.zeros((len(nums)-1, 2))
        for i in range(0, len(nums)-1):
            bucket[i][0] = np.inf # initialization
            bucket[i][1] = -np.inf # initialization
        
        min_val, max_val = min(nums), max(nums)
        # check corner cases where all numbers are the same
        if min_val == max_val: return 0
        # do the division
        for i in range(0, len(nums)):
            if nums[i] == min_val:
                bucket[0][0] = nums[i]
                bucket[0][1] = max(bucket[0][1], nums[i])
            elif nums[i] == max_val:
                bucket[-1][1] = nums[i]
                bucket[-1][0] = min(bucket[-1][0], nums[i])
            else:
                # check which bucket it belongs to
                idx = (nums[i]-min_val) // division_gap
                if idx == (nums[i]-min_val) / division_gap:
                    idx = idx - 1
                bucket[idx][0] = min(bucket[idx][0], nums[i])
                bucket[idx][1] = max(bucket[idx][1], nums[i])
        
        # iterate over all buckets to see the max gap
        answer = 0
        prev = bucket[0][1]
        for i in range(0, len(nums)-2):
            if bucket[i+1][0] != np.inf:
                answer = max(answer, bucket[i+1][0]-prev)
                prev = bucket[i+1][1]
        
        return int(answer)
                
        