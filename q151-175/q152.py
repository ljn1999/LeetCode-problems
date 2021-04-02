# 2021.04.02
# Sorry, was busy working these days.
# Problem Statement:
# https://leetcode.com/problems/maximum-product-subarray/
# Referred to the solution here:
# https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        answer = nums[0]
        
        # max_with_current_idx is the max product with the current index contained,
        # min_with_current_idx is the min product with the current index contained, 
        # have to store it since it could combine with the next negative element to make a larger product
        max_with_current_idx = nums[0]
        min_with_current_idx = nums[0]
        
        for i in range(1, len(nums)):
            if nums[i] > 0:
                max_with_current_idx = max(max_with_current_idx*nums[i], nums[i])
                min_with_current_idx = min(min_with_current_idx*nums[i], nums[i])
            else:
                temp = max_with_current_idx
                max_with_current_idx = max(min_with_current_idx*nums[i], nums[i])
                min_with_current_idx = min(temp*nums[i], nums[i]) 

            # update the current largest result           
            answer = max(answer, max_with_current_idx)
        
        return answer