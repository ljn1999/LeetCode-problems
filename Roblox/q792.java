// 2022.08.28
// Problem Statement:
// https://leetcode.com/problems/number-of-matching-subsequences/

// idea: https://leetcode.com/problems/number-of-matching-subsequences/discuss/117598/Java-solution-using-HashMap-and-Queue
// use a hashtable to store keys: 'a' to 'z', val: the strings that starts with key;
// update the hashtable when moving the s forward
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int answer = 0;
        Map<Character, Deque<String>> ht = new HashMap<> ();
        
        // initialize the hashtable
        for (int i=0; i<26; i++) {
            char c = 'a';
            c += i;
            ht.put(c, new LinkedList<String> ());
        }
        for (int i=0; i<words.length; i++) {
            ht.get(words[i].charAt(0)).add(words[i]);
        }
        
        for (int i=0; i<s.length(); i++) {
            Deque<String> q = ht.get(s.charAt(i)); // find the sub-words that start with the current char
            int size = q.size();
            for (int j=0; j<size; j++) {
                String str = q.removeFirst();
                if (str.length()==1) { // finish one
                    answer++;
                    continue;
                } else { // update the sub-word and change its position in hashtable
                    str = str.substring(1);
                    ht.get(str.charAt(0)).addLast(str);
                }
            }
        }
        return answer;

        /* TLE 1
        int answer = 0;
        for (int i=0; i<words.length; i++) {
            if (isSubseq(s, words[i])) answer++;
        }
        return answer;
        */
        
        /* TLE 2
        int answer = 0;
        int [] pos = new int [words.length];
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<words.length; j++) {
                if (pos[j]==words[j].length()) continue;
                if (words[j].charAt(pos[j]) == s.charAt(i)) {
                    pos[j]++;
                    if (pos[j]==words[j].length()) answer++;
                }
            }
        }
        return answer;
        */
        
    }

    /* TLE 1
    public boolean isSubseq(String s1, String s2) {
        if (s2.length()==0) return true;
        if (s1.length()==0) return false;
        if (s2.length()>s1.length()) return false;
        if (s2.length()==s1.length()) return (s1.equals(s2));
        
        if (s1.charAt(0)==s2.charAt(0)) {
            return isSubseq(s1.substring(1), s2.substring(1));
        } else {
            return isSubseq(s1.substring(1), s2);
        }
    }
    */
}