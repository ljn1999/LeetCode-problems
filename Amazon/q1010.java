// 2022.08.06 midnight
// Problem Statement:
// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

// idea: only remainder matters! check the remainder for each element (in range [0, 59]),
// and add its current complement number's count to the answer
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int [] cnt = new int [60];
        int answer = 0;
        for (int i=0; i<time.length; i++) {
            int remainder = time[i]%60;
            if (remainder==0) answer += cnt[0];
            else answer += cnt[60-remainder];
            cnt[remainder]++;
        }
        return answer;
    }
}