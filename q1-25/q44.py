# 2020.08.15
# Problem statement:
# https://leetcode.com/problems/wildcard-matching/
# Was trying to solve it by recursion similar to question 10,
# but time limit exceed,
# then got inspired by a dp solution in dicussion section:
# https://leetcode.com/problems/wildcard-matching/discuss/370736/Detailed-Intuition-From-Brute-force-to-Bottom-up-DP

class Solution:
    def isMatchHelper(self, s, p, s_start, p_start):
        # early return, if already calculated
        if (s_start, p_start) in self.memory.keys():
            return self.memory[(s_start, p_start)]
        
        # initialize temp, which will be stored to the structure later
        temp = False
        
        # if p is gone through, true or false depends on if s is gone through
        if not p[p_start:]:
            temp = not s[s_start:]
            self.memory[(s_start, p_start)] = temp        
            return temp
        
        # if p is not gone through but s is not, true or false depends on if the rest of p are all "*"s
        if not s[s_start:]:
            for i in range(0, len(p[p_start:])):
                if p[p_start+i] != "*":
                    temp = False
                    self.memory[(s_start, p_start)] = temp
                    return temp
            # if some is not "*"
            temp = True
            self.memory[(s_start, p_start)] = temp
            return temp
        
        # if the current char matches, go to the next
        if s[s_start] == p[p_start] or p[p_start] == "?":
            temp = self.isMatchHelper(s, p, s_start+1, p_start+1)
        
        # if p's current char is "*", either p can go to next or s can go to next
        # if one of them can get finally matched, then the overall answer is Ture
        if p[p_start] == "*":
            temp = self.isMatchHelper(s, p, s_start+1, p_start) \
                or self.isMatchHelper(s, p, s_start, p_start+1)
        
        # store the current answer to the data structure
        self.memory[(s_start, p_start)] = temp        
        return temp
        
    def isMatch(self, s: str, p: str) -> bool:
        # initialize dp's data structure
        self.memory = {}
        
        # simplify p, only remain 1 "*" when there are consecutive "*"s
        while "**" in p:
            p = p.replace("**", "*")

        # call the helper function  
        answer = self.isMatchHelper(s, p, 0, 0)
        return answer