// 2022.09.20
// Problem Statement:
// https://leetcode.com/problems/graph-valid-tree/

// idea: undirected & unweighted graph check cyclic or not 
// -> dfs (with previous node as param) OR union-find
class Solution {
    private HashMap<Integer, HashSet<Integer>> ht;
    private HashSet<Integer> nodes;
    private boolean [] visited;

    public boolean validTree(int n, int[][] edges) {
        ht = new HashMap<> ();
        nodes = new HashSet<Integer> ();
        for (int i=0; i<edges.length; i++) {
            ht.putIfAbsent(edges[i][0], new HashSet<Integer> ());
            ht.get(edges[i][0]).add(edges[i][1]);
            ht.putIfAbsent(edges[i][1], new HashSet<Integer> ());
            ht.get(edges[i][1]).add(edges[i][0]);
        }
        
        visited = new boolean [n];
        if (isCyclic(0, 0)==true) return false;
        if (nodes.size()!=n) return false;
        return true;
    }
    
    private boolean isCyclic(int i, int prev) {
        nodes.add(i);
        visited[i]=true;
        
        if (ht.containsKey(i)) {
            for (int n : ht.get(i)) {
                if (visited[n]==true && n!=prev) return true;
                else if (prev!=n && isCyclic(n, i)==true) return true;
            }
        }
        return false;
    }
}