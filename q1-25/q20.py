# 2020.07.24
# Problem Statement:
# https://leetcode.com/problems/valid-parentheses/
# I have to admit that I looked up the solution for better answer:(

class Solution:
    def isValid(self, s: str) -> bool:        
        # early check
        if len(s) % 2 != 0: return False
        
        # loop until all valid combinations are removed
        while "()" in s or "{}" in s or "[]" in s:
            s = s.replace("()", "")
            s = s.replace("{}", "")
            s = s.replace("[]", "")

        # if nothing left, then valid    
        if s == "": return True
        else: return False