# 2020.07.31
# Nothing to do at work, so...
# Problem Statement:
# https://leetcode.com/problems/divide-two-integers/

class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        # check if result should be negative
        negative = False        
        if (dividend > 0 and divisor < 0) or (dividend < 0 and divisor > 0):
            negative = True
        
        # change to positive values, easier to do log calculation later
        dividend = abs(dividend)
        divisor = abs(divisor)
        
        # early return
        if dividend < divisor: return 0
        
        # check divisor == 1 cases, in order to avoid divide by 0 issues (log(divisor) == 0)
        if divisor == 1:
            if negative:
                result =  -1 * dividend
            else:
                result = dividend
        
        else:
            # basic idea:
            # if divisor ** x <= dividend < divisor ** (x+1)
            # then divisor ** (x-1) <= dividend/divisor, which is quotient < divisor ** x
            # where x = floor(log(dividend) / log(divisor))

            # find the lower bound and upper bound of quotient    
            low = divisor ** (floor(log(dividend) / log(divisor)) - 1)
            high = divisor ** floor(log(dividend) / log(divisor))

            # then do binary search
            result = 0.5 * (low + high)
            while True:
                # search the left half
                if result * divisor > dividend:
                    high = result
                    result = int(0.5 * (low + high))
                # search the right half
                elif (result + 1) * divisor <= dividend:
                    low = result + 1
                    result = int(0.5 * (low + high))
                # find the quotient
                else:
                    break
            
            # do a type cast
            result = int(result)
            
            # check the sign
            if negative:
                result = -1 * result
        
        # check if out of range
        if result < -1*2**31 or result > 2**31-1:
            return 2**31-1
        else:
            return result