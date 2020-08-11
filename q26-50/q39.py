# 2020.08.11
# Problem Statement:
# https://leetcode.com/problems/combination-sum/
# Made a mistake on making one_ans a global variable
# Got inspired by a post in Discussion section
# https://leetcode.com/problems/combination-sum/discuss/16554/Share-My-Python-Solution-beating-98.17

class Solution:
    def dfs(candidates, target, one_ans, answer):
        # a combination is found, append to answer
        if target == 0: 
            answer.append(one_ans)
            return
        
        # loop the list, fix one element and find the others recursively
        for i in range(0, len(candidates)):
            if candidates[i] > target: return
            if len(one_ans) > 0 and candidates[i] < one_ans[-1]:
                # should search for nums larger or equal to the current largest one in one_ans
                # search for next element
                continue
            else:
                # fix one element, find the rest recursively
                Solution.dfs(candidates, target-candidates[i], one_ans+[candidates[i]], answer)
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # sort the input list
        candidates.sort()

        # initialize answer to return
        answer = []

        # do the dfs
        Solution.dfs(candidates, target, [], answer)
        return answer
        
        