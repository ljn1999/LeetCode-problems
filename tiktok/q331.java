// 2022.10.02
// Problem Statement:
// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/

// idea: use stack, 1, 2, 3, #, # -> 1, 2, #
// see if the final stack is #
class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> l = new Stack<> ();
        String [] s_l = preorder.split(",");
        for (int i=0; i<s_l.length; i++) {
            if (!s_l[i].equals("#") || (i>0 && !l.peek().equals("#"))) {
                l.push(s_l[i]);
                continue;
            }
            
            l.push(s_l[i]);
            while (l.size()>=2) {
                String last = l.pop();
                String last_but_1 = l.peek();
                l.push(last);
                if (last_but_1.equals("#") && last.equals("#")) {
                    if (l.size()==2) return false;
                    l.pop();
                    l.pop();
                    l.pop();
                    l.push("#");
                } else {
                    break;
                }
            }
        }
        return (l.size()==1 && l.get(0).equals("#"));
    }
}