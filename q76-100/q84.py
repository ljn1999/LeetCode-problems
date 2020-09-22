# 2020.09.22
# Problem Statement:
# https://leetcode.com/problems/largest-rectangle-in-histogram/
# didn't come up with an O(n) solution, so looked up the solution
# https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28963/Python-solution-without-using-stack.-(with-explanation)

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        # initialize the answer to return
        answer = 0

        # left_larger_num stores how many continuous heights to the left (include i itself) >= heights[i]
        # right_larger_num stores how many continuous heights to the right (include i itself) >= heights[i]
        left_larger_num, right_larger_num = [1]*len(heights), [1]*len(heights)
        
        # fill in left_larger_num
        for i in range(1, len(heights)):
            j = i-1
            while j>=0:
                # basically counting the amount of continuous larger heights
                # playing with already calculated left_larger_num is faster than the for loop
                if heights[j] >= heights[i]:
                    # go to left
                    left_larger_num[i] = left_larger_num[i] + left_larger_num[j]
                    j = j - left_larger_num[j]
                else:
                    # lower than heights[i], can not extend anymore
                    break
                    
        # fill in the right_larger_num
        for i in range(1, len(heights)):
            j = len(heights)-1-i + 1
            while j<=len(heights)-1:
                # basically counting the amount of continuous larger heights
                # playing with already calculated left_larger_num is faster than the for loop
                if heights[j] >= heights[len(heights)-1-i]:
                    # go to right
                    right_larger_num[len(heights)-1-i] = right_larger_num[len(heights)-1-i]\
                                                         + right_larger_num[j]
                    j = j + right_larger_num[j]
                else:
                    # lower than heights[i], can not extend anymore
                    break
        
        # calculate the area with each height as the height of the answer rectangle
        for i in range(0, len(heights)):
            answer = max(answer, heights[i]*(left_larger_num[i]+right_larger_num[i]-1))
            
        return answer