// 2022.10.16
// Problem Statement:
// https://leetcode.com/problems/longest-string-chain/

// idea: dfs + dp, dp[word] = max(dp[pred(word)])+1
class Solution {
    HashSet<String> hs;
    HashMap<String, Integer> ht;
    
    private List<String> findPredecessor(String word) {
        List<String> ret = new ArrayList<> ();
        if (word.length()==1) return ret;
        for (int i=0; i<word.length(); i++) {
            String temp;
            if (i==0) temp = word.substring(i+1);
            else if (i==word.length()-1) temp = word.substring(0, i);
            else temp = word.substring(0, i) + word.substring(i+1);
            if (hs.contains(temp)) {
                ret.add(temp);
            }
        }
        return ret;
    }
    
    private int dfs(String word) {
        if (ht.containsKey(word)) return ht.get(word);
        
        List<String> pre = findPredecessor(word);
        if (pre.size()==0) {
            ht.put(word, 1);
            return 1;
        }
        
        int max_length = 0;
        for (String s : pre) {
            max_length = Math.max(dfs(s), max_length);
        }
        max_length++;
        ht.put(word, max_length);
        return max_length;
    }
    
    public int longestStrChain(String[] words) {
        int answer = 1;
        hs = new HashSet<> ();
        ht = new HashMap<> ();
        for (String s : words) {
            hs.add(s);
        }
        
        for (String s : words) {
            answer = Math.max(answer, dfs(s));
        }
        
        return answer;
    }
}