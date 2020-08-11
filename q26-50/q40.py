# 2020.08.11
# Problem Statement:
# https://leetcode.com/problems/combination-sum-ii/
# almost the same as q39

class Solution:
    def dfs(candidates, target, one_ans, answer):
        # base case
        if target == 0: 
            # check if already in the answer list
            if one_ans not in answer:
                answer.append(one_ans)
            return
        
        for i in range(0, len(candidates)):
            if candidates[i] > target: return
            # only try with elements to the right of the current one, since cannot use the same one twice
            # also can do it for q39! but don't need +1, just candidates[i: ]
            Solution.dfs(candidates[i+1: ], target-candidates[i], one_ans+[candidates[i]], answer)
        
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:        
        candidates.sort()
        answer = []
        Solution.dfs(candidates, target, [], answer)
        return answer
        