// 2022.05.27
// Problem Statement:
// https://leetcode.com/problems/reverse-integer/

// idea: from x's lsb to msb,
// 10*answer + x%10 may cause overflow, have to check answer before this operation
class Solution {
    public int reverse(int x) {
        int answer = 0;
        while (x/10!=0) {
            // if (answer>(int)Math.pow(2, 31)-1 || answer<-1*(int)Math.pow(2, 31)) return 0;
            // but should not use the 'updated' answer, should check the last answer before calculating 10*answer + x%10
            if (answer > (0.1*(Math.pow(2, 31)-1) - 0.1*(x%10)) ||
                answer < (-0.1*Math.pow(2, 31) - 0.1*(x%10))) return 0; // absolute value will only get larger,
                                                                        // so an overflow is certain
            answer = 10*answer + x%10;
            x = x/10;
        }
        if (answer > (0.1*(Math.pow(2, 31)-1) - 0.1*(x%10)) ||
            answer < (-0.1*Math.pow(2, 31) - 0.1*(x%10))) return 0;
        answer = answer*10 + x;  
        return answer;
       
    }
}