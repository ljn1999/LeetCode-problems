# 2020.07.12

class Solution:
    def myAtoi(self, str: str) -> int:
        
        # remove white spaces of beginning and end
        str = str.strip()
        
        # check empty
        if len(str) == 0:
            return 0
        
        # check sign
        if str[0] == "-":
            negative = True
            str = str[1:]
        elif str[0] == "+":
            negative = False
            str = str[1:]
        else:
            negative = False

        # use temp to store efficient digits  
        temp = ""
        for i in range(0, len(str)):
            if not str[i].isdigit():
                break
            else:
                temp = temp + str[i]

        # initialize answer
        answer = 0
        for j in range(0, len(temp)):
            answer = answer + int(temp[len(temp)-1-j]) * 10**j

        # adapt sign changes if any, and check if out of range
        if negative:
            answer = -answer
        if answer > 2**31 - 1:
            answer = (2**31 - 1)
        elif answer < -1 * 2**31:
            answer = (-1 * 2**31)
        return answer
        