// 2022.05.22
// Problem Statement:
// https://leetcode.com/problems/integer-to-roman/

// idea: if-else like an robot
class Solution {
    public String intToRoman(int num) {
        String answer = "";
        // 1st
        int last_d = num%10;
        if (last_d==1) {
            answer = "I";
        } else if (last_d==2) {
            answer = "II";
        } else if (last_d==3) {
            answer = "III";
        } else if (last_d==4) {
            answer = "IV";
        } else if (last_d==5) {
            answer = "V";
        } else if (last_d==6) {
            answer = "VI";
        } else if (last_d==7) {
            answer = "VII";
        } else if (last_d==8) {
            answer = "VIII";
        } else if (last_d==9) {
            answer = "IX";
        }
        
        // 2nd
        num = num/10;
        if (num==0) return answer;
        last_d = num%10;
        if (last_d==1) {
            answer = "X"+answer;
        } else if (last_d==2) {
            answer = "XX"+answer;
        } else if (last_d==3) {
            answer = "XXX"+answer;
        } else if (last_d==4) {
            answer = "XL"+answer;
        } else if (last_d==5) {
            answer = "L"+answer;
        } else if (last_d==6) {
            answer = "LX"+answer;
        } else if (last_d==7) {
            answer = "LXX"+answer;
        } else if (last_d==8) {
            answer = "LXXX"+answer;
        } else if (last_d==9) {
            answer = "XC"+answer;
        }
        
        // 3rd
        num = num/10;
        if (num==0) return answer;
        last_d = num%10;
        if (last_d==1) {
            answer = "C"+answer;
        } else if (last_d==2) {
            answer = "CC"+answer;
        } else if (last_d==3) {
            answer = "CCC"+answer;
        } else if (last_d==4) {
            answer = "CD"+answer;
        } else if (last_d==5) {
            answer = "D"+answer;
        } else if (last_d==6) {
            answer = "DC"+answer;
        } else if (last_d==7) {
            answer = "DCC"+answer;
        } else if (last_d==8) {
            answer = "DCCC"+answer;
        } else if (last_d==9) {
            answer = "CM"+answer;
        }
        
        // 4th
        num = num/10;
        if (num==0) return answer;
        last_d = num%10;
        if (last_d==1) {
            answer = "M"+answer;
        } else if (last_d==2) {
            answer = "MM"+answer;
        } else {
            answer = "MMM"+answer;
        }
        return answer;
    }
}