// 2022.09.16 midnight
// Problem Statement:
// https://leetcode.com/problems/pacific-atlantic-water-flow/

// idea: dfs, [x][y]=1 means can flow, 2 means cannot flow, 0 means not calculated yet,
// 3 means currently expanding
class Solution {
    public int [][] heights;
    public int [][] pacific;
    public int [][] atlantic;
    public boolean pHelper(int x, int y) {
        pacific[x][y] = 3;
        if (pacific[x][y]==1) return true;
        else if (pacific[x][y]==2) return false;
        
        if (x==0||y==0) {
            pacific[x][y] = 1;
            return true;
        }
        // up
        if (x>0 && heights[x][y]>=heights[x-1][y]) {
            if (pacific[x-1][y]!=3 && pHelper(x-1, y)==true) {
                pacific[x][y] = 1;
                return true;
            }
        }
        // left
        if (y>0 && heights[x][y]>=heights[x][y-1]) {
            if (pacific[x][y-1]!=3 && pHelper(x, y-1)==true) {
                pacific[x][y] = 1;
                return true;
            }
        }
        // right
        if (y<heights[0].length-1 && heights[x][y]>=heights[x][y+1]) {
            if (pacific[x][y+1]!=3 && pHelper(x, y+1)==true) {
                pacific[x][y] = 1;
                return true;
            }
        }
        // bottom
        if (x<heights.length-1 && heights[x][y]>=heights[x+1][y]) {
            if (pacific[x+1][y]!=3 && pHelper(x+1, y)==true) {
                pacific[x][y] = 1;
                return true;
            }
        }
        pacific[x][y] = 2;
        return false;
    }
    
    public boolean aHelper(int x, int y) {
        atlantic[x][y] = 3;
        if (atlantic[x][y]==1) return true;
        else if (atlantic[x][y]==2) return false;
        
        if (x==heights.length-1||y==heights[0].length-1) {
            atlantic[x][y] = 1;
            return true;
        }
        // up
        if (x>0 && heights[x][y]>=heights[x-1][y]) {
            if (atlantic[x-1][y]!=3 && aHelper(x-1, y)==true) {
                atlantic[x][y] = 1;
                return true;
            }
        }
        // left
        if (y>0 && heights[x][y]>=heights[x][y-1]) {
            if (atlantic[x][y-1]!=3 && aHelper(x, y-1)==true) {
                atlantic[x][y] = 1;
                return true;
            }
        }
        // right
        if (y<heights[0].length-1 && heights[x][y]>=heights[x][y+1]) {
            if (atlantic[x][y+1]!=3 && aHelper(x, y+1)==true) {
                atlantic[x][y] = 1;
                return true;
            }
        }
        // bottom
        if (x<heights.length-1 && heights[x][y]>=heights[x+1][y]) {
            if (atlantic[x+1][y]!=3 && aHelper(x+1, y)==true) {
                atlantic[x][y] = 1;
                return true;
            }
        }
        atlantic[x][y] = 2;
        return false;
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] h) {
        heights = h;
        pacific = new int [heights.length][heights[0].length];
        atlantic = new int [heights.length][heights[0].length];
        List<List<Integer>> answer = new ArrayList<> ();
        for (int i=0; i<heights.length; i++) {
            for (int j=0; j<heights[0].length; j++) {
                if (pHelper(i, j)==true) {
                    if (aHelper(i, j)==true) {
                        List<Integer> pt = new ArrayList<> ();
                        pt.add(i);
                        pt.add(j);
                        answer.add(pt);
                    }
                }
                
            }
        }
        return answer;
    }
}