// 2022.05.13 midnight
// Problem Statement:
// https://leetcode.com/problems/ugly-number-ii/

// idea: https://leetcode.com/problems/ugly-number-ii/discuss/69362/O(n)-Java-solution
// merge sort, making the array the same time as doing the sort, so brilliant
class Solution {
    public int nthUglyNumber(int n) {
        int [] answer = new int [n];
        // merge sort
        int factor_2 = 2, factor_3 = 3, factor_5 = 5;
        int index_2 = 0, index_3 = 0, index_5 = 0;
        for (int i=0; i<n; i++) {
            if (i==0) answer[i] = 1;
            else {
                int min = Math.min(Math.min(factor_2, factor_3), factor_5);
                answer[i] = min;
                if (factor_2==min) { // update factor_2
                    index_2++;
                    factor_2 = 2*answer[index_2];
                }
                if (factor_3==min) { // update factor_3
                    index_3++;
                    factor_3 = 3*answer[index_3];
                }
                if (factor_5==min) { // update factor_5
                    index_5++;
                    factor_5 = 5*answer[index_5];
                }
            }
        }
        return answer[n-1];
     }
}