// 2022.05.09
// Problem Statement:
// https://leetcode.com/problems/the-skyline-problem/

// idea: https://leetcode.com/problems/the-skyline-problem/discuss/61197/(Guaranteed)-Really-Detailed-and-Good-(Perfect)-Explanation-of-The-Skyline-Problem
// see more comments in the code
class Solution {
    public class Point implements Comparable<Point> {
        public int x;
        public int h;
        public boolean start;
        
        public Point(int x, int h, boolean start) {
            this.x = x;
            this.h = h;
            this.start = start;
        }
        
        public int compareTo(Point p) {
            if (this.x!=p.x) { // smalle x in the front
                return this.x-p.x;
            }
            if (this.start && p.start) { // when x the same, large h in the front
                return p.h-this.h;
            }
            if (!this.start && !p.start) { // when x the same, small h in the front
                return this.h-p.h;
            }
            if (this.start) return -1; // when x the same, if one is start and one is end, end goes before start
            return 1;
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // store all the start & end points, then sort
        Point[] points = new Point[buildings.length * 2];
        for (int i=0; i<buildings.length; i++) {
            points[2*i] = new Point(buildings[i][0], buildings[i][2], true);
            points[2*i+1] = new Point(buildings[i][1], buildings[i][2], false);
        }
        Arrays.sort(points);
        
        // build priority queue and put 0 inside
        List<List<Integer>> answer = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(0);
        
        // iterate all the points
        for (Point p : points) {
            if (p.start) { // if is start and the height is larger than the max of the queue,
                           // record the point in the answer and put the new height in the queue
                if (p.h>queue.peek()) {
                    List<Integer> temp = new ArrayList<Integer> ();
                    temp.add(p.x);
                    temp.add(p.h);
                    answer.add(temp);
                }
                queue.offer(p.h);
            } else { // if is end and the removal of its height will change the max of the queue,
                     // record the point in the answer (but the height should be recorded as the new max of the queue)
                queue.remove(p.h);
                if (p.h>queue.peek()) {
                    List<Integer> temp = new ArrayList<Integer> ();
                    temp.add(p.x);
                    temp.add(queue.peek());
                    answer.add(temp);
                }
            }
        }
        return answer;
    }
}