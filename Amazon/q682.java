// 2022.05.27
// Problem Statement:
// https://leetcode.com/problems/baseball-game/

// idea: build a stack to store the scores, first in last out
class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> scores = new Stack<Integer> ();
        for (int i=0; i<ops.length; i++) {
            if (ops[i].equals("C")) {
                scores.pop();
            } else if (ops[i].equals("D")) {
                int to_double = scores.lastElement();
                scores.add(to_double*2);
            } else if (ops[i].equals("+")) {
                int second = scores.pop();
                int first = scores.pop();
                scores.add(first);
                scores.add(second);
                scores.add(first+second);
            } else {
                scores.add(Integer.valueOf(ops[i]));
            }
        }
        int sum = 0;
        for (int i : scores) {
            sum += i;
        }
        return sum;
    }
}