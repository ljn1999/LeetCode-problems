// 2022.09.20
// Problem Statement:
// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

// idea: undirected & unweighted graph, count connected parts, can use dfs
class Solution {
    private HashMap<Integer, HashSet<Integer>> ht;
    private boolean [] visited;
    public int countComponents(int n, int[][] edges) {
        ht = new HashMap <> ();
        for (int i=0; i<edges.length; i++) {
            ht.putIfAbsent(edges[i][0], new HashSet<Integer> ());
            ht.get(edges[i][0]).add(edges[i][1]);
            ht.putIfAbsent(edges[i][1], new HashSet<Integer> ());
            ht.get(edges[i][1]).add(edges[i][0]);
        }
        
        visited = new boolean [n];
        int cnt = 0;
        for (int i=0; i<n; i++) {
            if (visited[i]==false) {
                dfs(i, i);
                cnt++;
            }
        }
        return cnt;
    }
    
    private void dfs(int i, int prev) {
        if (visited[i]) return;
        visited[i] = true;
        if (ht.containsKey(i)) {
            for (int n : ht.get(i)) {
                if (n!=prev) dfs(n, i);
            }
        }
    }
}