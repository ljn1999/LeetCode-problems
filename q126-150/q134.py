# 2020.03.13
# Problem Statement:
# https://leetcode.com/problems/gas-station/

class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        # initialize answer to return
        result = -1
        
        # idea:
        # check difference list
        # should find a start point which from start all the way back to start
        # the accumulated sum (of difference) should always be non-negative
        difference = []
        for i in range(0, len(gas)):
            difference.append(gas[i]-cost[i])
        
        for start in range(0, len(gas)):
            sum = 0
            continue_check = True # decide if still need to check from index 0 to start
            get_answer = True # decide if an answer is got
            
            for check_pt in range(start, len(gas)):
                sum = sum + difference[check_pt]
                if sum < 0:
                    continue_check = False
                    break # early return
            
            if continue_check:
                for check_pt in range(0, start):
                    sum = sum + difference[check_pt]
                    if sum < 0:
                        get_answer = False
                        break # early return
                
                # if no error occurs
                if get_answer:
                    return start
        
        return result
                
        