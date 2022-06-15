// 2022.06.15
// Problem Statement:
// https://leetcode.com/problems/frog-jump/

// idea: https://leetcode.com/problems/frog-jump/discuss/88824/Very-easy-to-understand-JAVA-solution-with-explanations
class Solution {
    public boolean canCross(int[] stones) {
        // only include steps that >= 1
        HashMap<Integer, HashSet<Integer>> available_steps = new HashMap<Integer, HashSet<Integer>> ();
        // initialization
        for (int i=0; i<stones.length; i++) {
            HashSet<Integer> temp = new HashSet<Integer> ();
            if (i==0) temp.add(1);
            available_steps.put(stones[i], temp);
        }
        
        // add available steps to reachable stones 
        for (int i=0; i<stones.length-1; i++) {
            for (int step : available_steps.get(stones[i])) {
                if (stones[i]+step==stones[stones.length-1]) return true;
                if (available_steps.containsKey(stones[i]+step)) {
                    if (step>1) available_steps.get(stones[i]+step).add(step-1);
                    available_steps.get(stones[i]+step).add(step);
                    available_steps.get(stones[i]+step).add(step+1);
                }
            }
        }
        return available_steps.get(stones[stones.length-1]).size()>0;
    }
}