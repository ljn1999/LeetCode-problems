# 2020.07.17
# Problem Statement:
# https://leetcode.com/problems/roman-to-integer/

class Solution:
    def romanToInt(self, s: str) -> int:
        # initialize answer
        answer = 0
        for i in range(0, len(s)):
            if s[len(s)-1-i] == "I":
                # check if appears alone or should be combined with other chars
                if i>0 and (s[len(s)-i] == "V" or s[len(s)-i] == "X"):
                    answer = answer - 1
                else:
                    answer = answer + 1
            elif s[len(s)-1-i] == "V":
                answer = answer + 5
            elif s[len(s)-1-i] == "X":
                # check if appears alone or should be combined with other chars
                if i>0 and (s[len(s)-i] == "L" or s[len(s)-i] == "C"):
                    answer = answer - 10
                else:
                    answer = answer + 10
            elif s[len(s)-1-i] == "L":
                answer = answer + 50
            elif s[len(s)-1-i] == "C":
                # check if appears alone or should be combined with other chars
                if i>0 and (s[len(s)-i] == "D" or s[len(s)-i] == "M"):
                    answer = answer - 100
                else:
                    answer = answer + 100
            elif s[len(s)-1-i] == "D":
                answer = answer + 500
            elif s[len(s)-1-i] == "M":
                answer = answer + 1000
                
        return answer