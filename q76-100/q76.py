# 2020.09.11
# Problem Statement:
# https://leetcode.com/problems/minimum-window-substring/
# don't really know what happened to me, cannot solve any questions by myself now lol.
# https://leetcode.com/problems/minimum-window-substring/discuss/226911/Python-two-pointer-sliding-window-with-explanation

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # check empty/corner cases and do early return
        if len(s) == 0 or len(t) == 0 or len(s) < len(t): return ""

        # declare a dictionary to store occurances of chars in target
        dictionary = {}
        for i in range(0, len(t)):
            dictionary[t[i]] = t.count(t[i])
        
        # find the start index, no need to start from the very beginning
        start = -1
        best_ans = ""
        for i in range(0, len(s)):
            if s[i] in t:
                start = i
                break
        
        # do early return
        if start == -1: return ""
        if len(t) == 1: return t
        
        # idea: fix start and search for the end,
        # when find a potential solution, see if it can be optimized by increase start
        temp = start
        # since s[start] is already contained, should decrease by 1
        count_need = len(t)-1
        dictionary[s[start]] = dictionary[s[start]] - 1
        
        for end in range(temp+1, len(s)):
            # if not in t
            if s[end] not in dictionary:
                dictionary[s[end]] = 0
            if dictionary[s[end]] >= 1:
                count_need = count_need - 1
            
            dictionary[s[end]] = dictionary[s[end]] - 1

            while count_need == 0:
                dictionary[s[start]] = dictionary[s[start]] + 1
                if dictionary[s[start]] >= 1:
                    count_need = count_need + 1
                    # update the current best result
                    if not best_ans or len(best_ans) > end-start+1:
                        best_ans = s[start: end+1]                    
                start = start+1
                
        return best_ans
        