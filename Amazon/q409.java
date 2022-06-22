// 2022.06.22
// Problem Statement:
// https://leetcode.com/problems/longest-palindrome/

// idea: use array of length 26*2 to store count of upper case and lower case chars
// if even, can use all of them to form the palindrome, if odd, can use all but 1 of them to form the palindrome,
// but in the middle there can be odd number of chars, so if there are odd counts, should add 1 at last
class Solution {
    public int longestPalindrome(String s) {
        int [] count = new int [52]; // upper -> lower
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c-'A'>=26) { // lower case
                count[c-'a'+26]++;
            } else { // upper case
                count[c-'A']++;
            }
        }
        int answer = 0;
        boolean has_odd = false;
        for (int i=0; i<52; i++) {
            if (count[i]%2==0) { // even count
                answer += count[i];
            } else { // odd count
                answer += count[i]-1;
                has_odd = true;
            }
        }
        if (has_odd) {
            return answer+1;
        } else {
            return answer;
        }
    }
}