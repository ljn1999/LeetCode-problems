// 2022.08.08
// Problem Statement:
// https://leetcode.com/problems/top-k-frequent-words/

// idea: utilize the compare methods in priority queue:
// https://leetcode.com/problems/top-k-frequent-words/discuss/108346/My-simple-Java-solution-using-HashMap-and-PriorityQueue-O(nlogk)-time-and-O(n)-space
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> cnt = new HashMap<> ();
        for (int i=0; i<words.length; i++) {
            if (cnt.containsKey(words[i])) cnt.put(words[i], cnt.get(words[i])+1);
            else cnt.put(words[i], 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>
            ((a, b) -> a.getValue()==b.getValue() ? 
             b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());
        
        for (Map.Entry<String, Integer> e : cnt.entrySet()) {
            pq.offer(e);
            if (pq.size()>k) pq.poll();
        }
        
        List<String> answer = new ArrayList<> ();
        while (!pq.isEmpty()) {
            answer.add(0, pq.poll().getKey());
        }
        return answer;
    }
}