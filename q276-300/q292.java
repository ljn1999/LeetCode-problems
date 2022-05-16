// 2022.05.15
// Problem Statement:
// https://leetcode.com/problems/nim-game/

// idea: simple math as stated below
class Solution {
    public boolean canWinNim(int n) {
        // k=false only if (k-1 & k-2 & k-3)=true
        // because no matter if I take 1 or 2 or 3, 
        // my opponent will get to a must-win start-position
        // so 3 true will result in one false, and one false will result in 3 true following
        // TTTF, TTTF, TTTF...

        // no need for that!
        /*if (n<=3) return true;
        boolean temp1 = true;
        boolean temp2 = true;
        boolean temp3 = true;
        boolean answer = true;
        for (int i=3; i<n; i++) {
            answer = !(temp1 && temp2 && temp3);
            temp1 = temp2;
            temp2 = temp3;
            temp3 = answer;
        }*/
        return n%4!=0;
    }
}