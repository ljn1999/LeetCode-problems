// 2022.06.29
// Problem Statement:
// https://leetcode.com/problems/intersection-of-two-linked-lists/

// idea: get the length difference of the 2 linkedlists and move the longer one by difference,
// then move 2 pointers together, until they reach an intersection
// another idea without knowing the length difference:
// https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
// in first iteration, reset pointer to another's head if reaches the tail,
// so the next time they both reach to the tail at the same time, as both of them travels m+n nodes,
// but do an early stop when they intersect, as the intersection part is identical 
// and won't introduce difference in travel time
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1=0, length2=0;
        ListNode ptr1=headA, ptr2=headB;
        while (ptr1!=null) {
            length1++;
            ptr1 = ptr1.next;
        }
        while (ptr2!=null) {
            length2++;
            ptr2 = ptr2.next;
        }
        // reset 2 pointers
        ptr1=headA;
        ptr2=headB;
        // move the longer one by difference
        if (length1>length2) {
            for (int i=0; i<length1-length2; i++) {
                ptr1 = ptr1.next;
            }
        } else {
            for (int i=0; i<length2-length1; i++) {
                ptr2 = ptr2.next;
            }
        }
        
        while (ptr1!=ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}