# 2020.08.26
# had something to do at work yesterday
# actually also have something to do at work today, but...
# Problem Statement:
# https://leetcode.com/problems/length-of-last-word/

class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        # get rid of the leading and ending white spaces to avoid confusion
        s = s.strip()

        # check empty case
        if s == "": return 0

        # initialize answer to return
        answer = 0
        
        # check from the right to the left
        for i in range(0, len(s)):
            # found the last
            if s[len(s)-1-i] == " ":
                return answer

            # increment
            else:
                answer = answer + 1
            
        return answer