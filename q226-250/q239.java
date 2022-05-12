// 2022.05.12
// Problem Statement:
// https://leetcode.com/problems/sliding-window-maximum/

// idea: use 2 deques to track the max
// deque: stores the possible values for the max (size <= k)
// deque_idx: stores the corresponding indices of the possible values
// deque: all numbers in decending order, the first is the max, 
// and remove the first if the first idx is out of range
// core: the numbers that are small and in the front do not need to be put into the deque
// when coming across a new number, if the new number is larger than the first one (current largest),
// clear the deques and put the new number in; if the new number is larger than part of its
// neighbours (in the deque), remove the continuously-smaller ones before the new number;
// if the new number is smaller than the last one in the deque, add the number directly.
// always check the index of the first number and see if it's out of range.
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k==1) return nums;
        Deque<Integer> deque = new ArrayDeque<Integer> ();
        Deque<Integer> deque_idx = new ArrayDeque<Integer> ();
        int [] answer = new int [nums.length-k+1];
        int count = 0; // index to put into the answer array
        int curr_largest=0; // can substitute with deque.getFrist()
        
        for (int i=0; i<nums.length; i++) {
            if (deque.size()==0) { // empty deque
                deque.addFirst(nums[i]);
                deque_idx.addFirst(i);
                curr_largest = nums[i];
            } else if (nums[i]>curr_largest) { // new number is the max
                deque.clear();
                deque_idx.clear();
                deque.addFirst(nums[i]);
                deque_idx.addFirst(i);
                curr_largest = nums[i];
                if (i+1>=k) { // fill in the answer array
                    answer[count] = curr_largest;
                    count++;
                }
            } else if (nums[i]<deque.getLast()) { // new number is smaller than the last, add into the deque
                deque.addLast(nums[i]);
                deque_idx.addLast(i);
                if (i-k>=deque_idx.getFirst()) { // curr_largest out of range
                    deque.removeFirst();
                    deque_idx.removeFirst();
                    curr_largest = deque.getFirst();
                }
                if (i+1>=k) { // fill in the answer array
                    answer[count] = curr_largest;
                    count++;
                }
            } else {
                while (deque.size()!=0) { // new number is larger than part of its neighbours
                    if (nums[i]>=deque.getLast()) {
                        deque.removeLast();
                        deque_idx.removeLast();
                    } else {
                        break;
                    }
                }
                deque.addLast(nums[i]);
                deque_idx.addLast(i);
                if (i-k>=deque_idx.getFirst()) { // curr_largest out of range
                    deque.removeFirst();
                    deque_idx.removeFirst();
                    curr_largest = deque.getFirst();
                }
                if (i+1>=k) { // fill in the answer array
                    answer[count] = deque.getFirst();
                    count++;
                }
            }
        }
        return answer;
    }
}