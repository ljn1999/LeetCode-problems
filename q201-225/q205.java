// 2022.05.03
// Problem Statement:
// https://leetcode.com/problems/isomorphic-strings/

// idea: keep 2 dictionaries to make sure 1. no 2 chars map to the same char (b->a, c->a)
// 2. a char do not map to 2 different chars (a->b, a->c)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map <Character, Character> char_match = new HashMap <Character, Character>(); 
        // <char1, char2> char2 map to char1, to guarantee 1
        Map <Character, Character> char_match2 = new HashMap <Character, Character>(); 
        // <char1, char2> char1 map to char2, to guarantee 2
        for (int i=0; i<s.length(); i++) {
            if (char_match.containsKey(t.charAt(i))) {
                if (char_match.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                char_match.put(t.charAt(i), s.charAt(i));
            }
            
            if (char_match2.containsKey(s.charAt(i))) {
                if (char_match2.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                char_match2.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}