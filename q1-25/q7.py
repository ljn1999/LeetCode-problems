# 2020.07.11

class Solution:
    def reverse(self, x: int) -> int:
        # check postive or negative
        if x < 0:
            negative = True
            x = -x
        else: 
            negative = False
            
        # count how many digits x has
        digit_num = 1
            
        while x // 10**(digit_num) != 0:
            digit_num = digit_num + 1
        
        answer = 0
        # iterate for all digits
        for i in range(1, digit_num+1):
            answer = answer + (x % 10**i)//10**(i-1) * 10**(digit_num-i)
        
        if negative:
            answer = -answer
                          
        # check if answer overflows
        if answer < -1*2**31 or answer > 2**31-1:
            return 0
        else:
            return answer