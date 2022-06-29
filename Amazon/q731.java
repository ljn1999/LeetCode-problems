// 2022.06.29
// Problem Statement:
// https://leetcode.com/problems/my-calendar-ii/

// idea: store all existing overlaps, if overlap with overlaps -> triple booking, do not add;
// if doesn't overlap with overlaps -> add to bookings and update overlaps
// do need to do binary search for this problem,
// an easier solution using the book function (from calendar version 1) to check/update overlaps:
// https://leetcode.com/problems/my-calendar-ii/discuss/109519/JavaC%2B%2B-Clean-Code-with-Explanation
class MyCalendarTwo {
    List<int[]> bookings;
    List<int[]> overlaps;
    
    public MyCalendarTwo() {
        bookings = new ArrayList<> ();
        overlaps = new ArrayList<> ();
    }
    
    public List<int[]> getOverlap(List<int[]> intervals, int start, int end) {
        // return overlaps in a list or empty list
        List<int[]> ret = new ArrayList<> ();
        for (int i=0; i<intervals.size(); i++) {
            if (end<=intervals.get(i)[0] || start>=intervals.get(i)[1]) { // no overlap
                continue;
            } else {
                int[] temp = new int [2];
                temp[0] = Math.max(start, intervals.get(i)[0]);
                temp[1] = Math.min(end, intervals.get(i)[1]);
                ret.add(temp);
            }
        }
        return ret;
    }
    
    public boolean book(int start, int end) {
        List<int[]> overlap_with_overlaps = getOverlap(overlaps, start, end);
        if (overlap_with_overlaps.size()>0) return false;
        
        List<int[]> overlap_with_bookings = getOverlap(bookings, start, end);
        for (int[] i : overlap_with_bookings) {
            overlaps.add(i);
        }
        int[] temp = new int [2];
        temp[0] = start;
        temp[1] = end;
        bookings.add(temp);
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */