// 2022.05.09
// Problem Statement:
// https://leetcode.com/problems/contains-duplicate-iii/

// idea: https://leetcode.com/problems/contains-duplicate-iii/discuss/61645/AC-O(N)-solution-in-Java-using-buckets-with-explanation
// use bucket of size t+1, and use long to avoid overflow issue, and all minus -inf to avoid sign issue
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // use bucket to save search time and space when t is relatively large
        Map<Long, Long> bucket_num = new HashMap<Long, Long> ();
        for (int i=0; i<nums.length; i++) {
            long remap = (long) nums[i] - Integer.MIN_VALUE;
            long bucket_idx = (long) remap / ((long)t+1);
            if (bucket_num.containsKey(bucket_idx) ||
                (bucket_num.containsKey(bucket_idx+1) && Math.abs(remap-bucket_num.get(bucket_idx+1))<=t) ||
                (bucket_num.containsKey(bucket_idx-1) && Math.abs(remap-bucket_num.get(bucket_idx-1))<=t)) {
                return true;
            } else {
                bucket_num.put(bucket_idx, remap);
                if (i>=k) {
                    long temp = (long) nums[i-k]-Integer.MIN_VALUE;
                    temp = (long) temp / ((long)t+1);
                    bucket_num.remove(temp);
                }
            }
        }
        return false;
        
        /* TLE 2 HashSet<Integer> num_set = new HashSet<Integer> ();
        for (int i=0; i<nums.length; i++) {
            if (t==0) {
                if (num_set.contains(nums[i])) return true;
            } else {
                int left_bound, right_bound;
                if (nums[i]<(-1 * (int)Math.pow(2, 31)+t)) {
                    left_bound = -1 * (int)Math.pow(2, 31)-1;
                } else {
                    left_bound = nums[i]-t;
                }
                if (nums[i]>((int)Math.pow(2, 31)-1-t)) {
                    right_bound = (int)Math.pow(2, 31)-1;
                } else {
                    right_bound = nums[i]+t;
                }
                for (int j : num_set) {
                    //System.out.println("l "+left_bound+" r "+right_bound+" j"+j);
                    if (j>=left_bound && j<=right_bound) {
                        //System.out.print("here "+j+" "+nums[i]);
                        return true;
                    }
                }
            }
            num_set.add(nums[i]);
            if (i>=k) {
                num_set.remove(nums[i-k]);
            }
        }
        return false; */
        /* TLE 1 Map <Integer, Integer> num_idx = new HashMap <Integer, Integer> ();
        for (int i=0; i<nums.length; i++) {
            int left_bound, right_bound;
            if (nums[i]<(-1 * (int)Math.pow(2, 31)+t)) {
                left_bound = -1 * (int)Math.pow(2, 31);
            } else {
                left_bound = nums[i]-t;
            }
            if (nums[i]>((int)Math.pow(2, 31)-1-t)) {
                right_bound = (int)Math.pow(2, 31)-1;
            } else {
                right_bound = nums[i]+t;
            }
            for (int j=left_bound; j<=right_bound; j++) {
                //System.out.println(j);
                if (num_idx.containsKey(j) && i-num_idx.get(j)<=k) return true;
            }
            num_idx.put(nums[i], i);
        }
        return false;*/
    }
}