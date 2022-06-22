// 2022.06.22
// Problem Statement:
// https://leetcode.com/problems/jewels-and-stones/

// idea: similar as question 409, set isJewel[idx] to true according to jewels and then check the stones
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean [] isJewel = new boolean [52]; // upper -> lower
        for (int i=0; i<jewels.length(); i++) {
            char c = jewels.charAt(i);
            if (c-'A'>=26) { // lower case
                isJewel[c-'a'+26] = true;
            } else { // upper case
                isJewel[c-'A'] = true;
            }
        }
        
        int answer = 0;
        for (int i=0; i<stones.length(); i++) {
            char c = stones.charAt(i);
            if (c-'A'>=26 && isJewel[c-'a'+26]) { // lower case and is jewel
                answer++;
            } else if (c-'A'<26 && isJewel[c-'A']) { // upper case and is jewel
                answer++;
            }
        }
        return answer;
    }
}