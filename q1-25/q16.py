# 2020.07.20
# Problem Statement:
# https://leetcode.com/problems/3sum-closest/

class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        
        # the idea is same as question 15, but the implementation is much simpler
        nums.sort()
        
        # initialize current smallest difference between sum of 3 numbers and target number
        current_smallest_diff = inf
        
        # fix one element
        for i in range(0, len(nums)-2):
            left = i+1
            right = len(nums)-1
            
            # loop when left < right
            while left < right:
                # calculate the sum
                sum_3 = nums[i] + nums[left] + nums[right]
                # update the current best result
                if abs(sum_3 - target) < current_smallest_diff:
                    current_smallest_diff = abs(sum_3 - target)
                    answer = sum_3

                # move closer to target    
                if sum_3 < target:
                    left = left + 1
                elif sum_3 > target:
                    right = right - 1
                # if equals to target, directly return    
                else:
                    return target
                
        return answer
            