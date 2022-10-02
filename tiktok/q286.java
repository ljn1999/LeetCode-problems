// 2022.10.02
// Problem Statement:
// https://leetcode.com/problems/walls-and-gates/

// idea: for every gate to a bfs, relax the path length for each empty cell
// a better bfs: from this node to set neighbor nodes
// the best bfs: first append all gates to the queue, then the first time to reach the cell must be optimal
// https://leetcode.com/problems/walls-and-gates/discuss/72748/Benchmarks-of-DFS-and-BFS
class Solution {
    public void wallsAndGates(int[][] rooms) {
        // min(non-neg neighbors + 1)
        // bfs
        for (int i=0; i<rooms.length; i++) {
            for (int j=0; j<rooms[0].length; j++) {
                if (rooms[i][j]==0) {
                    //bfs with queue
                    Queue<List<Integer>> q = new LinkedList<> ();
                    List<Integer> source = new ArrayList<> ();
                    source.add(i);
                    source.add(j);
                    q.add(source);
                    HashSet<List<Integer>> hs = new HashSet<> ();
                    hs.add(source);
                    while (!q.isEmpty()) {
                        int size = q.size();
                        for (int k=0; k<size; k++) {
                            List<Integer> curr = q.poll();
                            int x = curr.get(0);
                            int y = curr.get(1);
                            //System.out.println(x+"  "+y);
                            List<Integer> n = new ArrayList<Integer> ();
                            n.add(x-1);
                            n.add(y);
                            // check neighbors
                            if (x>0) {
                                if (rooms[x-1][y]==0) { // is gate
                                    rooms[x][y] = Math.min(rooms[x][y], 1);
                                } else if (rooms[x-1][y]==Integer.MAX_VALUE) { // not visited
                                    if (!hs.contains(n)) q.add(n);
                                    hs.add(n);
                                } else if (rooms[x-1][y]!=-1) {
                                    if (!hs.contains(n)) q.add(n);
                                    hs.add(n);
                                    rooms[x][y] = Math.min(rooms[x][y], rooms[x-1][y]+1);
                                }
                            }
                            List<Integer> n2 = new ArrayList<Integer> ();
                            n2.add(x+1);
                            n2.add(y);
                            if (x<rooms.length-1) {
                                if (rooms[x+1][y]==0) {
                                    rooms[x][y] = Math.min(rooms[x][y], 1);
                                } else if (rooms[x+1][y]==Integer.MAX_VALUE) { // not visited
                                    if (!hs.contains(n2)) q.add(n2);
                                    hs.add(n2);
                                } else if (rooms[x+1][y]!=-1) {
                                    if (!hs.contains(n2)) q.add(n2);
                                    hs.add(n2);
                                    rooms[x][y] = Math.min(rooms[x][y], rooms[x+1][y]+1);
                                }
                            }
                            List<Integer> n3 = new ArrayList<Integer> ();
                            n3.add(x);
                            n3.add(y-1);
                            if (y>0) {
                                if (rooms[x][y-1]==0) {
                                    rooms[x][y] = Math.min(rooms[x][y], 1);
                                } else if (rooms[x][y-1]==Integer.MAX_VALUE) { // not visited
                                    if (!hs.contains(n3)) q.add(n3);
                                    hs.add(n3);
                                } else if (rooms[x][y-1]!=-1) {
                                    if (!hs.contains(n3)) q.add(n3);
                                    hs.add(n3);
                                    rooms[x][y] = Math.min(rooms[x][y], rooms[x][y-1]+1);
                                }
                            }
                            List<Integer> n4 = new ArrayList<Integer> ();
                            n4.add(x);
                            n4.add(y+1);
                            if (y<rooms[0].length-1) {
                                if (rooms[x][y+1]==0) {
                                    rooms[x][y] = Math.min(rooms[x][y], 1);
                                } else if (rooms[x][y+1]==Integer.MAX_VALUE) { // not visited
                                    if (!hs.contains(n4)) q.add(n4);
                                    hs.add(n4);
                                } else if (rooms[x][y+1]!=-1) {
                                    if (!hs.contains(n4)) q.add(n4);
                                    hs.add(n4);
                                    rooms[x][y] = Math.min(rooms[x][y], rooms[x][y+1]+1);
                                }
                            }
                        }
                    }
                }
            }
        }
        return;
    }
}