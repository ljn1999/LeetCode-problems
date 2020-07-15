# 2020.07.12
# plan to leave 2 days for q10 (hard)

class Solution:
    def isPalindrome(self, x: int) -> bool:
        # method 1, string method, faster than method 2
        str_x = str(x)
        for i in range(0, len(str_x)//2):
            if str_x[i] != str_x[len(str_x)-1-i]:
                return False
        return True
    
        # method 2, mathematical calculation method
        if x < 0:
            return False
        
        # count number of digits
        temp = x
        count_digits = 1        
        while (temp // 10) != 0:
            temp = temp // 10
            count_digits = count_digits + 1
        
        # calculate reversed number
        temp2 = x
        if count_digits == 1:
            return True
        else:
            reverse = 0
            for i in range(0, count_digits):
                multiplier = temp2 % 10
                temp2 = temp2 // 10
                reverse = reverse + multiplier * 10**(count_digits -1 - i)   
    
        return reverse == x