# 2020.08.04
# Problem Statement:
# https://leetcode.com/problems/longest-valid-parentheses/
# Looked up the solution

class Solution:
    def longestValidParentheses(self, s: str) -> int:
        # check not enough length cases
        if len(s) < 2: return 0
        
        # idea:
        # from left to right,
        # when encounter (, increase left, when encounter ), increase right
        # when right > left, the substring is no longer valid, 
        # set right = left = 0, start discovering the next substring.
        # when left = right, a valid substring is found, update the answer to return if larger
        # then do it again from right to left!

        # initialize counters and answer to return
        left, right, current_longest = 0, 0, 0
        for i in range(0, len(s)):
            if s[i] == "(":
                left = left + 1
            else:
                right = right + 1
            
            if left == right and left+right > current_longest:
                    current_longest = left+right
            elif right > left:
                right = 0
                left = 0
        
        # reset left and right
        left, right = 0, 0
        for j in range(0, len(s)):
            if s[len(s)-1-j] == "(":
                left = left + 1
            else:
                right = right + 1
            
            if left == right and left+right > current_longest:
                current_longest = left+right
            elif right < left:
                right = 0
                left = 0
                
        return current_longest