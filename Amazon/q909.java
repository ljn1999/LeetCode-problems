// 2022.05.18 midnight
// Problem Statement:
// https://leetcode.com/problems/snakes-and-ladders/

// idea: bfs (template: https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/)
// have to keep a data structure of count to count for the steps
class Solution {
    public int snakesAndLadders(int[][] board) {
        boolean [] visited = new boolean [board.length*board.length];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int [] count = new int [board.length*board.length];
        visited[0] = true;
        queue.add(1);
        int curr;
        while (queue.size()!=0) {
            curr = queue.poll(); // curr node to explore
            int left = curr+1, right = Math.min(curr+6, board.length*board.length);
            for (int i=left; i<=right; i++) { // explore its next nodes
                int next = i;
                if (next==board.length*board.length) {
                    return count[curr-1] + 1;
                }
                int row = board.length-1 - (next-1)/board.length;
                int col;
                if (((next-1)/board.length)%2==0) {
                    col = (next-1)%board.length;
                } else {
                    col = board.length-1 - (next-1)%board.length;
                }
                if (board[row][col]!=-1) {
                    next = board[row][col]; // get the real next
                }
                if (visited[next-1]==false) {
                    visited[next-1] = true;
                    if (next==board.length*board.length) {
                        return count[curr-1] + 1;
                    }
                    queue.add(next);
                    count[next-1] = count[curr-1] + 1;
                }
            }    
        }
        return -1;
    }
}