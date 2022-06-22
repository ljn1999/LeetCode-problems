// 2022.06.22
// Problem Statement:
// https://leetcode.com/problems/merge-sorted-array/

// idea: first move every 'effective' elements to the right inside nums1
// then merge nums1 and nums2
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=m-1; i>=0; i--) {
            int temp = nums1[i];
            nums1[i] = 0;
            nums1[nums1.length-m+i] = temp;
        }
        
        // the start comparing position for nums1 and nums2
        int idx_1=nums1.length-m, idx_2 = 0;
        for (int i=0; i<nums1.length; i++) {
            if (idx_1>=nums1.length) { // nums1 is done
                nums1[i] = nums2[idx_2];
                idx_2++;
            } else if (idx_2>=nums2.length) { // nums2 is done
                nums1[i] = nums1[idx_1];
                idx_1++;
            } else if (nums1[idx_1]<=nums2[idx_2]) {
                nums1[i] = nums1[idx_1];
                idx_1++;
            } else {
                nums1[i] = nums2[idx_2];
                idx_2++;
            }
        }
        return;
    }
}