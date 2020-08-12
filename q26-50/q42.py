# 2020.08.12
# Problem Statement:
# https://leetcode.com/problems/trapping-rain-water/

class Solution:
    def trap(self, height: List[int]) -> int:
        # idea:
        # only if exists higher num for both left and right
        # that index has water above
        # where the area of that index = min(highest in the left, highest in the right) - height[index]
        
        # check 0 answer cases, do early return
        if len(height) <= 2: return 0
        
        # initialize answer to return
        area = 0
        
        # initialize the left-highest and right-highest for index 1
        left = height[0]
        right = max(height[2: ])
        
        for i in range(1, len(height)-1):
            # update left and right
            if height[i-1] > left:
                left = height[i-1]
            if height[i] == right and height[i] not in height[i+1: ]:
                right = max(height[i+1: ])
            # calculate area for that index
            if left > height[i] and right > height[i]:
                area = area + min(left, right) - height[i]
                
        return area