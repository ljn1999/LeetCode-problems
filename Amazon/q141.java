// 2022.06.16 midnight
// Problem Statement:
// https://leetcode.com/problems/linked-list-cycle/

// idea: use fast and slow pointer
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head, slow=head;
        while (true) {
            if (slow==null || fast==null || fast.next==null) return false; // if reaches the null, no circle
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
            if (fast==slow) return true; // if pointing to the same node, has circle
        }
    }
}