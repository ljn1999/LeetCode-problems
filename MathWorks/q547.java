// 2022.10.15
// Problem Statement:
// https://leetcode.com/problems/number-of-provinces/

class Solution {
    // dfs
    /*public int findCircleNum(int[][] isConnected) {
        boolean [] visited = new boolean [isConnected.length];
        int answer = 0;
        for (int i=0; i<isConnected.length; i++) {
            if (visited[i]==false) {
                dfs(isConnected, i, visited);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int[][] isConnected, int idx, boolean [] visited) {
        if (visited[idx]==true) return;
        visited[idx] = true;
        for (int i=0; i<isConnected.length; i++) {
            if (i!=idx && isConnected[idx][i]==1) { // idx is connected to i
                dfs(isConnected, i, visited);
            }
        }
        return;
    }*/
    
    // union find
    private int find(int a, int [] parent) {
        if (parent[a]==a) return a;
        // should not use while!!!
        parent[a] = find(parent[a], parent);
        return parent[a];
    }
    
    private void union(int a, int b, int [] parent, int [] n) {
        int parent_a = find(a, parent);
        int parent_b = find(b, parent);
        
        if (parent_a!=parent_b) {
            parent[parent_a] = parent_b;
            n[0]--;
        }
        
        return;
    }
    
    public int findCircleNum(int[][] isConnected) {
        int [] n = new int [1];
        n[0] = isConnected.length;
        
        int [] parent = new int [isConnected.length];
        for (int i=0; i<isConnected.length; i++) {
            parent[i] = i;
        }
        
        for (int i=0; i<isConnected.length; i++) {
            for (int j=0; j<isConnected.length; j++) {
                if (isConnected[i][j]==1) {
                    union(i, j, parent, n);
                }
            }
            
        }
        return n[0];
    }
}