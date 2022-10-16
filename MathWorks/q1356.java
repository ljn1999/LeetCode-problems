// 2022.10.16 midnight
// Problem Statement:
// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

// idea: bit manipulation to get number of 1s, then store to according postion in 2d arraylist,
// finally append the 2d arraylist to answer
class Solution {
    private int number1s(int n) {
        int t = 0x1;
        int count = 0;
        while (n!=0) {
            count += t & n;
            n = n>>1;
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        int t = 0x1;
        List<List<Integer>> l = new ArrayList<> ();
        for (int i=0; i<33; i++) {
            l.add(new ArrayList<Integer> ());
        }
        for (int n : arr) {
            int cnt = number1s(n);
            l.get(cnt).add(n);
        }
        
        int [] answer = new int [arr.length];
        int idx = 0;
        for (int i=0; i<33; i++) {
            if (l.get(i).size()>0) {
                Collections.sort(l.get(i));
                for (int j=0; j<l.get(i).size(); j++) {
                    answer[idx] = l.get(i).get(j);
                    idx++;
                }
            }
        }
        return answer;
        
    }
}