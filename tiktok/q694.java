// 2022.10.03 midnight
// Problem Statement:
// https://leetcode.com/problems/number-of-distinct-islands/

// idea: bfs and record the shape by the traversal path of _relative_ position wrt to the start x and y
// because the search is in the same order, if 2 islands have the same shape the traversal order must be the same
class Solution {
    HashSet<String> hs;
    public boolean isDistinct(StringBuilder sb) {
        if (hs.contains(sb.toString())) return false;
        hs.add(sb.toString());
        return true;
    }
    
    public void dfs(int [][] grid, int x, int y, int x_raw, int y_raw, StringBuilder sb) {
        if (grid[x][y]!=1) return;
        
        sb.append((x-x_raw) + "" +(y-y_raw));
        grid[x][y] = 2; // mark as visited
        int [] d = {0, 1, 0, -1, 0};
        for (int i=0; i<4; i++) {
            int new_x = x+d[i];
            int new_y = y+d[i+1];
            if (new_x>=0 && new_x<grid.length && new_y>=0 && new_y<grid[0].length) {
                dfs(grid, new_x, new_y, x_raw, y_raw, sb);
            }
        }
        return;
    }
    
    public int numDistinctIslands(int[][] grid) {
        hs = new HashSet<> ();
        int cnt = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j]==1) {
                    StringBuilder sb = new StringBuilder ();
                    dfs(grid, i, j, i, j, sb);
                    if (isDistinct(sb)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}