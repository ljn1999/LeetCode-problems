# 2020.07.08
# This question was so hard that I didn't come up with the solution on my own.
# I read a solution providied by leetcode and then wrote my solution using the idea of that.

class Solution:
    # helper function for doing binary search
    def binarySearch(low_bound, up_bound):
        # return binary index
        # low_bound and up_bound both included
        return int((up_bound + low_bound) / 2)
        
        
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        m = len(nums1)
        n = len(nums2)
        
        # switch m, n, nums1, nums2, to keep nums2 longer, to avoid nums2[j] out of range issues later
        if m > n:
            nums1, nums2 = nums2, nums1
            m, n = n, m

        even = ((m+n) % 2 == 0)

        # check empty, do return directly
        if m == 0:
            if n % 2 != 0:
                return nums2[int((n-1)/2)]
            else:
                return (nums2[int(n/2)] + nums2[int(n/2-1)]) / 2
        elif n == 0:
            if m % 2 != 0:
                return nums1[int((m-1)/2)]
            else:
                return (nums1[int(m/2)] + nums1[int(m/2-1)]) / 2
            
        # check both single value lists
        if m == 1 and n == 1:
            return (nums1[0] + nums2[0]) / 2
        
        # i,j represent index of 'cut' of nums1 and nums2 respectively
        # nums1[0: i] and nums2[0: j] are the smaller half of the entire list
        # nums2[i: ] and nums2[j: ] are the larger half of the entire list
        # also requires nums1[i-1] <= nums2[j] and nums2[j-1] <= nums1[i]
        # if m+n is even, median = max(nums1[i-1], nums2[j-1]) + min(nums2[i], nums2[j]) / 2
        # if m+n is odd, median is included in the smaller half, therefore median = max(nums1[i-1], nums2[j-1])
        
        # search range of i
        i_up = m
        i_low = 0
        i = Solution.binarySearch(i_low, i_up)
        j = int((m+n+1)/2 - i)
        
        # if i is found
        done = False
        
        while not done:
            # corner case 1
            if i == 0: # no need to discuss nums1[i-1] <= nums2[j]
                if nums2[j-1] <= nums1[i]:
                    done = True
                else:
                    # i should increase
                    i_low = i + 1
                    i = Solution.binarySearch(i_low, i_up)
                    j = int((m+n+1)/2 - i)
            
            # corner case 2            
            elif j == 0: # no need to discuss nums2[j-1] <= nums1[i]
                if nums1[i-1] <= nums2[j]:
                    done = True
                else:
                    # i should decrease
                    i_up = i - 1
                    i = Solution.binarySearch(i_low, i_up)
                    j = int((m+n+1)/2 - i)

            # corner case 3, could happen along with corner case 2            
            if i == m: # no need to discuss nums2[j-1] <= nums1[i]
                if nums1[i-1] <= nums2[j]:
                    done = True
                else:
                    # i should decrease
                    i_up = i - 1
                    i = Solution.binarySearch(i_low, i_up)
                    j = int((m+n+1)/2 - i)

            # corner case 4, could happen along with corner case 1        
            elif j == n: # no need to discuss nums1[i-1] <= nums2[j]
                if i < 0 or nums2[j-1] <= nums1[i]:
                    done = True
                else:
                    # i should increase
                    i_low = i + 1
                    print(i_low, ",", i_up)
                    i = Solution.binarySearch(i_low, i_up)
                    j = int((m+n+1)/2 - i)
            
            # if no corner cases
            if (i != 0) and (j != 0) and (i != m) and (j != n):
                # all requirements satisfied
                if (nums1[i-1] <= nums2[j]) and (nums2[j-1] <= nums1[i]):
                    done = True

                elif nums1[i-1] > nums2[j]:
                    # i should decrease
                    i_up = i - 1
                    i = Solution.binarySearch(i_low, i_up)
                    j = int((m+n+1)/2 - i)

                else:
                    # i should increase
                    i_low = i + 1
                    i = Solution.binarySearch(i_low, i_up)
                    j = int((m+n+1)/2 - i)
        
        # return from the loop, get the result
        # if out of range, then remove
        if even:
            if i == 0:
                if j != n:
                    return (nums2[j-1] + min(nums1[i], nums2[j])) / 2
                else:
                    return (nums2[j-1] + nums1[i]) / 2
            elif j == 0:
                if i != m:
                    return (nums1[i-1] + min(nums1[i], nums2[j])) / 2
                else:
                    return (nums1[i-1] + nums2[j]) / 2
            elif i == m:
                return (max(nums1[i-1], nums2[j-1]) + nums2[j]) / 2
            elif j == n:
                return (max(nums1[i-1], nums2[j-1]) + nums1[i]) / 2
            else:
                return (max(nums1[i-1], nums2[j-1]) + min(nums1[i], nums2[j])) / 2
        else:
            if i == 0:                
                return nums2[j-1]
            elif j == 0:
                return nums1[i-1]
            else:
                return max(nums1[i-1], nums2[j-1])
    
    
    