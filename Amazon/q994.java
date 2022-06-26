// 2022.06.26
// Problem Statement:
// https://leetcode.com/problems/rotting-oranges/

// idea: bfs! use queue to store all corrupted positions,
// also use cnt and q_size to track if one iteration is done and if the step (time) should increase
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<> ();
        int fresh_orange = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j]==1) {
                    fresh_orange++;
                } else if (grid[i][j]==2) { // store all rotten oranges into the queue
                    int [] temp = new int [2];
                    temp[0] = i;
                    temp[1] = j;
                    queue.add(temp);
                }
            }
        }
        if (fresh_orange==0) return 0;
        
        int step=1, cnt=0, q_size=queue.size();
        while (!queue.isEmpty()) {
            int [] pos = queue.poll();
            cnt++;
            // top
            if (pos[0]>0 && grid[pos[0]-1][pos[1]]==1) {
                grid[pos[0]-1][pos[1]] = 2;
                int [] new_pos = new int [2];
                new_pos[0] = pos[0]-1;
                new_pos[1] = pos[1];
                queue.add(new_pos);
                fresh_orange--;
            }
            // left
            if (pos[1]>0 && grid[pos[0]][pos[1]-1]==1) {
                grid[pos[0]][pos[1]-1] = 2;
                int [] new_pos = new int [2];
                new_pos[0] = pos[0];
                new_pos[1] = pos[1]-1;
                queue.add(new_pos);
                fresh_orange--;
            }
            // right
            if (pos[1]<grid[0].length-1 && grid[pos[0]][pos[1]+1]==1) {
                grid[pos[0]][pos[1]+1] = 2;
                int [] new_pos = new int [2];
                new_pos[0] = pos[0];
                new_pos[1] = pos[1]+1;
                queue.add(new_pos);
                fresh_orange--;
            }
            // bottom
            if (pos[0]<grid.length-1 && grid[pos[0]+1][pos[1]]==1) {
                grid[pos[0]+1][pos[1]] = 2;
                int [] new_pos = new int [2];
                new_pos[0] = pos[0]+1;
                new_pos[1] = pos[1];
                queue.add(new_pos);
                fresh_orange--;
            }
            // check if no fresh oranges in the grid
            if (fresh_orange==0) return step; 
            // go to the next iteration
            if (cnt==q_size) {
                step++;
                cnt = 0; // reset cnt
                q_size = queue.size(); // update cnt
            }
        }
        return -1;
    }
}