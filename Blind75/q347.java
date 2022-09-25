// 2022.09.25
// Problem Statement:
// https://leetcode.com/problems/top-k-frequent-elements/

// idea: use a priority queue to sort map entries, and get the first k
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> ht = new HashMap<> (); // key: number, val: freq
        for (int i=0; i<nums.length; i++) {
            ht.putIfAbsent(nums[i], 0);
            ht.put(nums[i], ht.get(nums[i])+1);
        }
        
        // build priority queue
        PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<> (ht.size(), new Comparator<Map.Entry<Integer,Integer>> () {
            @Override
            public int compare(Map.Entry<Integer,Integer> e1, Map.Entry<Integer,Integer> e2) {
                if (e1.getValue()>e2.getValue()) return -1;
                else if (e1.getValue()==e2.getValue()) return 0;
                return 1;
            }
        });
        
        Iterator<Map.Entry<Integer,Integer>> it = ht.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer,Integer> e = it.next();
            q.offer(e);
        }
        
        int [] answer = new int [k];
        for (int i=0; i<k; i++) {
            answer[i] = q.poll().getKey();
        }
        return answer;
    }
}