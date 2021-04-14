# 2021.04.13
# Problem Statement:
# https://leetcode.com/problems/fraction-to-recurring-decimal/

class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator == 0: return "0"
        
        # check the result's sign, and convert both to positive number
        if numerator/denominator < 0: neg = True
        else: neg = False
        numerator, denominator = abs(numerator), abs(denominator)
        
        # set the decimal part
        answer =  str(numerator//denominator)
        # numerator can be divided by denominator
        if numerator//denominator == numerator/denominator:
            if neg: return "-" + answer
            else: return answer
        else:
            answer = answer + "."
            # update the numerator
            numerator = (numerator%denominator)*10
        
        # check if remainder repeats
        remainder_with_index = dict()
        # save the first remainder and its corresponding start index in result
        remainder_with_index[numerator/10] = len(answer)
        while True:
            # add more 0s in result
            if numerator < denominator:
                answer = answer + "0"
                numerator = numerator * 10
            else:
                # append the current quotient
                answer = answer + str(numerator//denominator)
                
                # update the numerator
                numerator = numerator%denominator

                # done
                if numerator == 0:
                    if neg: return "-" + answer
                    else: return answer

                # check if the remainder repeats
                if numerator in remainder_with_index.keys():
                    answer = answer[:remainder_with_index[numerator]] + "(" \
                            +answer[remainder_with_index[numerator]:] + ")"
                    # return the result
                    if neg: return "-" + answer
                    else: return answer
                else:
                    # store the index of the current remainder
                    remainder_with_index[numerator] = len(answer)
                    # update numerator
                    numerator = numerator*10
                    