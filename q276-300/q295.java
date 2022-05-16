// 2022.05.15
// Problem Statement:
// https://leetcode.com/problems/find-median-from-data-stream/

// idea: O(logn) binary search add, O(1) median calculation
class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<Integer> ();
    }
    
    public void addNumHelper(int num, int left, int right) {
        int middle = (left+right)/2;
        if (list.size()==0) {
            list.add(num);
            return;
        }
        if (list.get(middle)==num) {
            list.add(middle, num);
            return;
        }
        if (list.get(middle)>num) {
            if (middle==0) {
                list.add(0, num);
                return;
            } else if (list.get(middle-1)<=num) {
                list.add(middle, num);
                return;
            } else { // have to search the left
                addNumHelper(num, left, middle);
            }
        } else {
            if (middle==list.size()-1) {
                list.add(num);
                return;
            } else if (list.get(middle+1)>=num) {
                list.add(middle+1, num);
                return;
            } else { // have to search the right
                addNumHelper(num, middle+1, right);
            }
        }
    }
    
    public void addNum(int num) {
        // binary insert
        int left = 0;
        int right = list.size();
        addNumHelper(num, left, right);
    }
    
    public double findMedian() {
        if (list.size()%2==0) {
            return (double) 0.5*(list.get(list.size()/2) + list.get(list.size()/2-1));
        } else {
            return list.get(list.size()/2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */