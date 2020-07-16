# 2020.07.16
# Problem Statement:
# https://leetcode.com/problems/integer-to-roman/

class Solution:
    def intToRoman(self, num: int) -> str:
        # initialize answer
        answer = ""
        
        # deal with thousands
        while num // 10**3 != 0:
            answer = answer + "M"
            num = num - 10**3

        # deal with hundreds    
        while num // 10**2 != 0:
            if num >= 9*10**2:
                answer = answer + "CM"
                num = num - 9*10**2
            elif num >= 5*10**2:
                answer = answer + "D"
                num = num - 5*10**2
            elif num >= 4*10**2:
                answer = answer + "CD"
                num = num - 4*10**2
            else:
                answer = answer + "C"
                num = num - 1*10**2

        # deal with tens        
        while num // 10 != 0:
            if num >= 90:
                answer = answer + "XC"
                num = num - 90
            elif num >= 50:
                answer = answer + "L"
                num = num - 50
            elif num >= 40:
                answer = answer + "XL"
                num = num - 40
            else:
                answer = answer + "X"
                num = num - 10

        # deal with the last digit
        while num > 0:
            if num >= 9:
                answer = answer + "IX"
                num = num - 9
            elif num >= 5:
                answer = answer + "V"
                num = num - 5
            elif num >= 4:
                answer = answer + "IV"
                num = num - 4
            else:
                answer = answer + "I"
                num = num - 1
        
        return answer

        