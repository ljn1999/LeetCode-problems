# 2020.07.26
# Problem Statement
# https://leetcode.com/problems/generate-parentheses/
# Actually I looked up the solution :(

class Solution:
    def recursive_generate(answer, string, count_left, count_right, n):
        # return when length is enough
        if len(string) == 2*n:
            answer.append(string)
            return        
        else:
            # if more left brackets can be added (not should)
            if count_left < n:
                Solution.recursive_generate(answer, string+"(", count_left+1, count_right, n)
            # if more right brackets can be added (not should)
            if count_right < count_left:
                Solution.recursive_generate(answer, string+")", count_left, count_right+1, n)


    def generateParenthesis(self, n: int) -> List[str]:
        # initialize list to return
        answer = []
        # count_left and count_right are 0 initially
        Solution.recursive_generate(answer, "", 0, 0, n)
        return answer