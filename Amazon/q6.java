// 2022.06.29
// Problem Statement:
// https://leetcode.com/problems/zigzag-conversion/

// idea: group by 2*numRows-2 elements, iteration ordered by rows
// in row 0 and numRows-1, only 1 char in each group should be added
// for rows in the middle, add 2 chars in each group
class Solution {
    public String convert(String s, int numRows) {
        String answer = "";
        if (numRows==1) return s;
        for (int i=0; i<numRows; i++) {
            for (int j=0; j<s.length()/(2*numRows-2)+1; j++) { // iterate over all groups
                if (i==0) {
                    if (j*(2*numRows-2) < s.length()) { // check boundary
                        answer = answer + s.charAt(j*(2*numRows-2));
                    }
                } else if (i==numRows-1) {
                    if (j*(2*numRows-2)+numRows-1 < s.length()) {
                        answer = answer + s.charAt(j*(2*numRows-2)+numRows-1);
                    }
                } else {
                    if (j*(2*numRows-2)+i < s.length()) {
                        answer = answer + s.charAt(j*(2*numRows-2)+i);
                    }
                    if (j*(2*numRows-2)+(2*numRows-2-i) < s.length()) {
                        answer = answer + s.charAt(j*(2*numRows-2)+(2*numRows-2-i));
                    }
                }
            }
        }
        return answer;
    }
}