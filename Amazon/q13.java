// 2022.05.23
// Problem Statement:
// https://leetcode.com/problems/roman-to-integer/

class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        if (s.contains("VIII")) {
            answer = 8;
            s = s.replaceAll("VIII", "");
        } else if (s.contains("III")) {
            answer = 3;
            s = s.replaceAll("III", "");
        } else if (s.contains("VII")) {
            answer = 7;
            s = s.replaceAll("VII", "");
        } else if (s.contains("II")) {
            answer = 2;
            s = s.replaceAll("II", "");
        } else if (s.contains("VI")) {
            answer = 6;
            s = s.replaceAll("VI", "");
        } else if (s.contains("IV")) {
            answer = 4;
            s = s.replaceAll("IV", "");
        } else if (s.contains("V")) {
            answer = 5;
            s = s.replaceAll("V", "");
        } else if (s.contains("IX")) {
            answer = 9;
            s = s.replaceAll("IX", "");
        } else if (s.contains("I")) {
            answer = 1;
            s = s.replaceAll("I", "");
        }
        
        if (s.contains("LXXX")) {
            answer += 80;
            s = s.replaceAll("LXXX", "");
        } else if (s.contains("XXX")) {
            answer += 30;
            s = s.replaceAll("XXX", "");
        } else if (s.contains("LXX")) {
            answer += 70;
            s = s.replaceAll("LXX", "");
        } else if (s.contains("XX")) {
            answer += 20;
            s = s.replaceAll("XX", "");
        } else if (s.contains("LX")) {
            answer += 60;
            s = s.replaceAll("LX", "");
        } else if (s.contains("XL")) {
            answer += 40;
            s = s.replaceAll("XL", "");
        } else if (s.contains("L")) {
            answer += 50;
            s = s.replaceAll("L", "");
        } else if (s.contains("XC")) {
            answer += 90;
            s = s.replaceAll("XC", "");
        } else if (s.contains("X")) {
            answer += 10;
            s = s.replaceAll("X", "");
        }
        
        if (s.contains("DCCC")) {
            answer += 800;
            s = s.replaceAll("DCCC", "");
        } else if (s.contains("CCC")) {
            answer += 300;
            s = s.replaceAll("CCC", "");
        } else if (s.contains("DCC")) {
            answer += 700;
            s = s.replaceAll("DCC", "");
        } else if (s.contains("CC")) {
            answer += 200;
            s = s.replaceAll("CC", "");
        } else if (s.contains("DC")) {
            answer += 600;
            s = s.replaceAll("DC", "");
        } else if (s.contains("CD")) {
            answer += 400;
            s = s.replaceAll("CD", "");
        } else if (s.contains("D")) {
            answer += 500;
            s = s.replaceAll("D", "");
        } else if (s.contains("CM")) {
            answer += 900;
            s = s.replaceAll("CM", "");
        } else if (s.contains("C")) {
            answer += 100;
            s = s.replaceAll("C", "");
        }
        
        if (s.contains("MMM")) {
            answer += 3000;
        } else if (s.contains("MM")) {
            answer += 2000;
        } else if (s.contains("M")) {
            answer += 1000;
        }
        
        return answer;
    }
}