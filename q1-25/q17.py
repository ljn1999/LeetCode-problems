# 2020.07.21
# Problem Statement:
# https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution:
    # initialize global answer to return
    answer = []

    def letterCombinations(self, digits: str) -> List[str]:
        
        # base case
        if len(digits) == 0:
            temp = Solution.answer
            # set global answer to return to empty again
            Solution.answer = []
            return temp
        
        # check if first time
        if len(Solution.answer) == 0:
            first_time = True
        else:
            first_time = False

        # temp to hold new answer    
        new_answer = []

        # do recursion
        if digits[0] == "2":
            if first_time:
                Solution.answer.append("a")
                Solution.answer.append("b")
                Solution.answer.append("c")
            else:
                for element in Solution.answer:
                    new_answer.append(element + "a")
                    new_answer.append(element + "b")
                    new_answer.append(element + "c")
                Solution.answer = new_answer
            return self.letterCombinations(digits[1: ])
                
        elif digits[0] == "3":
            if first_time:
                Solution.answer.append("d")
                Solution.answer.append("e")
                Solution.answer.append("f")
            else:
                for element in Solution.answer:
                    new_answer.append(element + "d")
                    new_answer.append(element + "e")
                    new_answer.append(element + "f")
                Solution.answer = new_answer
            return self.letterCombinations(digits[1: ])
            
        elif digits[0] == "4":
            if first_time:
                Solution.answer.append("g")
                Solution.answer.append("h")
                Solution.answer.append("i")
            else:
                for element in Solution.answer:
                    new_answer.append(element + "g")
                    new_answer.append(element + "h")
                    new_answer.append(element + "i")
                Solution.answer = new_answer        
            return self.letterCombinations(digits[1: ])
            
        elif digits[0] == "5":
            if first_time:
                Solution.answer.append("j")
                Solution.answer.append("k")
                Solution.answer.append("l")
            else:
                for element in Solution.answer:
                    new_answer.append(element + "j")
                    new_answer.append(element + "k")
                    new_answer.append(element + "l")
                Solution.answer = new_answer     
            return self.letterCombinations(digits[1: ])
            
        elif digits[0] == "6":
            if first_time:
                Solution.answer.append("m")
                Solution.answer.append("n")
                Solution.answer.append("o")
            else:
                for element in Solution.answer:
                    new_answer.append(element + "m")
                    new_answer.append(element + "n")
                    new_answer.append(element + "o")
                Solution.answer = new_answer
            return self.letterCombinations(digits[1: ])
            
        elif digits[0] == "7":
            if first_time:
                Solution.answer.append("p")
                Solution.answer.append("q")
                Solution.answer.append("r")
                Solution.answer.append("s")
            else:
                for element in Solution.answer:
                    new_answer.append(element + "p")
                    new_answer.append(element + "q")
                    new_answer.append(element + "r")
                    new_answer.append(element + "s")
                Solution.answer = new_answer
            return self.letterCombinations(digits[1: ])
            
        elif digits[0] == "8":
            if first_time:
                Solution.answer.append("t")
                Solution.answer.append("u")
                Solution.answer.append("v")
            else:
                for element in Solution.answer:
                    new_answer.append(element + "t")
                    new_answer.append(element + "u")
                    new_answer.append(element + "v")
                Solution.answer = new_answer
            return self.letterCombinations(digits[1: ])
            
        elif digits[0] == "9":
            if first_time:
                Solution.answer.append("w")
                Solution.answer.append("x")
                Solution.answer.append("y")
                Solution.answer.append("z")
            else:
                for element in Solution.answer:
                    new_answer.append(element + "w")
                    new_answer.append(element + "x")
                    new_answer.append(element + "y")
                    new_answer.append(element + "z")
                Solution.answer = new_answer
            return self.letterCombinations(digits[1: ])
