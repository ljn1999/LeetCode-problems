// 2022.08.05
// Problem Statement:
// https://leetcode.com/problems/maximum-units-on-a-truck/

// idea: sort the 2d array by the second element (units per box), takes O(NlogN),
// then take boxes from largest to lowest second element
// can also use counting sort which takes O(N), as there's a limit in elements value (<=1000)
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Double.compare(b[1], a[1]));
        int answer = 0;
        for (int i=0; i<boxTypes.length; i++) {
            if (truckSize<boxTypes[i][0]) {
                answer += truckSize*boxTypes[i][1];
                return answer;
            }
            truckSize -= boxTypes[i][0];
            answer += boxTypes[i][0]*boxTypes[i][1];
        }
        return answer;
    }
}