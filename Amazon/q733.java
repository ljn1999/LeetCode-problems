// 2022.05.18
// Problem Statement:
// https://leetcode.com/problems/flood-fill/

// idea: bfs
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<List<Integer>> queue = new LinkedList<> ();
        List<Integer> temp = new ArrayList<> ();
        temp.add(sr);
        temp.add(sc);
        queue.add(temp);
        int color = image[sr][sc];
        HashSet<List<Integer>> visited = new HashSet<> ();
        visited.add(temp);
        while (!queue.isEmpty()) {
            List<Integer> pixel = queue.poll();
            
            // check it 4 neighbours
            int row = pixel.get(0);
            int col = pixel.get(1);
            image[row][col] = newColor;
            // left:
            if (col>0) {
                if (image[row][col-1]==color) {
                    image[row][col-1] = newColor;
                    // if not visited, add to the hashmap and queue
                    temp = new ArrayList<> ();
                    temp.add(row);
                    temp.add(col-1);
                    if (!visited.contains(temp)) {
                        visited.add(temp);
                        queue.add(temp);
                    }
                    
                }
            }
            // top:
            if (row>0) {
                if (image[row-1][col]==color) {
                    image[row-1][col] = newColor;
                    // if not visited, add to the hashmap and queue
                    temp = new ArrayList<> ();
                    temp.add(row-1);
                    temp.add(col);
                    if (!visited.contains(temp)) {
                        visited.add(temp);
                        queue.add(temp);
                    }
                    
                }
            }
            // right:
            if (col<image[0].length-1) {
                if (image[row][col+1]==color) {
                    image[row][col+1] = newColor;
                    // if not visited, add to the hashmap and queue
                    temp = new ArrayList<> ();
                    temp.add(row);
                    temp.add(col+1);
                    if (!visited.contains(temp)) {
                        visited.add(temp);
                        queue.add(temp);
                    }
                    
                }
            }
            // bottom:
            if (row<image.length-1) {
                if (image[row+1][col]==color) {
                    image[row+1][col] = newColor;
                    // if not visited, add to the hashmap and queue
                    temp = new ArrayList<> ();
                    temp.add(row+1);
                    temp.add(col);
                    if (!visited.contains(temp)) {
                        visited.add(temp);
                        queue.add(temp);
                    }
                    
                }
            }
        }
        return image;
    }
}