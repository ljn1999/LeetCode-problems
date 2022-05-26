// 2022.05.26 midnight
// Problem Statement:
// https://leetcode.com/problems/solve-the-equation/

// idea: seperate to left and right parts and evaluate each part to a1x+b1 and a2x+b2
// then do (b2-b1)/(a1-a2)
class Solution {
    public int [] evaluate(String s) {
        // ax+b, return {a, b}
        int a = 0, b = 0;
        int left = 0, right = 0;
        boolean add = true;
        while (right!=s.length()) {
            if (s.charAt(right)=='+' || s.charAt(right)=='-') {
                if (s.substring(left, right).contains("x")) {
                    if (right-left==1) { // it's x
                        if (add) {
                            a++;
                        } else {
                            a--;
                        }
                    } else {
                        if (add) {
                            a += Integer.valueOf(s.substring(left, right-1));
                        } else {
                            a -= Integer.valueOf(s.substring(left, right-1));
                        }
                    }
                } else if (right-left>=1) { // it's pure numerical
                    if (add) {
                        b += Integer.valueOf(s.substring(left, right));
                    } else {
                        b -= Integer.valueOf(s.substring(left, right));
                    }
                }
                if (s.charAt(right)=='+') add = true;
                else add = false;
                left = right+1;
                right++;
            } else {
                right++;
            }
        }
        // deal with the last operand
        if (s.substring(left, right).contains("x")) { // it's x
            if (right-left==1) {
                if (add) {
                    a++;
                } else {
                    a--;
                }
            } else {
                if (add) {
                    a += Integer.valueOf(s.substring(left, right-1));
                } else {
                    a -= Integer.valueOf(s.substring(left, right-1));
                }
            }
        } else { // it's pure numerical
            if (add) {
                b += Integer.valueOf(s.substring(left, right));
            } else {
                b -= Integer.valueOf(s.substring(left, right));
            }
        }
        return new int [] {a, b};
    }
    
    public String solveEquation(String equation) {
        int pos = equation.indexOf("=");
        String left = equation.substring(0, pos);
        String right = equation.substring(pos+1);
        int [] left_coeff = evaluate(left);
        int [] right_coeff = evaluate(right);
        if (left_coeff[0]==right_coeff[0] && left_coeff[1]==right_coeff[1]) {
            return "Infinite solutions";
        }
        if (left_coeff[0]==right_coeff[0] && left_coeff[1]!=right_coeff[1]) {
            return "No solution";
        }
        return "x=" + (right_coeff[1]-left_coeff[1])/(left_coeff[0]-right_coeff[0]);
    }
}