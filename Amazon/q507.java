// 2022.06.22
// Problem Statement:
// https://leetcode.com/problems/perfect-number/

// idea: get all its divisors and check the sum
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num==1) return false;
        List<Integer> divisor = new ArrayList<Integer> ();
        divisor.add(1);
        for (int i=2; i<=(int) Math.sqrt(num); i++) {
            if (num%i==0) {
                if (i*i!=num) {
                    divisor.add(i);
                    divisor.add((int)num/i);
                } else { // avoid duplication in appending
                    divisor.add(i);
                }
            }
        }
        int sum = 0;
        for (int i : divisor) {
            sum += i;
        }
        return sum==num;
    }
}