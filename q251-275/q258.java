// 2022.05.12
// Problem Statement:
// https://leetcode.com/problems/add-digits/

// idea: direct calculation
class Solution {
    public int addDigits(int num) {
        if (num<10) return num;
        if (num%9==0) return 9; // trick
        
        int answer = 0;
        boolean first_time = true;
        while (first_time || answer>=10) {
            first_time = false;
            answer = 0; // reset answer
            while (num>0) {
                answer = answer+num%10;
                num = num/10;
            }
            num = answer;
        }
        return answer;
    }
}