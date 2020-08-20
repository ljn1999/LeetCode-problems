# 2020.08.19
# Problem Statement:
# https://leetcode.com/problems/powx-n/
# personal solution was out of time limit again lol, looked up a post in discussion
# https://leetcode.com/problems/powx-n/discuss/19560/Shortest-Python-Guaranteed

class Solution:    
    def myPow(self, x: float, n: int) -> float:
        # check corner case and do early return
        if n == 0: 
            return 1
        
        # check the sign of n
        neg = (n<0)
        if neg: n = -n

        # idea:
        # divide n by 2 each time,
        # totally do ((x**2)**2)**2... for logn times,
        # make up the rest when n is odd.
        # complexity: log(n)

        # initialize the answer
        answer = 1
        while n>0:
            if n%2 == 1:
                answer = answer*x
            x = x*x
            n = int(n//2)

        # return the final answer and do necessary modification        
        if neg:
            return (1/answer)
        else:
            return answer