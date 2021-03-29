# 2020.03.29
# Problem Statement:
# https://leetcode.com/problems/reverse-words-in-a-string/

class Solution:
    def reverseWords(self, s: str) -> str:
        # early return
        if " " not in s: return s
        
        # organize the input s, so that no extra spaces are inside
        # remove the leading spaces
        i = 0
        while True:
            if s[i] != " ":
                break
            else:
                s = s[i+1:]
        # remove the trailing and middle extra spaces
        i = 0
        while True:   
            if i+1 >= len(s):
                if i < len(s) and s[i] == " ":
                    s = s[:i]
                break
            elif s[i] == " " and s[i+1] == " ":
                if i+2 < len(s):
                    s = s[:i+1] + s[i+2:]
                else:
                    s = s[:i]
            else:
                i = i+1

        # alternatively, use the line below to organize s, which is much faster, but takes more space
        # s = " ".join(s.split())
        
        answer = ""
        end = len(s)-1
        for start in reversed(range(0, len(s))):           
            if s[start] == " ":
                answer = answer + s[start+1:end+1] + " "
                end = start - 1
        
        answer = answer + s[:end+1]
        return answer