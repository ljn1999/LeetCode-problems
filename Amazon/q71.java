// 2022.05.23
// Problem Statement:
// https://leetcode.com/problems/simplify-path/

// idea: split by one or more slash, and then build a stack and reconstruct
class Solution {
    public String simplifyPath(String path) {
        String[] splited = path.split("\\/+");
        Stack<String> stack = new Stack<> ();
        for (String str : splited) {
            if (str.equals("..") && !stack.isEmpty()) { // pop one directory if ../
                stack.pop();
            } else if (str.equals(".")) { // ignore ./
                
            } else if (str.length()>0 && !str.equals("..")) { // push the name of the directory
                stack.add(str);
            }
        }
        
        String answer = "";
        int size = stack.size();
        for (int i=0; i<size; i++) {
            answer = "/" + stack.pop() + answer;
        }
        if (answer.length()==0) return "/";
        return answer;
    }
}