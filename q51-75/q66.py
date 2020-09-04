# 2020.09.04
# Problem Statement:
# https://leetcode.com/problems/plus-one/

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        # initialize the first index to change
        index = len(digits) - 1

        while True:
            if digits[index] == 9:
                digits[index] = 0
                if index != 0:
                    # go to the former index
                    index = index - 1
                else:
                    # add 1 at the beginning
                    digits = [1] + digits
                    return digits
            else:
                # done
                digits[index] = digits[index] + 1
                return digits