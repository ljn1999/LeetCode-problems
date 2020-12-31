# 2020.12.31
# Happy new year!
# Problem Statement:
# https://leetcode.com/problems/gray-code/

class Solution:
    def grayCode(self, n: int) -> List[int]:
        # idea with example:
        # clearly when n==3, the answer can be obtained by adding a '0' before all elements in the answer of n==2;
        # and adding an '1' before all elements in the answer of n==2 in a reversed order.
        
        # adding '0'
        # 000
        # 001
        # 011
        # 010
        
        # adding '1' in reversed order
        # 110
        # 111
        # 101
        # 100
        
        # check base cases
        if n == 0: return [0]
        if n == 1: return [0, 1]

        # initialize the answer to return
        answer = []

        if n >= 2:
            # get the last answer
            last_answer = self.grayCode(n-1)
            # append 0 in the front means no change in value
            for i in range(0, len(last_answer)):
                answer.append(last_answer[i])
            # append 1 in the front means adding 2**(n-1) in value
            for i in range(0, len(last_answer)):
                temp = last_answer[len(last_answer)-1-i]
                temp = 2**(n-1) + temp
                answer.append(temp)
        
        return answer