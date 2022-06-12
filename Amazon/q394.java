// 2022.06.12
// Problem Statement:
// https://leetcode.com/problems/decode-string/

// idea: use stack to track the start position for the current repeation and the number of repeation
class Solution {
    public String decodeString(String s) {
        String answer = "";
        int num=0;
        Stack<Integer> answer_idx = new Stack<Integer> ();
        Stack<Integer> number = new Stack<Integer> ();
        for (int i=0; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) { // update number of repeation
                num = num*10 + s.charAt(i)-'0';
            } else if (s.charAt(i)=='[') { // push to stack
                answer_idx.add(answer.length());
                number.add(num);
                num = 0; // reset num
            } else if (s.charAt(i)==']') { // do the current repeation
                int cnt = number.pop();
                int start_idx = answer_idx.pop();
                int length = answer.length();
                for (int c=0; c<cnt-1; c++) {
                    answer = answer + answer.substring(start_idx, length);
                }
            } else { // for letters, append directly
                answer = answer + s.charAt(i);
            }
        }
        return answer;
    }
}