// 2022.05.02
// Problem Statement:
// https://leetcode.com/problems/reverse-bits/

// idea: considering the disgusting sign issue, I take the msb and lsb out
// accomondate msb and lsb when returning
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int answer = 0;
        boolean neg = false; // if msb is 1
        boolean tail_one = (Math.floorMod(n, 2) != 0); // if lsb is 1
        if (n<0) {
            neg = true;
            n = n + (int) Math.pow(2, 31)+1; // force msb to be 0 by adding Math.pow(2, 31)
                                             // have to add an extra 1 due to overflow (I guess)
        }
        n=n/2;
        // handle the bits in the middle
        for (int i=1; i<31; i++) {
            answer = answer + Math.floorMod(n, 2) * (int) Math.pow(2, 31-i);
            n=n/2;   
        }
        // consider 4 cases
        if (!neg && !tail_one) return answer;
        else if (neg && !tail_one) return answer+1; // origin number head 1 -> add to tail
        else if (!neg && tail_one) return answer+(int)(-1)*((int)Math.pow(2, 31)+1); // origin number tail 1 -> add to head
        else return answer+1+(int)(-1)*((int)Math.pow(2, 31)+1); // orgin number head 1 and tail 1 -> add to head and tail
    }
}