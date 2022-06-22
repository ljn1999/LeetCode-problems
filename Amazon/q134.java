// 2022.06.22
// Problem Statement:
// https://leetcode.com/problems/gas-station/

// idea: https://leetcode.com/problems/gas-station/discuss/1706142/JavaC%2B%2BPython-An-explanation-that-ever-EXISTS-till-now!!!!
// if starts at x1 and out of gas at x2, all stations between x1 and x2 (inclusive)
// are not good start points, should search to x2+1
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int answer = 0; // possible start point move from beginning to end
        while (answer<gas.length) {
            int curr_gas = 0;
            boolean should_continue = true;
            for (int i=answer; i<gas.length; i++) {
                curr_gas += gas[i]-cost[i];
                if (curr_gas<0) {
                    answer = i+1; // move possible start point to x2+1
                    should_continue = false;
                    break;
                }
            }
            if (should_continue) {
                for (int i=0; i<answer; i++) {
                    curr_gas += gas[i]-cost[i];
                    if (curr_gas<0) { // 0 to start point doesn't work, then no solution,
                                      // as the start point will only move forward,
                                      // the journey between 0 to start point can not be avoided
                        return -1;
                    }
                }
                return answer;
            }
        }
        return -1;
    }
}