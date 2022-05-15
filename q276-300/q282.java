// 2022.05.13
// Problem Statement:
// https://leetcode.com/problems/expression-add-operators/

// idea: https://leetcode.com/problems/expression-add-operators/discuss/71895/Java-Standard-Backtrace-AC-Solutoin-short-and-clear
// back tracking, push to answer when num is finished and evaluation result == target
// otherwise try new possible operands with different digits at the starting position
class Solution {
    public void addOperatorsHelper(String num, int target, String curr_path, int position, long eval, long multed, List<String> answer) {
        if (position==num.length()) {
            if (eval==target) {
                answer.add(curr_path);
            }
            return;
        }
        for (int i=position; i<num.length(); i++) {
            if (i!=position && num.charAt(position)=='0') { // leading zero, cannot take it
                break;
            }
            long curr_num = Long.parseLong(num.substring(position, i + 1));
            if (position==0) {
                addOperatorsHelper(num, target, curr_path+curr_num, i+1, curr_num, curr_num, answer);
            } else {
                // +
                addOperatorsHelper(num, target, curr_path+"+"+curr_num, i+1, 
                                   eval+curr_num, curr_num, answer);
                // -
                addOperatorsHelper(num, target, curr_path+"-"+curr_num, i+1, 
                                   eval-curr_num, -1*curr_num, answer);
                // *, should remove the multed term in the previous a+multed, and accumulate the new multed
                addOperatorsHelper(num, target, curr_path+"*"+curr_num, i+1, 
                                   eval-multed+multed*curr_num, multed*curr_num, answer);
            }
        }
        return;
    }
    
    public List<String> addOperators(String num, int target) {
        List<String> answer = new ArrayList<String> ();
        String curr_path = "";
        addOperatorsHelper(num, target, curr_path, 0, 0, 0, answer);
        return answer;
    }
}