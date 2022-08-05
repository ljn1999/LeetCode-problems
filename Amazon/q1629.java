// 2022.08.05
// Problem Statement:
// https://leetcode.com/problems/slowest-key/

// idea: trivial
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int press_time = releaseTimes[0];
        char answer = keysPressed.charAt(0);
        for (int i=1; i<releaseTimes.length; i++) {
            if (releaseTimes[i]-releaseTimes[i-1] >= press_time) {
                if (releaseTimes[i]-releaseTimes[i-1] > press_time) {
                    answer = keysPressed.charAt(i);
                } else {
                    if (keysPressed.charAt(i) - answer > 0) {
                        answer = keysPressed.charAt(i);
                    }
                }
                press_time = releaseTimes[i]-releaseTimes[i-1];
            }
        }
        return answer;
    }
}