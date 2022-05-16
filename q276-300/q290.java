// 2022.05.15
// Problem Statement:
// https://leetcode.com/problems/word-pattern/

// idea: use 2 hash tables to track char-str matching
// a better idea: https://leetcode.com/problems/word-pattern/discuss/73402/8-lines-simple-Java
// use ht.put()'s return value (-1 if key not appeared before, else previous values)
// if ht.put(char, i) != ht.put(str, i), then either of them were not in the ht before, 
// which results in a non-match
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] s_list = s.split("\\s+");
        if (pattern.length()!=s_list.length) return false;
        Map<Character, String> ht_1 = new HashMap<Character, String> ();
        Map<String, Character> ht_2 = new HashMap<String, Character> ();
        for (int i=0; i<pattern.length(); i++) {
            if (ht_1.containsKey(pattern.charAt(i))) {
                if (!ht_1.get(pattern.charAt(i)).equals(s_list[i])) {
                    return false;
                }
            } else {
                ht_1.put(pattern.charAt(i), s_list[i]);
            }
            
            if (ht_2.containsKey(s_list[i])) {
                if (Character.compare(ht_2.get(s_list[i]), pattern.charAt(i))!=0) {
                    return false;
                }
            } else {                
                ht_2.put(s_list[i], pattern.charAt(i));
            }
        }
        return true;
    }
}