# 2020.02.11
# Happy Chinese New Year!
# Problem Statement:
# https://leetcode.com/problems/valid-palindrome/

class Solution:
    def isPalindrome(self, s: str) -> bool:
        # check empty case
        if len(s) == 0: return True
        
        # initialize start and end indexes
        start, end = 0, len(s)-1
        while (start <= end):
            # check if can do comparison
            if (s[start].isalpha() or s[start].isdigit()) and (s[end].isalpha() or s[end].isdigit()):
                if s[start].isalpha() and s[end].isalpha():
                    if s[start].lower() != s[end].lower():
                        return False
                elif s[start].isdigit() and s[end].isdigit():
                    if int(s[start]) != int(s[end]):
                        return False
                # type not the same
                else:
                    return False
                start = start + 1
                end = end-1
            # move one next
            elif not (s[start].isalpha() or s[start].isdigit()):
                start = start + 1
            # move one next
            else:
                end = end-1
        
        return True
           
                