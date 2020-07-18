# 2020.07.18
# Problem Statement:
# https://leetcode.com/problems/longest-common-prefix/

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        # initialize answer
        answer = ""
        
        # check empty list
        if len(strs) == 0:
            return answer
        
        # get shortest length among all strings
        shortest_len = inf
        for string in strs:
            if len(string) < shortest_len:
                shortest_len = len(string)
        
        # check each char for each string
        add = True
        for char_index in range(0, shortest_len):
            for string_index in range(0, len(strs)-1):
                if strs[string_index][char_index] != strs[string_index+1][char_index]:
                    add = False
                    break
            if add:
                answer = answer + strs[0][char_index]
                    
        return answer
            