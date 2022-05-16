// 2022.05.15
// Problem Statement:
// https://leetcode.com/problems/find-the-duplicate-number/

// idea: https://leetcode.com/problems/find-the-duplicate-number/discuss/1892921/Java-9-Approaches-Count-%2B-Hash-%2B-Sort-%2B-Binary-Search-%2B-Bit-%2B-Fast-Slow-Pointers
// 2 in Time O(n) and Space O(1), index manipulation & fast and slow pointers
// fast and slow pointers is slower, doesn't modify the input array tho
class Solution {
    public int findDuplicate(int[] nums) {
        // does modifies the nums!!!
        // set the number at index=nums[i] to be negative,
        // index range [0, n], nums[i] range [1, n]
        // if the number in one index is set twice -> duplication found
        for (int i=0; i<nums.length; i++) {
            int temp = Math.abs(nums[i]);
            if (nums[temp]<0) {
                return temp;
            } else {
                nums[temp] = -1*nums[temp];
            }
        }
        return 0;
    }
    
    public int findDuplicate(int[] nums) {
        // fast and slow
        // 1,3,4,2,2 consider as 0->1, 1->3, 2->4, 3->2, 4->2
        // 0->1->3->2->4->2-4->2
        // equivalent as finding the circle
        // this.next = nums[this]
        int fast=0, slow=0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast!=slow);
        
        slow=0;
        while (fast!=slow) {
            fast = nums[fast];
            slow = nums[slow];
        } // meet at the tail of the circle
        return fast;
    }
}