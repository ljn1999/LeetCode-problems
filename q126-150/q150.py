# 2020.03.27
# Problem Statement:
# https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if len(tokens) == 1: return int(tokens[0])

        i = 0
        while len(tokens) != 1:
            if tokens[i] not in ["+", "-", "*", "/"]:
                i = i+1
            else:
                if tokens[i] == "+":
                    result = str(int(tokens[i-2]) + int(tokens[i-1]))
                elif tokens[i] == "-":
                    result = str(int(tokens[i-2]) - int(tokens[i-1]))
                elif tokens[i] == "*":
                    result = str(int(tokens[i-2]) * int(tokens[i-1]))
                elif tokens[i] == "/":
                    result = str(int(int(tokens[i-2]) / int(tokens[i-1])))

                # if reach the last operation sign
                if i == len(tokens)-1:
                    return int(result)
                else:
                    tokens = tokens[:i-2] + [result] + tokens[i+1:]
                
                # update i to check the next operation sign
                i = i-1