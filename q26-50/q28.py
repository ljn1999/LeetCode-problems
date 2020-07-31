# 2020.07.31
# Problem Statement:
# https://leetcode.com/problems/implement-strstr/

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # check empty needle
        if needle is None: return 0
        
        # initialize position indexes
        start, end = 0, 0
        # loop for start's position, until out of range
        for index in range(0, len(haystack)-len(needle)+1):
            start = index
            end = index + len(needle)
            # find the needle
            if haystack[start: end] == needle:
                return start
        
        # no match result, return -1
        return -1