# 2020.09.03
# Problem Statement:
# https://leetcode.com/problems/valid-number/

class Solution:
    def isNumber(self, s: str) -> bool:

        # a very disgusting problem :-(
        s = s.strip()
        if len(s) == 0: return False
        count_sign = 0
        count_dot = 0
        e_position = -1
        sign_position = -1
        dot_position = -1

        if s[0] == "e" or s == ".": return False
        
        for i in range(0, len(s)):
            # check the legal element
            if s[i] not in ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "e", "."]:
                return False
            
            # check the sign
            if s[i] == "+" or s[i] == "-":
                if i != 0:
                    return False
                else:
                    sign_position = i
                    count_sign = count_sign + 1
            if count_sign == 2:
                return False
            
            # check the decimal point
            if s[i] == ".":
                count_dot = count_dot + 1
                dot_position = i
            if count_dot == 2:
                return False
            
            # check the e
            if s[i] == "e":
                e_position = i
                break
        
        # deal with endless corner cases
        if e_position == sign_position + 1: return False
        if (s[:dot_position] == "+" or s[:dot_position] == "-") and dot_position == len(s)-1: return False
        if e_position == -1: return True       
        if e_position == len(s)-1: return False  
        if s[:e_position] == ".": return False
        
        # check the part after e
        count_sign = 0
        for i in range(e_position+1, len(s)):
            # check the legal element, "." can not be included
            if s[i] not in ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-"]:
                return False
            
            # check the sign
            if s[i] == "+" or s[i] == "-":
                if i != e_position+1 or i == len(s)-1:
                    return False
                else:
                    count_sign = count_sign + 1
            if count_sign == 2:
                return False
            
        return True
            
        