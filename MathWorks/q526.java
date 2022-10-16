// 2022.10.15
// Problem Statement:
// https://leetcode.com/problems/beautiful-arrangement/

// idea: backtracking, use hashtable to save calculated results
// https://leetcode.com/problems/beautiful-arrangement/discuss/99707/Java-Solution-Backtracking
class Solution {
    HashMap<String, Integer> ht;
    public int countArrangement(int n) {
        int [] used = new int [n+1];
        ht = new HashMap<> ();
        return backtracking(n, 1, used);
    }
    
    public int backtracking(int n, int idx, int [] used) {
        if (idx>=n+1) {
            return 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<used.length; i++) {
            sb.append(used[i]);
        }
        String key = sb.toString();
        if (ht.containsKey(key)) return ht.get(key);
        
        int count = 0;
        for (int i=1; i<=n; i++) {
            // check all possible numbers to put on idx
            if (used[i]!=1 && (i%idx==0 || idx%i==0)) {
                used[i] = 1;
                count += backtracking(n, idx+1, used);
                used[i] = 0;
            }
        }
        ht.put(key, count);
        return count;
    }
}