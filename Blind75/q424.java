// 2022.09.21
// Problem Statement:
// https://leetcode.com/problems/longest-repeating-character-replacement/

// idea: so complicated...
// https://leetcode.com/problems/longest-repeating-character-replacement/discuss/358879/Java-Solution-Explained-and-Easy-to-Understand-for-Interviews 
class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> ht = new HashMap<> ();
        int answer = 0;
        int max_cnt = 0;
        int start = 0;
        for (int i=0; i<s.length(); i++) {
            ht.putIfAbsent(s.charAt(i), 0);
            ht.put(s.charAt(i), ht.get(s.charAt(i))+1);
            max_cnt = Math.max(max_cnt, ht.get(s.charAt(i)));

            if (i-start+1-max_cnt>k) { // not valid, need to remove the left-most element
                ht.put(s.charAt(start), ht.get(s.charAt(start))-1);
                start++;
            }
            answer = Math.max(answer, i-start+1);
        }
        return answer;
    }
}