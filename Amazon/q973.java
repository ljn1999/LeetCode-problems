// 2022.08.08
// Problem Statement:
// https://leetcode.com/problems/k-closest-points-to-origin/

// idea: selection sort or quick sort, if the pivot idx is k-1 or k, the first k closest points are found,
// if the pivot idx is larger than k, only the left part need to be sorted again,
// if the pivot idx is smaller than k-1, only the right part need to be sorted again
// somehow priority queue or direct sort is faster: 
// https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.
class Solution {
    public int distance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
    
    public int partition(int[][] points, int start, int end) {
        int [] p = points[end];
        int pd = distance(p);
        int i=start-1;
        for (int j=start; j<end; j++) {
            if (distance(points[j])<=pd) {
                i++;
                int [] temp = new int [2];
                temp = points[i];
                points[i] = points[j];
                points[j] = temp;
            }
        }
        i++;
        int [] temp = new int [2];
        temp = points[i];
        points[i] = p;
        points[end] = temp;
        return i;
    }
    
    public void kClosestHelper(int[][] points, int start, int end, int k) {
        int pivot = partition(points, start, end);
        if (pivot==k-1 || pivot==k) {
            return;
        } else if (pivot>k-1) { // pivot is larger than kth, sort the part left to pivot
            kClosestHelper(points, start, pivot-1, k);
        } else { // pivot is smaller than kth, sort the part right to pivot
            kClosestHelper(points, pivot+1, end, k);
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        kClosestHelper(points, 0, points.length-1, k);
        int [][] answer = new int [k][2];
        for (int i=0; i<k; i++) {
            answer[i][0] = points[i][0];
            answer[i][1] = points[i][1];
        }
        return answer;
    }
}