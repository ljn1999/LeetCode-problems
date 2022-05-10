// 2022.05.10
// Problem Statement:
// https://leetcode.com/problems/basic-calculator-ii/

// idea: do * / first, then do + -
class Solution {
    public int calculate(String s) {
        s = s.replaceAll("\\s+",""); // remove all blank spaces
        
        // first do all the * and /
        int left_operand = 0;
        int right_operand = 0;
        int p_m_pos = -1; // + or - sign position
        int m_d_pos = -1; // * or / sign position
        boolean is_multiple = true;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='+' || s.charAt(i)=='-') {
                if (m_d_pos!=-1) { // both operands are found
                    right_operand = Integer.parseInt(String.valueOf(s.substring(m_d_pos+1, i)));
                    int temp;
                    if (is_multiple) {
                        temp = left_operand * right_operand;
                    } else {
                        temp = left_operand / right_operand;
                    }
                    // set the new string and adjust i
                    s = s.substring(0, p_m_pos+1) + Integer.toString(temp) + s.substring(i, s.length());
                    i = p_m_pos;
                    // reset m_d_pos
                    m_d_pos=-1;    
                }
                p_m_pos = i;              
            } else if (s.charAt(i)=='*' || s.charAt(i)=='/') {
                boolean is_multiple_temp = (s.charAt(i)=='*');
                if (m_d_pos==-1) { // only find the left operand
                    left_operand = Integer.parseInt(String.valueOf(s.substring(p_m_pos+1, i)));
                    m_d_pos = i;
                } else { // * * or * / or / * or / /
                    right_operand = Integer.parseInt(String.valueOf(s.substring(m_d_pos+1, i)));
                    int temp;
                    if (is_multiple) {
                        temp = left_operand * right_operand;
                    } else {
                        temp = left_operand / right_operand;
                    }
                    left_operand = temp;
                    // set the new string and adjust i
                    s = s.substring(0, p_m_pos+1) + Integer.toString(temp) + s.substring(i, s.length());
                    i = p_m_pos;
                    // adjust the m_d_pos
                    if (i>=0 && s.charAt(i)=='*' && s.indexOf('*')!=-1) m_d_pos = s.indexOf('*');
                    else if (i>=0 && s.charAt(i)=='/' && s.indexOf('/')!=-1) m_d_pos = s.indexOf('/');
                    else m_d_pos = -1;
                }
                is_multiple = is_multiple_temp;
            }
        }
        // if the last operand is * or /
        if (m_d_pos > p_m_pos) {
            int temp;
            right_operand = Integer.parseInt(String.valueOf(s.substring(m_d_pos+1, s.length())));
            if (is_multiple) {
                temp = left_operand * right_operand;
            } else {
                temp = left_operand / right_operand;
            }
            s = s.substring(0, p_m_pos+1) + Integer.toString(temp);
        }
        //System.out.println(s);
        
        // next do all the + and -, same as q224
        int answer = 0;
        left_operand = 0;
        right_operand = 0;
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
}