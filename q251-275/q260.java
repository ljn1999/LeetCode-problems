// 2022.05.12
// Problem Statement:
// https://leetcode.com/problems/single-number-iii/

// idea:
// https://leetcode.com/problems/single-number-iii/discuss/68900/Accepted-C%2B%2BJava-O(n)-time-O(1)-space-Easy-Solution-with-Detail-Explanations
// "Let a and b be the two unique numbers
// XORing all numbers gets you (a xor b)
// (a xor b) must be non-zero otherwise they are equal
// If bit_i in (a xor b) is 1, bit_i at a and b are different
// Find bit_i using the low bit formula m & -m
// Partition the numbers into two groups: one group with bit_i == 1 and the other group with bit_i == 0
// a is in one group and b is in the other
// a is the only single number in its group
// b is also the only single number in its group
// XORing all numbers in a's group to get a
// XORing all numbers in b's group to get b
// Alternatively, XOR (a xor b) with a gets you b"
class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i=0; i<nums.length; i++) {
            diff = diff ^ nums[i]; // XOR
        }
        diff = diff & (-diff); // one and only one bit-1 in the resulting diff
        
        int [] answer = new int [2];
        for (int i=0; i<nums.length; i++) {
            if ((nums[i] & diff) != 0) { // group 1
                answer[0] = answer[0] ^ nums[i];
            } else { // group 2
                answer[1] = answer[1] ^ nums[i];
            }
        }
        return answer;
    }
}