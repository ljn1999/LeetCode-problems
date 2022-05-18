// 2022.05.17
// Problem Statement:
// https://leetcode.com/problems/word-break/

// idea: from left to right, get the possible first words, then proceed with the rest string, 
// cache the "cannot" ones, no need to cache the "can" ones, can directly return
class Solution {
    HashSet<String> word_set = new HashSet<String>();
    boolean [] cache_inverse;
    int total_length;
    public List<String> find_first_possible_words(String s) {
        List <String> first_possible_words = new ArrayList ();
        for (int i=0; i<s.length(); i++) {
            String sub = s.substring(0, i);
            if (word_set.contains(sub)) {
                first_possible_words.add(sub);
            }
        }
        return first_possible_words;
    }
    
    public boolean wordBreakHelper(String s) {
        if (cache_inverse[total_length-s.length()]==true) return false;
        if (word_set.contains(s)) {
            return true;
        }
        List <String> first_possible_words = find_first_possible_words(s);
        boolean ret = false;
        for (String first_word : first_possible_words) {
            int length = first_word.length();
            ret = ret || wordBreakHelper(s.substring(length, s.length()));
            if (ret) return true;
        }
        cache_inverse[total_length-s.length()] = true; // store inversed value
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String str : wordDict) {
            word_set.add(str);
        }
        cache_inverse = new boolean [s.length()];
        total_length = s.length();
        return wordBreakHelper(s);
    }
}