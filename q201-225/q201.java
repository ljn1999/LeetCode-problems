// 2022.05.03 midnight
// Problem Statement:
// https://leetcode.com/problems/bitwise-and-of-numbers-range/

// idea: check from msb to lsb (msb for both are 0 since positive)
// the left has to increase by 1 to get to the right, 
// therefore every bit that is different from left and right 
// would be flipped in the procedure of increament.
// after getting how many bits are the same from msb to lsb,
// set the rest bits to zero.
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if (left==right) return left;
        int same_bit_count = 1; // msb = 0 for both
        for (int i=30; i>0; i--) {
            if (left/(int)Math.pow(2, i) != right/(int)Math.pow(2, i)) {
                break;
            } else {
                same_bit_count++;
            }
        }
        return left/(int)Math.pow(2, (32-same_bit_count)) * (int)Math.pow(2, (32-same_bit_count));
    }
}