// 2022.09.21
// Problem Statement:
// https://leetcode.com/problems/day-of-the-week/

// idea: compare with today's date, calculate days since baseline (1970-12-31)
class Solution {
    private int [] months =  new int [] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private String [] weekday = new String [] {"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};
    private boolean isleap(int year) {
        if (year%400==0) return true;
        if (year%4==0 && year%100!=0) return true;
        return false;
    }
    
    private int since19701231(int day, int month, int year) {
        int days = 0;
        for (int y=1971; y<year; y++) {
            days = days+365;
            if (isleap(y)) days++;
        }
        
        for (int m=1; m<month; m++) {
            days = days + months[m-1];
            if (m==2 && isleap(year)) days++;
        }
        
        days += day;
        return days;
    }
    
    public String dayOfTheWeek(int day, int month, int year) {
        // 2022-09-21 Wed
        int a = since19701231(day, month, year);
        int b = since19701231(21, 9, 2022);

        return weekday[((a - b) % 7 + 7) % 7];
    }
}