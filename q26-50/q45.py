# 2020.08.16
# Problem Statement:
# https://leetcode.com/problems/jump-game-ii/
# Was trying to solve it by dp, but ran out of time limit,
# looked up the solution and used greedy instead.
# https://leetcode.com/problems/jump-game-ii/discuss/170518/8-Lines-in-Python!-Easiest-Solution!
# The difference between greedy and dp is basically:
# greedy: for x steps, how far can I possibly go
# dp: for x coverage, how many steps are still required to reach the destination

class Solution:
    def jump(self, nums: List[int]) -> int:
        # do early return
        if len(nums) <= 1: return 0
        
        # idea, calculate the maximum coverage for every step
        # since the step is increasing by 1 each time, 
        # return the step when max coverage reaches the end,
        # the step num has to be the optimal result.

        # initialize the step num, current max coverage and the previous max coverage
        steps = 1
        max_coverage = nums[0]
        pre_max = 0

        while True:
            # return the answer
            if max_coverage >= len(nums) - 1:
                return steps
            else:
                # the next max coverage could be achieved (jump) from [previous max coverage, max coverage]
                temp = max(i + nums[i] for i in range(pre_max, max_coverage+1))
                pre_max, max_coverage = max_coverage, temp
                steps = steps + 1

# TLE dp solution
class Solution:
    def jump_helper(self, nums, start_idx):        
        if start_idx in self.memory.keys():
            return self.memory[start_idx]

        temp = 0       
        if start_idx > len(nums)-1:
            pass
        elif start_idx == len(nums)-1:
            temp = 0
        else:
            min_temp = inf
            for i in range(1, nums[start_idx]+1):
                temp = self.jump_helper(nums, start_idx+i) + 1
                if temp < min_temp:
                    min_temp = temp
            temp = min_temp
        
        self.memory[start_idx] = temp
        return self.memory[start_idx]
        
    def jump(self, nums: List[int]) -> int:        
        self.memory = {}
        answer = self.jump_helper(nums, 0)
        return answer