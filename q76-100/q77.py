# 2020.09.15
# didn't solve any problems for several days, cause felt kind of dismotivated.
# Problem Statement:
# https://leetcode.com/problems/combinations/
# did copy and paste from:
# https://leetcode.com/problems/combinations/discuss/27029/AC-Python-backtracking-iterative-solution-60-ms

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        # back tracking method, which I really don't understand
        # can print the stack and x to see if it makes sense
        answer = []
        stack = []
        x = 1
        while True:           
            if len(stack) == k:
                answer.append(list(stack))
            if len(stack) == k or x > n:
                if not stack:
                    return answer
                x = stack.pop() + 1
            else:
                stack.append(x)
                x += 1