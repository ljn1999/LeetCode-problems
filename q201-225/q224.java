// 2022.05.10
// Problem Statement:
// https://leetcode.com/problems/basic-calculator/

// idea: get rid of the brackets continuously, 
// and subsitute the results (of an expression without brackets) into s
class Solution {
    public int calculate_wo_brackets(String s) {
        int answer = 0;
        int left_operand = 0;
        int right_operand = 0;
        boolean add = (s.charAt(0)!='-');
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='+') {
                if (add) {
                    answer = left_operand + right_operand;
                } else {
                    answer = left_operand - right_operand;
                }
                add = true;
                left_operand = answer;
                right_operand = 0;
            } else if (s.charAt(i)=='-') {
                if (add) {
                    answer = left_operand + right_operand;
                } else {
                    answer = left_operand - right_operand;
                }
                left_operand = answer;
                right_operand = 0;
                add = false;
            } else {
                right_operand = right_operand*10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            }
        }
        if (add) return answer + right_operand;
        return answer - right_operand;
    }
    
    public int calculate(String s) {
        s = s.replaceAll("\\s+",""); // remove all blank spaces
        // get rid of the brackets
        while (s.indexOf('(')!=-1) {
            int left_b = s.indexOf('(');
            int right_b = s.indexOf(')');
            for (int curr=left_b; curr<s.length(); curr++) {
                if (s.charAt(curr)==')') { // left most ')'
                    if (left_b==0 && curr==s.length()-1) {
                        return calculate_wo_brackets(s.substring(left_b+1, right_b));
                    }
                    right_b = curr;
                    // substitute a single number to (...)
                    int bracket_res = calculate_wo_brackets(s.substring(left_b+1, right_b));
                    if (bracket_res<0) {
                        String left = "";
                        if (left_b>=1 && s.charAt(left_b-1)=='+') {
                            left = s.substring(0, left_b-1) + "-";
                        } else if (left_b==0 && s.charAt(left_b-1)=='+') {
                            left = "-";
                        } else if (left_b>=1 && s.charAt(left_b-1)=='-') {
                            left = s.substring(0, left_b-1) + "+";
                        }
                        s = left + Integer.toString(-1*bracket_res) + s.substring(right_b+1, s.length());
                    } else {
                        s = s.substring(0, left_b) + Integer.toString(bracket_res) + 
                            s.substring(right_b+1, s.length());
                    }
                    break;
                } else if (s.charAt(curr)=='(') { // right most '(' before a ')'
                                                  // update left_b until ')' is found
                    left_b = curr;
                }
            } 
        }
        return calculate_wo_brackets(s);
    }
}