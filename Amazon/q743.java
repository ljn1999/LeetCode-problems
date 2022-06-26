// 2022.06.26
// Problem Statement:
// https://leetcode.com/problems/network-delay-time/

// idea: a shortest path problem, use an array to store the path length from source to each node,
// iterate all edges until convergence (no change in the path length)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int [] time = new int [n];
        // initialization
        for (int i=0; i<n; i++) {
            if (i==k-1) {
                time[i] = 0;
            } else {
                time[i] = Integer.MAX_VALUE;
            }
        }

        boolean has_change = true;
        while (has_change) {
            has_change = false;
            for (int i=0; i<times.length; i++) {
                int src = times[i][0];
                int dest = times[i][1];
                int w = times[i][2];
                if (dest!=k) { // if the edge is pointing to the source, shouldn't count that edge                
                    if (time[src-1]!=Integer.MAX_VALUE && time[dest-1]>time[src-1]+w) { // if is a shorter path, update the length
                        has_change = true;
                        time[dest-1] = time[src-1]+w;
                    }
                }
            }
        }
        
        int answer = -1;
        for (int i=0; i<n; i++) {
            answer = Math.max(answer, time[i]);
        }
        if (answer==Integer.MAX_VALUE) return -1; // check if there're unreachable nodes
        return answer;
    }
}