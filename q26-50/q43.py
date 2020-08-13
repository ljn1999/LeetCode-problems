# 2020.08.13
# Problem Statement:
# https://leetcode.com/problems/multiply-strings/

class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        # make sure num1 is longer than num2
        if len(num1) < len(num2):
            num2, num1 = num1, num2
        
        # initialize answer to return and carrier
        answer = 0
        carrier = 0
        for i in range(0, len(num2)):
            # reset carrier to zero, after finish doing one num1 * one digit in num2
            carrier = 0
            for j in range(0, len(num1)):
                temp = int(num1[len(num1)-1-j]) * int(num2[len(num2)-1-i])
                answer = answer + ((temp+carrier) % 10) * 10**j * 10**i
                carrier = (temp+carrier) // 10
                # add the most significant digit if carrier is not 0
                if j == len(num1)-1 and carrier != 0:
                    answer = answer + carrier * 10**j * 10**i * 10
            
        return str(answer)