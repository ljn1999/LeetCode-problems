// 2022.05.12
// Problem Statement:
// https://leetcode.com/problems/different-ways-to-add-parentheses/

// idea: dp, the result of expression from number i to number j
// = collection of (result of number i to number k _operand_ result of number k+1 to number j)
// where k is between i and j
class Solution {
    public List<Integer> diffWaysToComputeHelper(List<Integer> numbers, List<Character> operands, 
                                                 Map <List<Integer>, List<Integer>> dp, int start, int end) {
        List<Integer> key = new ArrayList <> ();
        key.add(start);
        key.add(end);
        if (dp.containsKey(key)) { // base case 1, already stored
            return dp.get(key);
        }
        if (end-start==1) { // base case 2: just one number, one possibility
            List<Integer> val = new ArrayList <> ();
            val.add(numbers.get(start));
            dp.put(key, val);
            return val;
        }
        List<Integer> curr_answer = new ArrayList<Integer> ();
        for (int i=start+1; i<end; i++) {
            List<Integer> left = diffWaysToComputeHelper(numbers, operands, dp, start, i);
            List<Integer> right = diffWaysToComputeHelper(numbers, operands, dp, i, end);
            for (int j=0; j<left.size(); j++) {
                for (int k=0; k<right.size(); k++) {
                    if (operands.get(i-1)=='+') {
                        curr_answer.add(left.get(j)+right.get(k));
                    } else if (operands.get(i-1)=='-') {
                        curr_answer.add(left.get(j)-right.get(k));
                    } else {
                        curr_answer.add(left.get(j)*right.get(k));
                    }
                }
            }
        }
        dp.put(key, curr_answer);
        return curr_answer;
    }
    
    public List<Integer> diffWaysToCompute(String expression) {
        // handle the expression
        // store operands (+,-,*) and numbers in 2 arraylists
        List<Character> operands = new ArrayList<Character> ();
        List<Integer> numbers = new ArrayList<Integer> ();
        int start = 0;
        int end = 0;
        for (int i=0; i<expression.length(); i++) {
            if (expression.charAt(i)=='+') {
                operands.add('+');
                end = i;
                numbers.add(Integer.parseInt(expression.substring(start, end)));
                start = i+1;
                end = i+1;
            } else if (expression.charAt(i)=='-') {
                operands.add('-');
                end = i;
                numbers.add(Integer.parseInt(expression.substring(start, end)));
                start = i+1;
                end = i+1;
            } else if (expression.charAt(i)=='*') {
                operands.add('*');
                end = i;
                numbers.add(Integer.parseInt(expression.substring(start, end)));
                start = i+1;
                end = i+1;
            } else {
                end++;
            }
        }
        numbers.add(Integer.parseInt(expression.substring(start, expression.length())));

        Map <List<Integer>, List<Integer>> dp = new HashMap<>(); // <start, end>, value list
        return diffWaysToComputeHelper(numbers, operands, dp, 0, numbers.size());
    }
}