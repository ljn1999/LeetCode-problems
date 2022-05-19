// 2022.05.19 midnight
// Problem Statement:
// https://leetcode.com/problems/valid-parentheses/

// idea: use stack to push right parantheses that should appear in the reverse order of the left parantheses
// if the right parantheses found does not match the stack's top, return false
// https://leetcode.com/problems/valid-parentheses/discuss/9178/Short-java-solution
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<> ();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c=='(') {
                stack.push(')');
            } else if (c=='{') {
                stack.push('}');
            } else if (c=='[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop()!=c) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // consider more left parantheses than right parantheses cases
    }
}