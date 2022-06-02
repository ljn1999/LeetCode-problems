// 2022.06.02
// Problem Statement:
// https://leetcode.com/problems/find-the-town-judge/

// idea: use a hashset to exclude not possible solutions (the ones who trust others),
// and use an int array to count how many people trust each person for the final check
class Solution {
    public int findJudge(int n, int[][] trust) {
        HashSet<Integer> candidates = new HashSet<> ();
        for (int i=1; i<=n; i++) {
            candidates.add(i);
        }
        
        int [] trust_cnt = new int [n];
        for (int i=0; i<trust.length; i++) {
            if (candidates.contains(trust[i][0])) {
                candidates.remove(trust[i][0]);
            }
            trust_cnt[trust[i][1]-1]++;
            
        }

        if (candidates.size()!=1) return -1; // at least 2 persons don't trust anyone, no judge
        int candidate = candidates.iterator().next();
        if (trust_cnt[candidate-1]==n-1) { // check if all the rest people trust the candidate judge
            return candidate;
        }
        return -1;
    }
}