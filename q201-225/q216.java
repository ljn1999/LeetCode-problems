// 2022.05.09
// Problem Statement:
// https://leetcode.com/problems/combination-sum-iii/

// idea: [k][n]'s solution = <i, [k-1][n-i]'s solution> for all unused i
// also need to take care of the ascending order in the return answer
class Solution {
    public List<List<Integer>> combinationSum3Helper(int k, int n, boolean [] used, int start) {
        List<List<Integer>> curr_answer = new ArrayList<> ();
        if (k>n || n<=0 || k<=0) return curr_answer;
        if (k==1 && n<=9 && used[n-1]==false) {
            List<Integer> single = new ArrayList<Integer> ();
            single.add(n);
            curr_answer.add(single);
            return curr_answer;
        }
        for (int i=start; i<9; i++) {
            boolean already_used = used[i];
            List<List<Integer>> temp = new ArrayList<> ();
            if (used[i] == false) {
                used[i] = true;
                temp = combinationSum3Helper(k-1, n-i-1, used, i+1);
            }
            // merge i into current answer
            if (temp.size()!=0) {
                for (int j=0; j<temp.size(); j++) {
                    if ((i+1) < temp.get(j).get(0)) { // should avoid duplication here
                        temp.get(j).add(0, i+1);
                        curr_answer.add(0, temp.get(j));
                    }
                }
            }
            if (!already_used) used[i] = false;     
        }
        return curr_answer;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k>n) return new ArrayList<> ();
        boolean [] used = new boolean [9];
        // [k][n]'s solution = <i, [k-1][n-i]'s solution> for all unused i
        return combinationSum3Helper(k, n, used, 0);
    }
}