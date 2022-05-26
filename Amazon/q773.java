// 2022.05.25
// Problem Statement:
// https://leetcode.com/problems/sliding-puzzle/

// idea: bfs, idk why dfs doesn't work
// https://leetcode.com/problems/sliding-puzzle/discuss/146652/Java-8ms-BFS-with-algorithm-explained
class Solution {
    Map<String, Integer> cache = new HashMap<> ();
    HashSet<String> path = new HashSet<> ();
    Queue<String> queue = new LinkedList<>();
    
    public int [] get0(String board) {
        int [] zero_pos = {0, 0};
        if (board.charAt(1)=='0') {
            zero_pos[1] = 1;
        } else if (board.charAt(2)=='0') {
            zero_pos[1] = 2;
        } else if (board.charAt(3)=='0') {
            zero_pos[0] = 1;
        } else if (board.charAt(4)=='0') {
            zero_pos[0] = 1;
            zero_pos[1] = 1;
        } else if (board.charAt(5)=='0') {
            zero_pos[0] = 1;
            zero_pos[1] = 2;
        }
        return zero_pos;
    }
    
    public int [][] deep_copy(String board) {
        int [][] new_board = new int [2][3];
        new_board[0][0] = board.charAt(0)-'0';
        new_board[0][1] = board.charAt(1)-'0';
        new_board[0][2] = board.charAt(2)-'0';
        new_board[1][0] = board.charAt(3)-'0';
        new_board[1][1] = board.charAt(4)-'0';
        new_board[1][2] = board.charAt(5)-'0';
        return new_board;
    }

    public int slidingPuzzle(int[][] board) {
        String board_str = Integer.toString(board[0][0])+Integer.toString(board[0][1])+
                           Integer.toString(board[0][2])+Integer.toString(board[1][0])+
                           Integer.toString(board[1][1])+Integer.toString(board[1][2]);
        path.add(board_str);
        queue.add(board_str);
        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String curr = queue.poll();
                if (curr.equals("123450")) {
                    return answer;
                } else {
                    int [] zero_pos = get0(curr);
                    int [][] new_board;
                    // move 0 to top
                    if (zero_pos[0]>=1) {
                        new_board = deep_copy(curr);
                        new_board[zero_pos[0]][zero_pos[1]] = new_board[zero_pos[0]-1][zero_pos[1]];
                        new_board[zero_pos[0]-1][zero_pos[1]] = 0;
                        String new_board_str = Integer.toString(new_board[0][0])+
                                               Integer.toString(new_board[0][1])+
                                               Integer.toString(new_board[0][2])+
                                               Integer.toString(new_board[1][0])+
                                               Integer.toString(new_board[1][1])+
                                               Integer.toString(new_board[1][2]);
                        if (!path.contains(new_board_str)) {
                            path.add(new_board_str);
                            queue.add(new_board_str);
                        }
                    }
                    // move 0 to left
                    if (zero_pos[1]>=1) {
                        new_board = deep_copy(curr);
                        new_board[zero_pos[0]][zero_pos[1]] = new_board[zero_pos[0]][zero_pos[1]-1];
                        new_board[zero_pos[0]][zero_pos[1]-1] = 0;
                        String new_board_str = Integer.toString(new_board[0][0])+
                                               Integer.toString(new_board[0][1])+
                                               Integer.toString(new_board[0][2])+
                                               Integer.toString(new_board[1][0])+
                                               Integer.toString(new_board[1][1])+
                                               Integer.toString(new_board[1][2]);
                        if (!path.contains(new_board_str)) {
                            path.add(new_board_str);
                            queue.add(new_board_str);
                        }
                    }
                    // move 0 to bottom
                    if (zero_pos[0]<=0) {
                        new_board = deep_copy(curr);
                        new_board[zero_pos[0]][zero_pos[1]] = new_board[zero_pos[0]+1][zero_pos[1]];
                        new_board[zero_pos[0]+1][zero_pos[1]] = 0;
                        String new_board_str = Integer.toString(new_board[0][0])+
                                               Integer.toString(new_board[0][1])+
                                               Integer.toString(new_board[0][2])+
                                               Integer.toString(new_board[1][0])+
                                               Integer.toString(new_board[1][1])+
                                               Integer.toString(new_board[1][2]);
                        if (!path.contains(new_board_str)) {
                            path.add(new_board_str);
                            queue.add(new_board_str);
                        }
                    }
                    // move 0 to right
                    if (zero_pos[1]<=1) {
                        new_board = deep_copy(curr);
                        new_board[zero_pos[0]][zero_pos[1]] = new_board[zero_pos[0]][zero_pos[1]+1];
                        new_board[zero_pos[0]][zero_pos[1]+1] = 0;
                        String new_board_str = Integer.toString(new_board[0][0])+
                                               Integer.toString(new_board[0][1])+
                                               Integer.toString(new_board[0][2])+
                                               Integer.toString(new_board[1][0])+
                                               Integer.toString(new_board[1][1])+
                                               Integer.toString(new_board[1][2]);
                        if (!path.contains(new_board_str)) {
                            path.add(new_board_str);
                            queue.add(new_board_str);
                        }
                    }
                }
            }
            answer++;
        }
        return -1;
    }
}