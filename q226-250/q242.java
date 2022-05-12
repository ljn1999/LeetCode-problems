// 2022.05.12
// Problem Statement:
// https://leetcode.com/problems/valid-anagram/

// idea: build 2 maps and store the frequencies, compare at the very end
// a better idea: use an array of length 26, +1 when appears in s, -1 when appears in t,
// return false if the final array is not all-0
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        Map <Character, Integer> map_s = new HashMap <> ();
        Map <Character, Integer> map_t = new HashMap <> ();
        for (int i=0; i<s.length(); i++) {
            if (map_s.containsKey(s.charAt(i))) {
                map_s.put(s.charAt(i), map_s.get(s.charAt(i))+1);
            } else {
                map_s.put(s.charAt(i), 1);
            }
            if (map_t.containsKey(t.charAt(i))) {
                map_t.put(t.charAt(i), map_t.get(t.charAt(i))+1);
            } else {
                map_t.put(t.charAt(i), 1);
            }
        }
        
        for (char c : map_s.keySet()) {
            if (!map_t.containsKey(c)) {
                return false;
            } else if (map_t.get(c)<map_s.get(c) || map_t.get(c)>map_s.get(c)) {
                return false;
            } 
        }
        return true;
    }
}