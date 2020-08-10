# 2020.08.10
# Problem Statement:
# https://leetcode.com/problems/count-and-say/

class Solution:
    def countAndSay(self, n: int) -> str:
        # base case
        if n == 1: return "1"
        # corner case (can not go into the for loop below)
        elif n == 2: return "11"

        # get the last string to operate on
        pre_str = Solution.countAndSay(self, n-1)

        # initialize counters and answer to return
        count = 1
        ans_str = ""
        for i in range(0, len(pre_str)-1):
            # same element, count increase
            if pre_str[i] == pre_str[i+1]:
                count = count + 1
            # different element, append the last element set, and reset the count
            else:
                ans_str = ans_str + str(count) + pre_str[i]
                count = 1
            # deal with the last element   
            if i == len(pre_str)-2:
                ans_str = ans_str + str(count) + pre_str[i+1]
                
        return ans_str
                