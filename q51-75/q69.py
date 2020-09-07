# 2020.09.06
# Problem Statement:
# https://leetcode.com/problems/sqrtx/

class Solution:
    def mySqrt(self, x: int) -> int:
        # set the lower bound and the upper bound for binary search
        low_bound = 1
        high_bound = x
        
        while True:
            answer = int(1/2 * (low_bound + high_bound))
            if answer * answer > x:
                # search to the left
                high_bound = answer
            else:
                if (answer+1) * (answer+1) > x:
                    # result is found
                    return answer
                else:
                    # search to the right
                    low_bound = answer