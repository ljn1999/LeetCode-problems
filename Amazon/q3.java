// 2022.09.01
// Problem Statement:
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

// idea: keep track of the substring current exploring, add char directly if no duplication,
// modify substring if char duplicates
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        String curr_str = "";
        for (int i=0; i<s.length(); i++) {
            if (curr_str.indexOf(s.charAt(i))==-1) { // not appeared before
                curr_str = curr_str + Character.toString(s.charAt(i));
            } else { // appeared before, should remove the chars before (and including) the duplication one
                curr_str = curr_str.substring(curr_str.indexOf(s.charAt(i))+1);
                curr_str = curr_str + Character.toString(s.charAt(i));
            }
            answer = Math.max(answer, curr_str.length());
        }
        return answer;

        /* complexity smaller but runs slower, perhaps iterator takes too long
        int answer = 0;
        int start_idx = 0;
        Map<Character, Integer> record = new HashMap<> (); 
        for (int i=0; i<s.length(); i++) {
            if (record.containsKey(s.charAt(i))) {
                start_idx = record.get(s.charAt(i))+1;
                // remove the chars before (and including) the duplication one
                for (Iterator<Map.Entry<Character, Integer>> it = record.entrySet().iterator(); it.hasNext();) {
                    Map.Entry<Character, Integer> entry = it.next();
                    if (entry.getValue()<record.get(s.charAt(i))) {
                        it.remove();
                    }
                }
                record.put(s.charAt(i), i);
            } else {
                record.put(s.charAt(i), i);
            }
            answer = Math.max(answer, i-start_idx+1);
        }
        return answer;
        */
    }
}