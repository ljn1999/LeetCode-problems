# 2020.12.31, the third one today, really boring lol
# Problem Statement:
# https://leetcode.com/problems/decode-ways/

import numpy as np

class Solution:
    # function to check if the 2-digit string is a legal message as a whole
    def legal(self, s):
        if s[0] != '0' and int(s) >= 1 and int(s) <= 26:
            return True
        return False
    
    def numDecodingsHelper(self, s):

        # dynamic programming
        # answer for (string + extra char) = 
        # answer for string + legal(last char in string + extra char) * answer for (string without last char)
        # slow but somehow works
        
        # do quick return if the message is already "illegal"
        if self.zero_answer:
            return 0
        
        # base cases
        # only one digit
        if len(s) == 1: 
            self.answer_list[len(s)-1] = 1
            return 1
        # two digits
        if len(s) == 2:
            # separated or comnbined both work
            if self.legal(s) and s[-1] != '0':
                self.answer_list[len(s)-1] = 2
                return 2
            # doesn't work at all (ex: 40)
            elif not self.legal(s) and s[-1] == '0':
                self.zero_answer = True
                return 0
            # can only be combined or only separated
            else:
                self.answer_list[len(s)-1] = 1
                return 1
        
        # return early result if already calculated
        if self.answer_list[len(s)-1] != 0: return self.answer_list[len(s)-1]
        
        answer = self.numDecodingsHelper(s[:len(s)-1])
        # if last digit is 0
        if s[-1] == '0':
            # illegal
            if int(s[-2]) >= 3:
                self.zero_answer = True
            # must be combined with the previous digit
            else:
                answer = self.numDecodingsHelper(s[:len(s)-2])
        # if last digit is not 0    
        elif self.legal(s[len(s)-2:]):
            answer = answer + self.numDecodingsHelper(s[:len(s)-2])
        
        # fill in the dp structure
        self.answer_list[len(s)-1] = answer    
        return answer
    
    def numDecodings(self, s: str) -> int:
        # check corner cases
        if len(s) == 0 or s[0] == '0' or '00' in s: return 0
        
        # initialization
        self.answer_list = np.zeros(len(s))
        self.zero_answer = False
        
        result = int(self.numDecodingsHelper(s))

        # check if answer must be zero
        if not self.zero_answer:
            return result
        else:
            return 0
        
        
        
        