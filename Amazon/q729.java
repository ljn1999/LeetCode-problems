// 2022.06.15
// Problem Statement:
// https://leetcode.com/problems/my-calendar-i/

// idea: binary search for insertion position, and insert to the right position to keep sorted lists
class MyCalendar {
    List<Integer> start_date;
    List<Integer> end_date;
    public MyCalendar() {
        start_date = new ArrayList<Integer> ();
        end_date = new ArrayList<Integer> ();
    }
    
    public boolean book(int start, int end) {
        if (start_date.size()==0) {
            start_date.add(start);
            end_date.add(end);
            return true;
        }
        
        // [ )
        int left = 0, right = start_date.size();
        while (left<right) {
            int mid = left + (right-left)/2;
            if (start_date.get(mid)==start) return false;
            if (start_date.get(mid)>start) {
                right = mid; // mid will NOT be the insertion position
            } else {
                left = mid+1; // mid would be the insertion position
            }
        }
        
        // position of start to insert in start_date is left, check legality
        if (left<start_date.size() && end>start_date.get(left)) return false;
        if (left<1 || start>=end_date.get(left-1)) {
            start_date.add(left, start);
            end_date.add(left, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */