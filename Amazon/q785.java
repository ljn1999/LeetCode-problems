// 2022.06.22
// Problem Statement:
// https://leetcode.com/problems/is-graph-bipartite/

// idea: https://leetcode.com/problems/is-graph-bipartite/discuss/115487/Java-Clean-DFS-solution-with-Explanation
// dfs, 0 means not visited, 1 and -1 represent different groups
class Solution {
    public boolean isValid(int[][] graph, int[] colors, int color, int idx) {
        if (colors[idx]!=0) { // already visited and assigned to a group
            return colors[idx]==color;
        }
        colors[idx] = color;
        for (int i=0; i<graph[idx].length; i++) {
            if (!isValid(graph, colors, -1*color, graph[idx][i])) return false; // assign neighbour to a different group
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int [] colors = new int [graph.length];
        for (int i=0; i<graph.length; i++) {
            if (colors[i]==0 && !isValid(graph, colors, 1, i)) return false; // assign to group 1 (a random group)
        }
        return true;
    }
}