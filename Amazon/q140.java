// 2022.05.22
// Problem Statement:
// https://leetcode.com/problems/word-break-ii/

// idea: dfs with cache: https://leetcode.com/problems/word-break-ii/discuss/44167/My-concise-JAVA-solution-based-on-memorized-DFS
class Solution {
    public List<String> dfs(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s)) return map.get(s);
        LinkedList<String> answer = new LinkedList<> ();
        if (s.length()==0) {
            answer.add(""); // empty string
            return answer;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> temp = dfs(s.substring(word.length()), wordDict, map);
                for (String str : temp) {
                    if (str.length()==0) {
                        answer.add(word);
                    } else {
                        answer.add(word+" "+str);
                    }
                }
            }
        }
        map.put(s, answer);
        return answer;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, LinkedList<String>>());
    }
}