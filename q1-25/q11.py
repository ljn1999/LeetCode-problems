# 2020.07.15

class Solution:
    def maxArea(self, height: List[int]) -> int:
        # check if container can be formed
        if len(height) <= 1:
            return 0
        
        # initialize left side and right side index
        left, right = 0, len(height)-1
        # initialize current result and current best result
        current_max = 0
        current_area = 0
        
        while right > left:
            # calculate current result
            current_area = (right-left) * min(height[left], height[right])
            # update current best result
            if current_area > current_max:
                current_max = current_area
            
            # if left bar is shorter, check if its right one can form a larger area
            if height[left] < height[right]:
                left = left + 1
            # if right bar is shorter, check if its left one can form a larger area
            else:
                right = right - 1
        
        # return the best result
        return current_max