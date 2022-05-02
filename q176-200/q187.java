// 2022.05.01
// Problem Statement:
// https://leetcode.com/problems/repeated-dna-sequences/

// idea: use a dictionary to store all 10-char substrings
// didn't expect it could pass the memory constraint...
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length()<=10) {
            return List.of();
        }
        
        List answer = new ArrayList();
        Map<String, Integer> substr_cnt = new HashMap<String, Integer>();
        for (int i=0; i<=s.length()-10; i++) {
            String substr = s.substring(i, i+10);
            if (substr_cnt.containsKey(substr)) {
                substr_cnt.put(substr, substr_cnt.get(substr)+1);
            } else {
                substr_cnt.put(substr, 1);
            }
        }
        for (String key : substr_cnt.keySet()) {
            if (substr_cnt.get(key) > 1) {
                answer.add(key);
            }
        }
        return answer;
    }
}