// 2022.06.29
// Problem Statement:
// https://leetcode.com/problems/number-of-provinces/

// idea: dfs, mark all reachable cities as visited from every non-visited start point
class Solution {
    public void markFromStart(int[][] isConnected, int start_idx, boolean [] visited) {
        // this function marks all reachable cities as visited from start point as start_idx
        visited[start_idx] = true;
        for (int i=0; i<isConnected.length; i++) {
            if (!visited[i] && isConnected[start_idx][i]==1) {
                markFromStart(isConnected, i, visited);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        boolean [] visited = new boolean [isConnected.length];
        int answer = 0;
        for (int i=0; i<isConnected.length; i++) {
            if (visited[i]) {
                continue;
            }
            markFromStart(isConnected, i, visited);
            answer++; // one provience is found
        }
        return answer;
    }
}